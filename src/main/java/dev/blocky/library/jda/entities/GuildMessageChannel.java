/**
 * Copyright 2022 Dominic (aka. BlockyDotJar)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.blocky.library.jda.entities;

import dev.blocky.library.jda.Utility;
import dev.blocky.library.jda.enums.SafetyClear;
import dev.blocky.library.jda.impl.DataImpl;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.MessageAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Represents a Discord channel that can have {@link net.dv8tion.jda.api.entities.Message messages}
 * and files sent to it.
 *
 * @author BlockyDotJar
 * @version v2.1.0
 * @since v1.0.0-alpha.1
 */
public class GuildMessageChannel extends Utility
{
    private static final Logger logger = LoggerFactory.getLogger(GuildMessageChannel.class);
    private MessageChannel channel;
    private Member member;

    /**
     * Constructs a <b>new</b> {@link GuildMessageChannel guild message channel}.
     * <br> This is a private constructor, because it should not be accessed for other classes.
     */
    private GuildMessageChannel()
    {
    }

    /**
     * Constructs a <b>new</b> {@link GuildMessageChannel guild message channel}.
     * <br> This is a private constructor, because it should not be accessed for other classes.
     *
     * @param channel The {@link MessageChannel message channel}, which should be used to get {@link GuildMessageChannel guild message channel}
     * @param member  The {@link Member member}, which should be used to get {@link GuildMessageChannel guild message channel}
     */
    private GuildMessageChannel(@NotNull MessageChannel channel, @Nullable Member member)
    {
        this.channel = channel;
        this.member = member;


        if (JDALogger.SLF4J_ENABLED)
        {
            if (!channel.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MESSAGES) && !member.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MEMBERS))
            {
                logger.warn("Both the GUILD_MESSAGES and the GUILD_MEMBERS intents are not enabled, which means, that some stuff could not work.");
                return;
            }

            if (!channel.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MESSAGES))
            {
                logger.warn("The GUILD_MESSAGES intent is not enabled, which means, that some stuff could not work.");
                return;
            }

            if (!member.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MEMBERS))
            {
                logger.warn("The GUILD_MEMBERS intent is not enabled, which means, that some stuff could not work.");
                return;
            }

            if (channel == null)
            {
                logger.error("The message channel you specify equals null.", new NullPointerException());
            }

            if (member == null)
            {
                logger.error("The member you specify equals null.", new NullPointerException());
            }
        }
    }

    /**
     * Constructs a <b>new</b> {@link GuildMessageChannel guild message channel}.
     * <br> This is a private constructor, because it should not be accessed for other classes.
     *
     * @param channel The {@link MessageChannel message channel}, which should be used to get {@link GuildMessageChannel guild message channel}
     */
    private GuildMessageChannel(@NotNull MessageChannel channel)
    {
        this.channel = channel;

        if (JDALogger.SLF4J_ENABLED)
        {
            if (!channel.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MESSAGES))
            {
                logger.warn("The GUILD_MESSAGES intent is not enabled, which means, that some stuff could not work.");
                return;
            }

            if (channel == null)
            {
                logger.error("The message channel you specify equals null.", new NullPointerException());
            }
        }
    }

    /**
     * Constructs a <b>new</b> {@link GuildMessageChannel guild message channel} instance. If you don't
     * initialize a {@link net.dv8tion.jda.api.entities.MessageChannel message channel} or a {@link net.dv8tion.jda.api.entities.Member member},
     * {@link GuildMessageChannel guild message channel} always will be <b>null</b>.
     *
     * @param channel The {@link net.dv8tion.jda.api.entities.MessageChannel message channel}, which
     *                should be initialized
     * @param member  The {@link net.dv8tion.jda.api.entities.Member member}, which
     *                should be initialized
     * @return A <b>new</b> {@link GuildMessageChannel guild message channel} instance
     */
    @NotNull
    public static GuildMessageChannel set(@NotNull MessageChannel channel, @Nullable Member member)
    {
        return new GuildMessageChannel(channel, member);
    }

    /**
     * Constructs a <b>new</b> {@link GuildMessageChannel guild message channel} instance. If you don't
     * initialize a {@link net.dv8tion.jda.api.entities.MessageChannel message channel},
     * {@link GuildMessageChannel guild message channel} always will be <b>null</b>.
     *
     * @param channel The {@link net.dv8tion.jda.api.entities.MessageChannel message channel}, which
     *                should be initialized
     * @return A <b>new</b> {@link GuildMessageChannel guild message channel} instance
     */
    @NotNull
    public static GuildMessageChannel set(@NotNull MessageChannel channel)
    {
        return new GuildMessageChannel(channel);
    }

    /**
     * The author of the {@link net.dv8tion.jda.api.entities.Message message} received as {@link Member member} object.
     *
     * @return The author of the {@link net.dv8tion.jda.api.entities.Message message} as null-able member object
     */
    @Nullable
    public Member getMember()
    {
        return member;
    }

    /**
     * The {@link MessageChannel message channel} for this {@link Message message}.
     *
     * @return The {@link MessageChannel message channel}
     */
    @NotNull
    public MessageChannel getChannel()
    {
        return channel;
    }

    /**
     * Make the message a reply to the referenced message.
     * <br> You can only reply to messages from the same channel!
     * <br> This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param content The message content
     * @param message The target message
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction reply(@NotNull CharSequence content, @NotNull Message message)
    {
        MessageAction action = channel.sendMessage(content);
        return action.reference(message);
    }

    /**
     * Make the message a reply to the referenced message.
     * <br> You can only reply to messages from the same channel!
     * <br> This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param content   The message content
     * @param messageId The target message
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction replyById(@NotNull CharSequence content, @NotNull String messageId)
    {
        MessageAction action = channel.sendMessage(content);
        return action.referenceById(messageId);
    }

    /**
     * Make the message a reply to the referenced message.
     * <br> You can only reply to messages from the same channel!
     * <br> This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param content   The message content
     * @param messageId The target message
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction replyById(@NotNull CharSequence content, long messageId)
    {
        MessageAction action = channel.sendMessage(content);
        return action.referenceById(messageId);
    }

    /**
     * Make the message a reply to the referenced message.
     * <br> You can only reply to messages from the same channel!
     * <br> This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param embed   The {@link MessageEmbed message embed} to send
     * @param message The target message
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction replyEmbeds(@NotNull MessageEmbed embed, @NotNull Message message)
    {
        MessageAction action = channel.sendMessageEmbeds(embed);
        return action.reference(message);
    }

    /**
     * Make the message a reply to the referenced message.
     * <br> You can only reply to messages from the same channel!
     * <br> This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param embed     The {@link MessageEmbed message embed} to send
     * @param messageId The target message
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction replyEmbedsById(@NotNull MessageEmbed embed, @NotNull String messageId)
    {
        MessageAction action = channel.sendMessageEmbeds(embed);
        return action.referenceById(messageId);
    }

    /**
     * Make the message a reply to the referenced message.
     * <br> You can only reply to messages from the same channel!
     * <br> This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param embed     The {@link MessageEmbed message embed} to send
     * @param messageId The target message
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction replyEmbedsById(@NotNull MessageEmbed embed, long messageId)
    {
        MessageAction action = channel.sendMessageEmbeds(embed);
        return action.referenceById(messageId);
    }

    /**
     * Make the message a reply to the referenced message.
     * <br>  You can only reply to messages from the same channel!
     * <br> This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param format  The string that should be formatted, if this is null or empty the content of the message would be
     *               empty and cause a builder exception
     * @param args    The arguments for your format
     * @param message The target message
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction replyFormat(@NotNull String format, @NotNull Object args, @NotNull Message message)
    {
        MessageAction action = channel.sendMessageFormat(format, args);
        return action.reference(message);
    }

    /**
     * Make the message a reply to the referenced message.
     * <br>  You can only reply to messages from the same channel!
     * <br> This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param format    The string that should be formatted, if this is null or empty the content of the message would
     *                  be empty and cause a builder exception
     * @param args      The arguments for your format
     * @param messageId The target message
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction replyFormatById(@NotNull String format, @NotNull Object args, @NotNull String messageId)
    {
        MessageAction action = channel.sendMessageFormat(format, args);
        return action.referenceById(messageId);
    }

    /**
     * Make the message a reply to the referenced message.
     * <br> You can only reply to messages from the same channel!
     * <br> This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param format    The string that should be formatted, if this is null or empty the content of the message would
     *                  be empty and cause a builder exception
     * @param args      The arguments for your format
     * @param messageId The target message
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction replyFormatById(@NotNull String format, @NotNull Object args, long messageId)
    {
        MessageAction action = channel.sendMessageFormat(format, args);
        return action.referenceById(messageId);
    }

    /**
     * Make the message a reply to the referenced message.
     * <br> You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting the boolean parameter
     * <b>ping enabled</b> to <b>false</b>.
     * <br> This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param content     The message content
     * @param message     The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction reply(@NotNull CharSequence content, @NotNull Message message, boolean pingEnabled)
    {
        MessageAction action = channel.sendMessage(content);
        return action.reference(message).mentionRepliedUser(pingEnabled);
    }

    /**
     * Make the message a reply to the referenced message.
     * <br> You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting the boolean parameter
     * <b>ping enabled</b> to <b>false</b>.
     * <br> This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param content     The message content
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction replyById(@NotNull CharSequence content, @NotNull String messageId, boolean pingEnabled)
    {
        MessageAction action = channel.sendMessage(content);
        return action.referenceById(messageId).mentionRepliedUser(pingEnabled);
    }

    /**
     * Make the message a reply to the referenced message.
     * <br> You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting the boolean parameter
     * <b>ping enabled</b> to <b>false</b>.
     * <br> This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param content     The message content
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction replyById(@NotNull CharSequence content, long messageId, boolean pingEnabled)
    {
        MessageAction action = channel.sendMessage(content);
        return action.referenceById(messageId).mentionRepliedUser(pingEnabled);
    }

    /**
     * Make the message a reply to the referenced message.
     * <br> You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting the boolean parameter
     * <b>ping enabled</b> to <b>false</b>.
     * <br>  This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param embed       The {@link MessageEmbed message embed} to send
     * @param message     The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction replyEmbeds(@NotNull MessageEmbed embed, @NotNull Message message, boolean pingEnabled)
    {
        MessageAction action = channel.sendMessageEmbeds(embed);
        return action.reference(message).mentionRepliedUser(pingEnabled);
    }

    /**
     * Make the message a reply to the referenced message.
     * <br> You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting the boolean parameter
     * <b>ping enabled</b> to <b>false</b>.
     * <br> This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param embed       The {@link MessageEmbed message embed} to send
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction replyEmbedsById(@NotNull MessageEmbed embed, @NotNull String messageId, boolean pingEnabled)
    {
        MessageAction action = channel.sendMessageEmbeds(embed);
        return action.referenceById(messageId).mentionRepliedUser(pingEnabled);
    }

    /**
     * Make the message a reply to the referenced message.
     * <br> You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting the boolean parameter
     * <b>ping enabled</b> to <b>false</b>.
     * <br> This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param embed       The {@link MessageEmbed message embed} to send
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction replyEmbedsById(@NotNull MessageEmbed embed, long messageId, boolean pingEnabled)
    {
        MessageAction action = channel.sendMessageEmbeds(embed);
        return action.referenceById(messageId).mentionRepliedUser(pingEnabled);
    }

    /**
     * Make the message a reply to the referenced message.
     * <br> You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting the boolean parameter
     * <b>ping enabled</b> to <b>false</b>.
     * <br> This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param format      The string that should be formatted, if this is null or empty the content of the message would
     *                    be empty and cause a builder exception
     * @param args        The arguments for your format
     * @param message     The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction replyFormat(@NotNull String format, @NotNull Object args, @NotNull Message message, boolean pingEnabled)
    {
        MessageAction action = channel.sendMessageFormat(format, args);
        return action.reference(message).mentionRepliedUser(pingEnabled);
    }

    /**
     * Make the message a reply to the referenced message.
     * <br> You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting the boolean parameter
     * <b>ping enabled</b> to <b>false</b>.
     * <br> This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param format      The string that should be formatted, if this is null or empty the content of the message would
     *                    be empty and cause a builder exception
     * @param args        The arguments for your format
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction replyFormatById(@NotNull String format, @NotNull Object args, @NotNull String messageId, boolean pingEnabled)
    {
        MessageAction action = channel.sendMessageFormat(format, args);
        return action.referenceById(messageId).mentionRepliedUser(pingEnabled);
    }

    /**
     * Make the message a reply to the referenced message.
     * <br> You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting the boolean parameter
     * <b>ping enabled</b> to <b>false</b>.
     * <br> This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission#MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD
     * CHANNEL_PINNED_AD MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD} and similar.
     *
     * @param format      The string that should be formatted, if this is null or empty the content of the message would
     *                    be empty and cause a builder exception
     * @param args        The arguments for your format
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction message action} for chaining convenience
     */
    @NotNull
    public MessageAction replyFormatById(@NotNull String format, @NotNull Object args, long messageId, boolean pingEnabled)
    {
        MessageAction action = channel.sendMessageFormat(format, args);
        return action.referenceById(messageId).mentionRepliedUser(pingEnabled);
    }

    /**
     * Convenience method to delete messages in the most efficient way available.
     * No checks will be done to prevent failures, use {@link java.util.concurrent.CompletionStage#exceptionally(Function)
     * CompletionStage#exceptionally(Function)} to handle failures.
     *
     * @param amount The amount of messages to delete
     * @param clear  The {@link SafetyClear safety clear} option, which helps for specifying different message types, which will not be deleted
     * @return A list of futures representing all deletion task
     */
    @Nullable
    public List<CompletableFuture<Void>> purgeMessages(int amount, @Nullable SafetyClear clear)
    {
        return channel.purgeMessages(checkClearSafety(clear, channel, amount));
    }

    /**
     * Convenience method to delete a complete {@link MessageChannel message channel} in the most efficient way available.
     * No checks will be done to prevent failures, use {@link java.util.concurrent.CompletionStage#exceptionally(Function)
     * CompletionStage#exceptionally(Function)} to handle failures.
     *
     * @param clear The {@link SafetyClear safety clear} option, which helps for specifying different message types, which will not be deleted
     * @return A list of futures representing all deletion task
     */
    @Nullable
    public List<CompletableFuture<Void>> purgeChannel(@Nullable SafetyClear clear)
    {
        return channel.purgeMessages(checkChannelClearSafety(clear, channel));
    }

    /**
     * Convenience method to delete a complete {@link MessageChannel message channel} in the most efficient way available.
     * No checks will be done to prevent failures, use {@link java.util.concurrent.CompletionStage#exceptionally(Function)
     * CompletionStage#exceptionally(Function)} to handle failures.
     *
     * @return A list of futures representing all deletion task
     */
    @NotNull
    public List<CompletableFuture<Void>> purgeChannel()
    {
        return channel.purgeMessages(checkChannelClearSafety(null, channel));
    }

    /**
     * Checks if the content, you specified, is written in this channel.
     *
     * @param content     The message content, which should be checked
     * @param checkAmount The amount of messages, which should be checked
     * @return
     * <b>true -</b> If the content, you specified, is written in this channel
     * <br><b>false -</b> If the content, you specified, is not written in this channel
     */
    public boolean containsMessage(@NotNull CharSequence content, int checkAmount)
    {
        for (Message message : channel.getIterableHistory().cache(false))
        {
            if (message.getContentRaw().contentEquals(content))
            {
                return true;
            }

            if (checkAmount-- <= 0)
            {
                break;
            }
        }
        return false;
    }

    /**
     * Gets all the messages from a specific member in this channel. (max. 1000 messages per channel)
     *
     * @return The written messages of the specified member in this channel
     */
    @NotNull
    public List<Message> getMessagesByUser()
    {
        return channel.getIterableHistory()
                .stream()
                .limit(1000)
                .filter(m -> m.getAuthor().equals(member.getUser()))
                .collect(Collectors.toList());
    }

    /**
     * This works like a normal message sending, but with more given options and a delay between using this.
     * <br> You must specify a delay to time out a command. (the long delay in seconds <b>must not equal to 0</b>. If this
     * is true a {@link IllegalArgumentException illegal argument exception} will be thrown).
     * <br> (The same is applicable for numbers under 0)
     * <br> You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
     * equals null, there will be sent a default error message.
     * <br> Another option you can use a specified {@link TimeUnit time} like {@link TimeUnit#MINUTES minutes},
     * {@link TimeUnit#HOURS hours} or even {@link TimeUnit#DAYS days}.
     * <br> (if {@link TimeUnit the time unit} equals null, there will be used a default {@link TimeUnit time unit}: {@link TimeUnit#SECONDS TimeUnit#SECONDS})
     *
     * @param message         The {@link MessageAction message action}, which should be used
     * @param delayInSeconds The delay for the executing command in seconds
     * @param delayMessage   The error message, which should appear, if the member has not waited for the delay yet
     * @param unit           The {@link TimeUnit time unit}, which is used for specifying the type of time for the delay
     * @return The specified {@link MessageAction message action}
     */
    @NotNull
    public MessageAction sendTimeoutedMessage(@NotNull MessageAction message, long delayInSeconds, @Nullable MessageAction delayMessage,
                                              @Nullable TimeUnit unit)
    {
        if (message == null)
        {
            logger.error("The default message, which you are specifying, equals null.", new NullPointerException());
        }

        try
        {
            long id = member.getIdLong();
            long time;
            if (DataImpl.getHashMap().containsKey(id))
            {
                time = DataImpl.getHashMap().get(id);

                if ((System.currentTimeMillis() - time) >= calculateDelay(unit, delayInSeconds))
                {
                    DataImpl.getHashMap().put(id, System.currentTimeMillis());
                    return message;
                }
                else
                {
                    if (delayMessage == null)
                    {
                        DecimalFormat df = new DecimalFormat("0.00");
                        delayMessage = channel.sendMessage(member.getEffectiveName() + ", you must wait "
                                + df.format((calculateDelay(unit, delayInSeconds) - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛");
                    }
                    else
                    {
                        return delayMessage;
                    }
                }
            }
            else
            {
                DataImpl.getHashMap().put(id, System.currentTimeMillis());
                return message;
            }
        }
        catch (NullPointerException e)
        {
            logger.error("The message Action, which you are specifying, equals null.", e);
        }
        return delayMessage;
    }

    /**
     * This works like a normal message sending, but with more given options and a delay between using this.
     * <br> You must specify a delay to time out a command. (the long delay in seconds <b>must not equal to 0</b>. If this
     * is true a {@link IllegalArgumentException illegal argument exception} will be thrown).
     * <br> (The same is applicable for numbers under 0)
     * <br> You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
     * equals null, there will be sent a default error message.
     *
     * @param message         The {@link MessageAction message action}, which should be used
     * @param delayInSeconds The delay for the executing command in seconds
     * @param delayMessage   The error message, which should appear, if the member has not waited for the delay yet
     * @return The specified {@link MessageAction message action}
     */
    @NotNull
    public MessageAction sendTimeoutedMessage(@NotNull MessageAction message, long delayInSeconds, @Nullable MessageAction delayMessage)
    {
        if (message == null)
        {
            logger.error("The default message, which you are specifying, equals null.", new NullPointerException());
        }

        try
        {
            long id = member.getIdLong();
            long time;
            if (DataImpl.getHashMap().containsKey(id))
            {
                time = DataImpl.getHashMap().get(id);

                if ((System.currentTimeMillis() - time) >= calculateDelay(null, delayInSeconds))
                {
                    DataImpl.getHashMap().put(id, System.currentTimeMillis());
                    return message;
                }
                else
                {
                    if (delayMessage == null)
                    {
                        DecimalFormat df = new DecimalFormat("0.00");
                        delayMessage = channel.sendMessage(member.getEffectiveName() + ", you must wait "
                                + df.format((calculateDelay(null, delayInSeconds) - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛");
                    }
                    else
                    {
                        return delayMessage;
                    }
                }
            }
            else
            {
                DataImpl.getHashMap().put(id, System.currentTimeMillis());
                return message;
            }
        }
        catch (NullPointerException e)
        {
            logger.error("The message action, which you are specifying, equals null.", e);
        }
        return delayMessage;
    }

    /**
     * This works like a normal message sending, but with more given options and a delay between using this.
     * <br> You must specify a delay to time out a command. (the long delay in seconds <b>must not equal to 0</b>. If this
     * is true a {@link IllegalArgumentException illegal argument exception} will be thrown).
     * <br> (The same is applicable for numbers under 0)
     * <br> You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
     * equals null, there will be sent a default error message.
     * <br> Another option you can use a specified {@link TimeUnit time} like {@link TimeUnit#MINUTES minutes},
     * {@link TimeUnit#HOURS hours} or even {@link TimeUnit#DAYS days}.
     * <br> (if {@link TimeUnit the time unit} equals null, there will be used a default {@link TimeUnit time unit}: {@link TimeUnit#SECONDS TimeUnit#SECONDS})
     *
     * @param message         The {@link ReplyCallbackAction reply callback action}, which should be used
     * @param delayInSeconds The delay for the executing command in seconds
     * @param delayMessage   The error message, which should appear, if the member has not waited for the delay yet
     * @param unit           The {@link TimeUnit time unit}, which is used for specifying the type of time for the delay
     * @return The specified {@link MessageAction message action}
     */
    @NotNull
    public ReplyCallbackAction replyTimeoutedMessage(@NotNull ReplyCallbackAction message, long delayInSeconds, @Nullable ReplyCallbackAction delayMessage,
                                                     @Nullable TimeUnit unit)
    {
        if (message == null)
        {
            logger.error("The default message, which you are specifying, equals null.", new NullPointerException());
        }

        try
        {
            long id = member.getIdLong();
            long time;
            if (DataImpl.getHashMap().containsKey(id))
            {
                time = DataImpl.getHashMap().get(id);

                if ((System.currentTimeMillis() - time) >= calculateDelay(unit, delayInSeconds))
                {
                    DataImpl.getHashMap().put(id, System.currentTimeMillis());
                    return message;
                }
                else
                {
                    if (delayMessage == null)
                    {
                        DecimalFormat df = new DecimalFormat("0.00");
                        channel.sendMessage(member.getEffectiveName() + ", you must wait "
                                + df.format((calculateDelay(unit, delayInSeconds) - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛").queue();
                    }
                    else
                    {
                        return delayMessage;
                    }
                }
            }
            else
            {
                DataImpl.getHashMap().put(id, System.currentTimeMillis());
                return message;
            }
        }
        catch (NullPointerException e)
        {
            logger.error("The reply callback action, which you are specifying, equals null.", e);
        }
        return delayMessage;
    }

    /**
     * This works like a normal message sending, but with more given options and a delay between using this.
     * <br> You must specify a delay to time out a command. (the long delay in seconds <b>must not equal to 0</b>. If this
     * is true a {@link IllegalArgumentException illegal argument exception} will be thrown).
     * <br> (The same is applicable for numbers under 0)
     * <br> You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
     * equals null, there will be sent a default error message.
     *
     * @param message         The {@link ReplyCallbackAction reply callback action}, which should be used
     * @param delayInSeconds The delay for the executing command in seconds
     * @param delayMessage   The error message, which should appear, if the member has not waited for the delay yet
     * @return The specified {@link MessageAction message action}
     */
    @NotNull
    public ReplyCallbackAction replyTimeoutedMessage(@NotNull ReplyCallbackAction message, long delayInSeconds, @Nullable ReplyCallbackAction delayMessage)
    {
        if (message == null)
        {
            logger.error("The default message, which you are specifying, equals null.", new NullPointerException());
        }

        try
        {
            long id = member.getIdLong();
            long time;
            if (DataImpl.getHashMap().containsKey(id))
            {
                time = DataImpl.getHashMap().get(id);

                if ((System.currentTimeMillis() - time) >= calculateDelay(null, delayInSeconds))
                {
                    DataImpl.getHashMap().put(id, System.currentTimeMillis());
                    return message;
                }
                else
                {
                    if (delayMessage == null)
                    {
                        DecimalFormat df = new DecimalFormat("0.00");
                        channel.sendMessage(member.getEffectiveName() + ", you must wait "
                                + df.format((calculateDelay(null, delayInSeconds) - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛").queue();
                    }
                    else
                    {
                        return delayMessage;
                    }
                }
            }
            else
            {
                DataImpl.getHashMap().put(id, System.currentTimeMillis());
                return message;
            }
        }
        catch (NullPointerException e)
        {
            logger.error("The reply callback action, which you are specifying, equals null.", e);
        }
        return delayMessage;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        GuildTextChannel that = (GuildTextChannel) o;

        return channel.equals(that.getChannel()) && Objects.equals(member, that.getMember());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(channel, member);
    }

    @Override
    public String toString()
    {
        return "GuildMessageChannel{" +
                "channel=" + channel +
                ", member=" + member +
                '}';
    }
}