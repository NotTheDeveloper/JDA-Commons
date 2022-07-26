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

import com.google.errorprone.annotations.CheckReturnValue;
import dev.blocky.library.jda.Utility;
import dev.blocky.library.jda.enums.SafetyClear;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.MessageAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Represents a Discord voice {@link net.dv8tion.jda.api.entities.GuildChannel guild channel}.
 * <br>Adds additional information specific to voice channels in Discord.
 *
 * @author BlockyDotJar
 * @version v1.0.1
 * @since v1.1.5
 */
public class GuildVoiceChannel extends Utility
{
    private static final Logger logger = JDALogger.getLog(GuildVoiceChannel.class);
    private final VoiceChannel channel;
    private Member member;

    /**
     * Constructs a <b>new</b> {@link GuildVoiceChannel guild voice channel}.
     * <br>This is a private constructor, because it should not be accessed for other classes.
     *
     * @param channel The {@link VoiceChannel voice channel}, which should be used to get {@link GuildVoiceChannel guild voice channel}
     * @param member  The {@link Member member}, which should be used to get {@link GuildVoiceChannel guild voice channel}
     */
    private GuildVoiceChannel(@NotNull VoiceChannel channel, @Nullable Member member)
    {
        this.channel = channel;
        this.member = member;

        if (!channel.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MESSAGES) && !member.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MEMBERS))
        {
            logger.warn("Both the GUILD_MESSAGES and the GUILD_MEMBERS intents are not enabled, which means, that some stuff could not work.");
        }

        if (!channel.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MESSAGES))
        {
            logger.warn("The GUILD_MESSAGES intent is not enabled, which means, that some stuff could not work.");
        }

        if (!member.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MEMBERS))
        {
            logger.warn("The GUILD_MEMBERS intent is not enabled, which means, that some stuff could not work.");
        }
    }

    /**
     * Constructs a <b>new</b> {@link GuildVoiceChannel guild voice channel}.
     * <br>This is a private constructor, because it should not be accessed for other classes.
     *
     * @param channel The {@link VoiceChannel voice channel}, which should be used to get {@link GuildVoiceChannel guild voice channel}
     */
    private GuildVoiceChannel(@NotNull VoiceChannel channel)
    {
        this.channel = channel;

        if (!channel.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MESSAGES))
        {
            logger.warn("The GUILD_MESSAGES intent is not enabled, which means, that some stuff could not work.");
        }
    }

    /**
     * Constructs a <b>new</b> {@link GuildVoiceChannel guild voice channel} instance.
     * <br>If you don't initialize a {@link net.dv8tion.jda.api.entities.VoiceChannel voice channel} or a {@link net.dv8tion.jda.api.entities.Member member},
     * the {@link GuildVoiceChannel guild voice channel} always will be <b>null</b>.
     *
     * @param channel The {@link net.dv8tion.jda.api.entities.VoiceChannel voice channel}, which
     *                should be initialized
     * @param member  The {@link net.dv8tion.jda.api.entities.Member member}, which
     *                should be initialized
     * @return A <b>new</b> {@link GuildVoiceChannel guild voice channel} instance
     */
    @NotNull
    public static GuildVoiceChannel set(@NotNull VoiceChannel channel, @Nullable Member member)
    {
        return new GuildVoiceChannel(channel, member);
    }

    /**
     * Constructs a <b>new</b> {@link GuildVoiceChannel guild voice channel} instance.
     * <br>If you don't initialize a {@link net.dv8tion.jda.api.entities.VoiceChannel voice channel},
     * the {@link GuildVoiceChannel guild voice channel} always will be <b>null</b>.
     *
     * @param channel The {@link net.dv8tion.jda.api.entities.VoiceChannel voice channel}, which
     *                should be initialized
     * @return A <b>new</b> {@link GuildVoiceChannel guild voice channel} instance
     */
    @NotNull
    public static GuildVoiceChannel set(@NotNull VoiceChannel channel)
    {
        return new GuildVoiceChannel(channel);
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
     * The {@link VoiceChannel voice channel} for this {@link Message message}.
     *
     * @return The {@link VoiceChannel voice channel}
     */
    @NotNull
    public VoiceChannel getChannel()
    {
        return channel;
    }

    /**
     * Convenience method to delete messages in the most efficient way available.
     * <br>No checks will be done to prevent failures, use {@link java.util.concurrent.CompletionStage#exceptionally(Function)
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
     * Convenience method to delete a complete {@link VoiceChannel voice channel} in the most efficient way available.
     * <br>No checks will be done to prevent failures, use {@link java.util.concurrent.CompletionStage#exceptionally(Function)
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
     * Convenience method to delete a complete {@link VoiceChannel voice channel} in the most efficient way available.
     * <br>No checks will be done to prevent failures, use {@link java.util.concurrent.CompletionStage#exceptionally(Function)
     * CompletionStage#exceptionally(Function)} to handle failures.
     *
     * @return A list of futures representing all deletion task
     */
    @Nullable
    public List<CompletableFuture<Void>> purgeChannel()
    {
        return purgeChannel(null);
    }

    /**
     * Checks if the content, you specified, is written in this channel.
     *
     * @param content     The message content, which should be checked
     * @param checkAmount The amount of messages, which should be checked
     * @return
     * <b>true</b> If the content, you specified, is written in this channel
     * <br><b>false</b> If the content, you specified, is not written in this channel
     */
    public boolean containsMessage(@NotNull CharSequence content, int checkAmount)
    {
        if (!channel.getJDA().getGatewayIntents().contains(GatewayIntent.MESSAGE_CONTENT))
        {
            logger.warn("The MESSAGE_CONTENT intent is not enabled, which means, that some stuff could not work.");
        }

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
     * Gets all the messages from the member, which was specified with the {@link #set(VoiceChannel, Member)} method,
     * in this channel. (max. 1000 messages per channel)
     *
     * @return The written messages of the specified member in this channel
     */
    @Nullable
    public CompletableFuture<List<Message>> getMessagesByMember()
    {
        return getMessagesByMember(member);
    }

    /**
     * Gets all the messages from a specific member in this channel. (max. 1000 messages per channel)
     *
     * @param member The member, from which the messages should be retrieved
     *
     * @return The written messages of the specified member in this channel
     */
    @Nullable
    public CompletableFuture<List<Message>> getMessagesByMember(@Nullable Member member)
    {
        return getMessagesByUser(member.getUser());
    }

    /**
     * Gets all the messages from a specific user in this channel. (max. 1000 messages per channel)
     *
     * @param user The user, from which the messages should be retrieved
     *
     * @return The written messages of the specified user in this channel
     */
    @Nullable
    public CompletableFuture<List<Message>> getMessagesByUser(@Nullable User user)
    {
        if (member == null)
        {
            throw new IllegalStateException("You must specify a member, which should be used for this command.");
        }

        if (user == null)
        {
            user = this.member.getUser();
            logger.info("'member' equals null, defaulting to member, specified by 'set(PrivateChannel, Member)'");
        }

        final User finalUser = user;
        return channel.getIterableHistory()
                .takeAsync(1000)
                .thenApply(list ->
                        list.stream()
                                .filter(m -> m.getAuthor().equals(finalUser))
                                .collect(Collectors.toList())
                );
    }

    /**
     * This works like a normal message sending, but with more given options and a delay between using this.
     * <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
     * If this is <b>true</b> a {@link IllegalArgumentException illegal argument exception} will be thrown. The same is applicable for numbers under 0)
     * <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
     * equals <b>null</b>, there will be sent a default error message)
     * <br>Another option you can use a specified {@link TimeUnit time} like {@link TimeUnit#MINUTES minutes},
     * {@link TimeUnit#HOURS hours} or even {@link TimeUnit#DAYS days}.
     * <br>(if {@link TimeUnit the time unit} equals <b>null</b>, there will be used a default {@link TimeUnit time unit}:
     * {@link TimeUnit#SECONDS TimeUnit#SECONDS})
     *
     * @param message         The {@link MessageAction message action}, which should be used
     * @param delayInSeconds The delay for the executing command in seconds
     * @param delayMessage   The error message, which should appear, if the member has not waited for the delay yet
     * @param unit           The {@link TimeUnit time unit}, which is used for specifying the type of time for the delay
     * @return The specified {@link MessageAction message action}
     */
    @NotNull
    @CheckReturnValue
    public MessageAction sendTimeoutedMessage(@NotNull MessageAction message, long delayInSeconds, @Nullable MessageAction delayMessage,
                                              @Nullable TimeUnit unit)
    {
        if (member == null)
        {
            throw new IllegalStateException("You must specify a member, which should be used for this command.");
        }

        try
        {
            long id = member.getIdLong();
            long time;
            if (getHashMap().containsKey(id))
            {
                time = getHashMap().get(id);

                if ((System.currentTimeMillis() - time) >= calculateDelay(unit, delayInSeconds))
                {
                    getHashMap().put(id, System.currentTimeMillis());
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
                getHashMap().put(id, System.currentTimeMillis());
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
     * <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
     * If this is <b>true</b> a {@link IllegalArgumentException illegal argument exception} will be thrown. The same is applicable for numbers under 0)
     * <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
     * equals <b>null</b>, there will be sent a default error message)
     *
     * @param message         The {@link MessageAction message action}, which should be used
     * @param delayInSeconds The delay for the executing command in seconds
     * @param delayMessage   The error message, which should appear, if the member has not waited for the delay yet
     * @return The specified {@link MessageAction message action}
     */
    @NotNull
    @CheckReturnValue
    public MessageAction sendTimeoutedMessage(@NotNull MessageAction message, long delayInSeconds, @Nullable MessageAction delayMessage)
    {
        return sendTimeoutedMessage(message, delayInSeconds, delayMessage, null);
    }

    /**
     * This works like a normal (message component) message sending, but with more given options and a delay between using this. <br>
     * <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
     * If this is <b>true</b> a {@link IllegalArgumentException illegal argument exception} will be thrown. The same is applicable for numbers under 0)
     * <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
     * equals <b>null</b>, there will be sent a default error message)
     * <br>Another option you can use a specified {@link TimeUnit time} like {@link TimeUnit#MINUTES minutes},
     * {@link TimeUnit#HOURS hours} or even {@link TimeUnit#DAYS days}.
     * <br>(if {@link TimeUnit the time unit} equals <b>null</b>, there will be used a default {@link TimeUnit time unit}:
     * {@link TimeUnit#SECONDS TimeUnit#SECONDS})
     *
     * @param message        The {@link ReplyCallbackAction reply callback action}, which should be used
     * @param delayInSeconds The delay for the executing command in seconds
     * @param delayMessage   The error message, which should appear, if the member has not waited for the delay yet
     * @param unit           The {@link TimeUnit time unit}, which is used for specifying the type of time for the delay
     * @return The specified {@link MessageAction message action}
     */
    @NotNull
    @CheckReturnValue
    public ReplyCallbackAction replyTimeoutedMessage(@NotNull ReplyCallbackAction message, long delayInSeconds, @Nullable ReplyCallbackAction delayMessage,
                                                     @Nullable TimeUnit unit)
    {
        if (member == null)
        {
            throw new IllegalStateException("You must specify a member, which should be used for this command.");
        }

        try
        {
            long id = member.getIdLong();
            long time;
            if (getHashMap().containsKey(id))
            {
                time = getHashMap().get(id);

                if ((System.currentTimeMillis() - time) >= calculateDelay(unit, delayInSeconds))
                {
                    getHashMap().put(id, System.currentTimeMillis());
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
                getHashMap().put(id, System.currentTimeMillis());
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
     * This works like a normal (message component) message sending, but with more given options and a delay between using this.
     * <br>You must specify a delay to time out a command. (the long <b>delayInSeconds must not equal to 0</b>.
     * If this is <b>true</b> a {@link IllegalArgumentException illegal argument exception} will be thrown. The same is applicable for numbers under 0)
     * <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
     * equals <b>null</b>, there will be sent a default error message)
     *
     * @param message         The {@link ReplyCallbackAction reply callback action}, which should be used
     * @param delayInSeconds The delay for the executing command in seconds
     * @param delayMessage   The error message, which should appear, if the member has not waited for the delay yet
     * @return The specified {@link MessageAction message action}
     */
    @NotNull
    @CheckReturnValue
    public ReplyCallbackAction replyTimeoutedMessage(@NotNull ReplyCallbackAction message, long delayInSeconds, @Nullable ReplyCallbackAction delayMessage)
    {
        return replyTimeoutedMessage(message, delayInSeconds, delayMessage, null);
    }

    @Override
    public boolean equals(@Nullable Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        GuildVoiceChannel that = (GuildVoiceChannel) o;

        return channel.equals(that.channel) && Objects.equals(member, that.member);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(channel, member);
    }

    @NotNull
    @Override
    public String toString()
    {
        return "GuildVoiceChannel{" +
                "channel=" + channel +
                ", member=" + member +
                '}';
    }
}