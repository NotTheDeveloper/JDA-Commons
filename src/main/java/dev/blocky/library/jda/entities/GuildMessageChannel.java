/**
 * Copyright 2022 Dominic (aka. BlockyDotJar)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.blocky.library.jda.entities;

import dev.blocky.library.jda.Utility;
import dev.blocky.library.jda.entities.impl.DataImpl;
import dev.blocky.library.jda.enums.SafetyClear;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.requests.restaction.MessageAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Represents a Discord channel that can have {@link net.dv8tion.jda.api.entities.Message Messages}
 * and files sent to it.
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0-alpha.1
 */
public class GuildMessageChannel extends Utility {
    private static final Logger logger = LoggerFactory.getLogger(GuildMessageChannel.class);
    private MessageChannel channel;
    private Member member;

    /**
     * Constructs a <b>new</b> {@link GuildMessageChannel Guild Message Channel}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     */
    private GuildMessageChannel() {
    }

    /**
     * Constructs a <b>new</b> {@link GuildMessageChannel Guild Message Channel}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     *
     * @param channel The {@link MessageChannel Message Channel}, which should be used to get {@link GuildMessageChannel Guild Message Channel}
     * @param member  The {@link Member Member}, which should be used to get {@link GuildMessageChannel Guild Message Channel}
     */
    private GuildMessageChannel(@NotNull MessageChannel channel, @Nullable Member member) {
        this.channel = channel;
        this.member = member;

        if (channel == null) {
            logger.error("The Message Channel you specify equals null", new NullPointerException());
        }

        if (member == null) {
            logger.error("The Member you specify equals null", new NullPointerException());
        }
    }

    /**
     * Constructs a <b>new</b> {@link GuildMessageChannel Guild Message Channel}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     *
     * @param channel The {@link MessageChannel Message Channel}, which should be used to get {@link GuildMessageChannel Guild Message Channel}
     */
    private GuildMessageChannel(@NotNull MessageChannel channel) {
        this.channel = channel;

        if (channel == null) {
            logger.error("The Message Channel you specify equals null", new NullPointerException());
        }
    }

    /**
     * Constructs a <b>new</b> {@link GuildMessageChannel Guild Message Channel} instance. If you don't
     * initialize a {@link net.dv8tion.jda.api.entities.MessageChannel Message Channel} or a {@link net.dv8tion.jda.api.entities.Member Member},
     * {@link GuildMessageChannel Guild Message Channel} always will be <b>null</b>.
     *
     * @param channel The {@link net.dv8tion.jda.api.entities.MessageChannel Message Channel}, which
     *                should be initialized.
     * @param member  The {@link net.dv8tion.jda.api.entities.Member Member}, which
     *                should be initialized.
     * @return A <b>new</b> {@link GuildMessageChannel Guild Message Channel} instance
     */
    @NotNull
    public static GuildMessageChannel set(@NotNull MessageChannel channel, @Nullable Member member) {
        return new GuildMessageChannel(channel, member);
    }

    /**
     * Constructs a <b>new</b> {@link GuildMessageChannel Guild Message Channel} instance. If you don't
     * initialize a {@link net.dv8tion.jda.api.entities.MessageChannel Message Channel},
     * {@link GuildMessageChannel Guild Message Channel} always will be <b>null</b>.
     *
     * @param channel The {@link net.dv8tion.jda.api.entities.MessageChannel Message Channel}, which
     *                should be initialized.
     * @return A <b>new</b> {@link GuildMessageChannel Guild Message Channel} instance
     */
    @NotNull
    public static GuildMessageChannel set(@NotNull MessageChannel channel) {
        return new GuildMessageChannel(channel);
    }

    /**
     * The Author of the {@link net.dv8tion.jda.api.entities.Message Message} received as {@link Member Member} object.
     *
     * @return The Author of the {@link net.dv8tion.jda.api.entities.Message Message} as null-able Member object.
     */
    @Nullable
    public Member getMember() {
        return member;
    }

    /**
     * The {@link MessageChannel Message Channel} for this {@link Message Message}.
     *
     * @return The {@link MessageChannel Message Channel}
     */
    @NotNull
    public MessageChannel getChannel() {
        return channel;
    }

    /**
     * First sends a normal message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param content The message content
     * @param message The target message
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction reply(@NotNull CharSequence content, @NotNull Message message) {
        MessageAction action = channel.sendMessage(content);
        return action.reference(message);
    }

    /**
     * First sends a normal message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param content   The message content
     * @param messageId The target message
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction replyById(@NotNull CharSequence content, @NotNull String messageId) {
        MessageAction action = channel.sendMessage(content);
        return action.referenceById(messageId);
    }

    /**
     * First sends a normal message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param content   The message content
     * @param messageId The target message
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction replyById(@NotNull CharSequence content, long messageId) {
        MessageAction action = channel.sendMessage(content);
        return action.referenceById(messageId);
    }

    /**
     * First sends an embedded message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param embed   The {@link MessageEmbed Message Embed} to send
     * @param message The target message
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction replyEmbeds(@NotNull MessageEmbed embed, @NotNull Message message) {
        MessageAction action = channel.sendMessageEmbeds(embed);
        return action.reference(message);
    }

    /**
     * First sends an embedded message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param embed     The {@link MessageEmbed Message Embed} to send
     * @param messageId The target message
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction replyEmbedsById(@NotNull MessageEmbed embed, @NotNull String messageId) {
        MessageAction action = channel.sendMessageEmbeds(embed);
        return action.referenceById(messageId);
    }

    /**
     * First sends an embedded message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param embed     The {@link MessageEmbed Message Embed} to send
     * @param messageId The target message
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction replyEmbedsById(@NotNull MessageEmbed embed, long messageId) {
        MessageAction action = channel.sendMessageEmbeds(embed);
        return action.referenceById(messageId);
    }

    /**
     * First sends a formatted message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param format  The string that should be formatted, if this is null or empty the content of the Message would be empty and cause a builder exception.
     * @param args    The arguments for your format
     * @param message The target message
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction replyFormat(@NotNull String format, @NotNull Object args, @NotNull Message message) {
        MessageAction action = channel.sendMessageFormat(format, args);
        return action.reference(message);
    }

    /**
     * First sends a formatted message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param format    The string that should be formatted, if this is null or empty the content of the Message would be empty and cause a builder exception.
     * @param args      The arguments for your format
     * @param messageId The target message
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction replyFormatById(@NotNull String format, @NotNull Object args, @NotNull String messageId) {
        MessageAction action = channel.sendMessageFormat(format, args);
        return action.referenceById(messageId);
    }

    /**
     * First sends a formatted message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param format    The string that should be formatted, if this is null or empty the content of the Message would be empty and cause a builder exception.
     * @param args      The arguments for your format
     * @param messageId The target message
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction replyFormatById(@NotNull String format, @NotNull Object args, long messageId) {
        MessageAction action = channel.sendMessageFormat(format, args);
        return action.referenceById(messageId);
    }

    /**
     * First sends a normal message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param content     The message content
     * @param message     The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction reply(@NotNull CharSequence content, @NotNull Message message, boolean pingEnabled) {
        MessageAction action = channel.sendMessage(content);
        return action.reference(message).mentionRepliedUser(pingEnabled);
    }

    /**
     * First sends a normal message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param content     The message content
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction replyById(@NotNull CharSequence content, @NotNull String messageId, boolean pingEnabled) {
        MessageAction action = channel.sendMessage(content);
        return action.referenceById(messageId).mentionRepliedUser(pingEnabled);
    }

    /**
     * First sends a normal message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param content     The message content
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction replyById(@NotNull CharSequence content, long messageId, boolean pingEnabled) {
        MessageAction action = channel.sendMessage(content);
        return action.referenceById(messageId).mentionRepliedUser(pingEnabled);
    }

    /**
     * First sends an embedded message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param embed       The {@link MessageEmbed Message Embed} to send
     * @param message     The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction replyEmbeds(@NotNull MessageEmbed embed, @NotNull Message message, boolean pingEnabled) {
        MessageAction action = channel.sendMessageEmbeds(embed);
        return action.reference(message).mentionRepliedUser(pingEnabled);
    }

    /**
     * First sends an embedded message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param embed       The {@link MessageEmbed Message Embed} to send
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction replyEmbedsById(@NotNull MessageEmbed embed, @NotNull String messageId, boolean pingEnabled) {
        MessageAction action = channel.sendMessageEmbeds(embed);
        return action.referenceById(messageId).mentionRepliedUser(pingEnabled);
    }

    /**
     * First sends an embedded message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param embed       The {@link MessageEmbed Message Embed} to send
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction replyEmbedsById(@NotNull MessageEmbed embed, long messageId, boolean pingEnabled) {
        MessageAction action = channel.sendMessageEmbeds(embed);
        return action.referenceById(messageId).mentionRepliedUser(pingEnabled);
    }

    /**
     * First sends a formatted message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param format      The string that should be formatted, if this is null or empty the content of the Message would be empty and cause a builder exception.
     * @param args        The arguments for your format
     * @param message     The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction replyFormat(@NotNull String format, @NotNull Object args, @NotNull Message message, boolean pingEnabled) {
        MessageAction action = channel.sendMessageFormat(format, args);
        return action.reference(message).mentionRepliedUser(pingEnabled);
    }

    /**
     * First sends a formatted message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param format      The string that should be formatted, if this is null or empty the content of the Message would be empty and cause a builder exception.
     * @param args        The arguments for your format
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction replyFormatById(@NotNull String format, @NotNull Object args, @NotNull String messageId, boolean pingEnabled) {
        MessageAction action = channel.sendMessageFormat(format, args);
        return action.referenceById(messageId).mentionRepliedUser(pingEnabled);
    }

    /**
     * First sends a formatted message and then make the message a reply to the referenced message.
     * <br>
     * You can only reply to messages from the same channel!
     * This will mention the author of the target message. You can disable this through setting <b>pingEnabled</b> to <b>false</b>.
     * <p>
     * This requires {@link net.dv8tion.jda.api.Permission#MESSAGE_HISTORY Permission.MESSAGE_HISTORY} in the channel!
     * You cannot reply to system messages such as {@link net.dv8tion.jda.api.entities.MessageType#CHANNEL_PINNED_ADD CHANNEL_PINNED_AD}
     * and similar.
     *
     * @param format      The string that should be formatted, if this is null or empty the content of the Message would be empty and cause a builder exception.
     * @param args        The arguments for your format
     * @param messageId   The target message
     * @param pingEnabled If the member of the written target message should get pinged
     * @return Updated {@link MessageAction Message Action} for chaining convenience
     */
    @NotNull
    public MessageAction replyFormatById(@NotNull String format, @NotNull Object args, long messageId, boolean pingEnabled) {
        MessageAction action = channel.sendMessageFormat(format, args);
        return action.referenceById(messageId).mentionRepliedUser(pingEnabled);
    }

    /**
     * Convenience method to delete messages in the most efficient way available.
     * No checks will be done to prevent failures, use {@link java.util.concurrent.CompletionStage#exceptionally(Function)
     * CompletionStage.exceptionally(Function)} to handle failures.
     *
     * @param amount The amount of messages to delete
     * @param clear  The {@link SafetyClear Safety Clear} option, which helps for specifying different message types, which will not be deleted
     * @return {@link List List} of futures representing all deletion task
     */
    @Nullable
    public List<CompletableFuture<Void>> purgeMessages(int amount, @Nullable SafetyClear clear) {
        return channel.purgeMessages(checkClearSafety(clear, channel, amount));
    }

    /**
     * Convenience method to delete a complete {@link TextChannel Text Channel} in the most efficient way available.
     * No checks will be done to prevent failures, use {@link java.util.concurrent.CompletionStage#exceptionally(Function)
     * CompletionStage.exceptionally(Function)} to handle failures.
     *
     * @param clear The {@link SafetyClear Safety Clear} option, which helps for specifying different message types, which will not be deleted
     * @return {@link List List} of futures representing all deletion task
     */
    @Nullable
    public List<CompletableFuture<Void>> purgeChannel(@Nullable SafetyClear clear) {
        return channel.purgeMessages(Utility.checkChannelClearSafety(null, channel));
    }

    /**
     * Convenience method to delete a complete {@link TextChannel Text Channel} in the most efficient way available.
     * No checks will be done to prevent failures, use {@link java.util.concurrent.CompletionStage#exceptionally(Function)
     * CompletionStage.exceptionally(Function)} to handle failures.
     *
     * @return {@link List List} of futures representing all deletion task
     */
    @NotNull
    public List<CompletableFuture<Void>> purgeChannel() {
        return channel.purgeMessages(Utility.checkChannelClearSafety(null, channel));
    }

    /**
     * Checks if the content, you specified, is written in this channel
     *
     * @param content     The message content, which should be checked
     * @param checkAmount The Amount of messages, which should be checked
     * @return <b>true -</b> If the content, you specified, is written in this channel <br>
     * <b>false -</b> If the content, you specified, is not written in this channel
     */
    public boolean containsMessage(@NotNull CharSequence content, int checkAmount) {
        for (Message message : channel.getIterableHistory().cache(false)) {
            if (message.getContentRaw().contentEquals(content)) {
                return true;
            }
            if (checkAmount-- <= 0) {
                break;
            }
        }
        return false;
    }

    /**
     * Gets all the messages from a specific member in this channel (max. 1000 messages per channel)
     *
     * @return The written messages of the specified member in this channel
     */
    @NotNull
    public List<Message> getMessagesByUser() {
        return channel.getIterableHistory().stream()
                .limit(1000)
                .filter(m -> m.getAuthor().equals(member.getUser()))
                .collect(Collectors.toList());
    }

    /**
     * This works like a normal Message sending, but with more given options and a delay between using this.
     * <br>
     * You must specify a delay to time out a command. (the long delayInSeconds <b>must not equal to 0</b>. If this
     * is true a {@link IllegalArgumentException IllegalArgumentException} will be thrown).
     * (The same is applicable for numbers under 0)
     * <br>
     * You also can specify a delay message, which will be sent if you are under a delay. (if delayMessage
     * equals null, there will be sent a default error message)
     * <br>
     * Another option you can use a specified {@link TimeUnit Time Unit} like {@link TimeUnit#MINUTES minutes},
     * {@link TimeUnit#HOURS hours} or even {@link TimeUnit#DAYS days} (if {@link TimeUnit Time Unit} equals null,
     * there will be used a default {@link TimeUnit Time Unit}: {@link TimeUnit#SECONDS TimeUnit.SECONDS})
     *
     * @param action         The {@link MessageAction Message Action}, which should be used
     * @param delayInSeconds The delay for the executing command in seconds
     * @param delayMessage   The error message, which should appear, if the member has not waited for the delay yet
     * @param unit           The {@link TimeUnit TimeUnit}, which is used for specifying the type of time for the delay
     * @return The specified {@link MessageAction Message Actions}
     */
    @NotNull
    public MessageAction sendTimeoutedMessage(@NotNull MessageAction action, long delayInSeconds, @Nullable MessageAction delayMessage,
                                              @Nullable TimeUnit unit) {
        if (delayInSeconds == 0) {
            logger.error("The Time, which you are specifying, equals 0, so it makes no sense that you chose a Timeouted Message.", new IllegalArgumentException());
        }

        if (delayInSeconds < 0) {
            logger.error("The Time, which you are specifying can not be under 0.", new IllegalArgumentException());
        }

        try {
            long id = member.getIdLong();
            long time;
            if (DataImpl.getMap().containsKey(id)) {
                time = DataImpl.getMap().get(id);

                if ((System.currentTimeMillis() - time) >= Utility.calculateDelay(unit, delayInSeconds)) {
                    DataImpl.getMap().put(id, System.currentTimeMillis());
                    return action;
                } else {
                    if (delayMessage == null) {
                        DecimalFormat df = new DecimalFormat("0.00");
                        delayMessage = channel.sendMessage(member.getEffectiveName() + ", you must wait "
                                + df.format((Utility.calculateDelay(unit, delayInSeconds) - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛");
                    } else {
                        return delayMessage;
                    }
                }
            } else {
                DataImpl.getMap().put(id, System.currentTimeMillis());
                return action;
            }
        } catch (NullPointerException e) {
            logger.error("The Message Action, which you are specifying, equals null.", e);
        }

        return delayMessage;
    }

    /**
     * This works like a normal Message sending, but with more given options and a delay between using this.
     * <br>
     * You must specify a delay to time out a command. (the long delayInSeconds <b>must not equal to 0</b>. If this
     * is true a {@link IllegalArgumentException IllegalArgumentException} will be thrown).
     * (The same is applicable for numbers under 0)
     * <br>
     * You also can specify a delay message, which will be sent if you are under a delay. (if delayMessage
     * equals null, there will be sent a default error message)
     *
     * @param action         The {@link MessageAction Message Action}, which should be used
     * @param delayInSeconds The delay for the executing command in seconds
     * @param delayMessage   The error message, which should appear, if the member has not waited for the delay yet
     * @return The specified {@link MessageAction Message Actions}
     */
    @NotNull
    public MessageAction sendTimeoutedMessage(@NotNull MessageAction action, long delayInSeconds, @Nullable MessageAction delayMessage) {
        if (delayInSeconds == 0) {
            logger.error("The Time, which you are specifying, equals 0, so it makes no sense that you chose a Timeouted Message.", new IllegalArgumentException());
        }

        if (delayInSeconds < 0) {
            logger.error("The Time, which you are specifying can not be under 0.", new IllegalArgumentException());
        }

        try {
            long id = member.getIdLong();
            long time;
            if (DataImpl.getMap().containsKey(id)) {
                time = DataImpl.getMap().get(id);

                if ((System.currentTimeMillis() - time) >= Utility.calculateDelay(null, delayInSeconds)) {
                    DataImpl.getMap().put(id, System.currentTimeMillis());
                    return action;
                } else {
                    if (delayMessage == null) {
                        DecimalFormat df = new DecimalFormat("0.00");
                        delayMessage = channel.sendMessage(member.getEffectiveName() + ", you must wait "
                                + df.format((Utility.calculateDelay(null, delayInSeconds) - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛");
                    } else {
                        return delayMessage;
                    }
                }
            } else {
                DataImpl.getMap().put(id, System.currentTimeMillis());
                return action;
            }
        } catch (NullPointerException e) {
            logger.error("The Message Action, which you are specifying, equals null.", e);
        }

        return delayMessage;
    }

    /**
     * This works like a normal Message sending, but with more given options and a delay between using this.
     * <br>
     * You must specify a delay to time out a command. (the long delayInSeconds <b>must not equal to 0</b>. If this
     * is true a {@link IllegalArgumentException IllegalArgumentException} will be thrown).
     * (The same is applicable for numbers under 0)
     * <br>
     * You also can specify a delay message, which will be sent if you are under a delay. (if delayMessage
     * equals null, there will be sent a default error message)
     * <br>
     * Another option you can use a specified {@link TimeUnit Time Unit} like {@link TimeUnit#MINUTES minutes},
     * {@link TimeUnit#HOURS hours} or even {@link TimeUnit#DAYS days} (if {@link TimeUnit Time Unit} equals null,
     * there will be used a default {@link TimeUnit Time Unit}: {@link TimeUnit#SECONDS TimeUnit.SECONDS})
     *
     * @param action         The {@link ReplyCallbackAction Reply Callback Action}, which should be used
     * @param delayInSeconds The delay for the executing command in seconds
     * @param delayMessage   The error message, which should appear, if the member has not waited for the delay yet
     * @param unit           The {@link TimeUnit TimeUnit}, which is used for specifying the type of time for the delay
     * @return The specified {@link MessageAction Message Actions}
     */
    @NotNull
    public ReplyCallbackAction replyTimeoutedMessage(@NotNull ReplyCallbackAction action, long delayInSeconds, @Nullable ReplyCallbackAction delayMessage,
                                                     @Nullable TimeUnit unit) {
        if (delayInSeconds == 0) {
            logger.error("The Time, which you are specifying, equals 0, so it makes no sense that you chose a Timeouted Message.", new IllegalArgumentException());
        }

        if (delayInSeconds < 0) {
            logger.error("The Time, which you are specifying can not be under 0.", new IllegalArgumentException());
        }

        try {
            long id = member.getIdLong();
            long time;
            if (DataImpl.getMap().containsKey(id)) {
                time = DataImpl.getMap().get(id);

                if ((System.currentTimeMillis() - time) >= Utility.calculateDelay(unit, delayInSeconds)) {
                    DataImpl.getMap().put(id, System.currentTimeMillis());
                    return action;
                } else {
                    if (delayMessage == null) {
                        DecimalFormat df = new DecimalFormat("0.00");
                        channel.sendMessage(member.getEffectiveName() + ", you must wait "
                                + df.format((Utility.calculateDelay(unit, delayInSeconds) - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛").queue();
                    } else {
                        return delayMessage;
                    }
                }
            } else {
                DataImpl.getMap().put(id, System.currentTimeMillis());
                return action;
            }
        } catch (NullPointerException e) {
            logger.error("The Reply Callback Action, which you are specifying, equals null.", e);
        }

        return delayMessage;
    }

    /**
     * This works like a normal Message sending, but with more given options and a delay between using this.
     * <br>
     * You must specify a delay to time out a command. (the long delayInSeconds <b>must not equal to 0</b>. If this
     * is true a {@link IllegalArgumentException IllegalArgumentException} will be thrown).
     * (The same is applicable for numbers under 0)
     * <br>
     * You also can specify a delay message, which will be sent if you are under a delay. (if delayMessage
     * equals null, there will be sent a default error message)
     *
     * @param action         The {@link ReplyCallbackAction Reply Callback Action}, which should be used
     * @param delayInSeconds The delay for the executing command in seconds
     * @param delayMessage   The error message, which should appear, if the member has not waited for the delay yet
     * @return The specified {@link MessageAction Message Actions}
     */
    @NotNull
    public ReplyCallbackAction replyTimeoutedMessage(@NotNull ReplyCallbackAction action, long delayInSeconds, @Nullable ReplyCallbackAction delayMessage) {
        if (delayInSeconds == 0) {
            logger.error("The Time, which you are specifying, equals 0, so it makes no sense that you chose a Timeouted Message.", new IllegalArgumentException());
        }

        if (delayInSeconds < 0) {
            logger.error("The Time, which you are specifying can not be under 0.", new IllegalArgumentException());
        }

        try {
            long id = member.getIdLong();
            long time;
            if (DataImpl.getMap().containsKey(id)) {
                time = DataImpl.getMap().get(id);

                if ((System.currentTimeMillis() - time) >= Utility.calculateDelay(null, delayInSeconds)) {
                    DataImpl.getMap().put(id, System.currentTimeMillis());
                    return action;
                } else {
                    if (delayMessage == null) {
                        DecimalFormat df = new DecimalFormat("0.00");
                        channel.sendMessage(member.getEffectiveName() + ", you must wait "
                                + df.format((Utility.calculateDelay(null, delayInSeconds) - (System.currentTimeMillis() - time)) / 1000.d) + " seconds ⌛").queue();
                    } else {
                        return delayMessage;
                    }
                }
            } else {
                DataImpl.getMap().put(id, System.currentTimeMillis());
                return action;
            }
        } catch (NullPointerException e) {
            logger.error("The Reply Callback Action, which you are specifying, equals null.", e);
        }

        return delayMessage;
    }
}