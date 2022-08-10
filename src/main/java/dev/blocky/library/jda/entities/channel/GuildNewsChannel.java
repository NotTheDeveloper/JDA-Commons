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
package dev.blocky.library.jda.entities.channel;

import com.google.errorprone.annotations.CheckReturnValue;
import dev.blocky.library.jda.Utility;
import dev.blocky.library.jda.enums.SafetyClear;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.requests.ErrorResponse;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.RestAction;
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
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Represents {@link StandardGuildMessageChannel} that are {@link NewsChannel}.
 * <br>The Discord client may refer to these as announcement channels.
 * <br>Members can subscribe channels in their own {@link Guild} to receive {@link Message messages}
 * cross-posted from this channel. 
 * <br>This is referred to as following this channel.
 * <br>{@link Message Messages} sent in this channel can be cross-posted, at which point they will be sent
 * (via {@link Webhook webhook}) to all subscribed channels.
 *
 * @author BlockyDotJar
 * @version v1.1.4
 * @since v1.1.1
 */
public class GuildNewsChannel extends Utility
{
    private static final Logger logger = JDALogger.getLog(GuildNewsChannel.class);
    private final NewsChannel channel;
    private Member member;

    private GuildNewsChannel(@NotNull NewsChannel channel, @Nullable Member member)
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

    private GuildNewsChannel(@NotNull NewsChannel channel)
    {
        this.channel = channel;

        if (!channel.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MESSAGES))
        {
                logger.warn("The GUILD_MESSAGES intent is not enabled, which means, that some stuff could not work.");
        }
    }

    /**
     * Constructs a <b>new</b> {@link GuildNewsChannel} instance.
     * <br>If you don't initialize a {@link NewsChannel} or a {@link Member},
     * the {@link GuildNewsChannel} always will be <b>null</b>.
     *
     * @param channel The {@link NewsChannel}, which should be initialized.
     * @param member The {@link Member}, which should be initialized.
     *               
     * @return A <b>new</b> {@link GuildNewsChannel} instance.
     */
    @NotNull
    public static GuildNewsChannel set(@NotNull NewsChannel channel, @Nullable Member member)
    {
        return new GuildNewsChannel(channel, member);
    }

    /**
     * Constructs a <b>new</b> {@link GuildNewsChannel} instance.
     * <br>If you don't initialize a {@link NewsChannel},
     * the {@link GuildNewsChannel} always will be <b>null</b>.
     *
     * @param channel The {@link NewsChannel}, which should be initialized.
     *                
     * @return A <b>new</b> {@link GuildNewsChannel} instance.
     */
    @NotNull
    public static GuildNewsChannel set(@NotNull NewsChannel channel)
    {
        return new GuildNewsChannel(channel);
    }

    /**
     * The author of the {@link Message} received as {@link Member} object.
     *
     * @return The author of the {@link Message} as null-able {@link Member} object.
     */
    @Nullable
    public Member getMember()
    {
        return member;
    }

    /**
     * The {@link NewsChannel} for this {@link Message}.
     *
     * @return The {@link NewsChannel}.
     */
    @NotNull
    public NewsChannel getChannel()
    {
        return channel;
    }

    /**
     * Convenience method to delete messages in the most efficient way available.
     * <br>No checks will be done to prevent failures, use {@link CompletionStage#exceptionally(Function)} to handle failures.
     *
     * @param amount The amount of messages to delete.
     * @param clear The {@link SafetyClear} option, which helps for specifying different message types, which will not be deleted.
     *              
     * @return A {@link List} of futures representing all deletion task.
     */
    @Nullable
    public List<CompletableFuture<Void>> purgeMessages(int amount, @Nullable SafetyClear clear)
    {
        return channel.purgeMessages(checkClearSafety(clear, channel, amount));
    }

    /**
     * Convenience method to delete a complete {@link NewsChannel} in the most efficient way available.
     * <br>No checks will be done to prevent failures, use {@link CompletionStage#exceptionally(Function)} to handle failures.
     *
     * @param clear The {@link SafetyClear} option, which helps for specifying different message types, which will not be deleted.
     *              
     * @return A {@link List} of futures representing all deletion task.
     */
    @Nullable
    public List<CompletableFuture<Void>> purgeChannel(@Nullable SafetyClear clear)
    {
        return channel.purgeMessages(checkChannelClearSafety(clear, channel));
    }

    /**
     * Convenience method to delete a complete {@link NewsChannel} in the most efficient way available.
     * <br>No checks will be done to prevent failures, use {@link CompletionStage#exceptionally(Function)} to handle failures.
     *
     * @return A {@link List} of futures representing all deletion task.
     */
    @Nullable
    public List<CompletableFuture<Void>> purgeChannel()
    {
        return purgeChannel(null);
    }

    /**
     * Checks if the content, you specified, is written in this channel.
     *
     * @param content The message content, which should be checked.
     * @param checkAmount The amount of messages, which should be checked.
     *                    
     * @return <b>true</b> - If the content, you specified, is written in this channel.
     *         <br><b>false</b> - If the content, you specified, is not written in this channel.
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
     * Gets all the messages from the {@link User}, which was specified with the {@link #set(NewsChannel, Member)} method,
     * in this channel. (max. 1000 messages per channel)
     *
     * @return The written messages of the specified {@link User} in this channel.
     */
    @Nullable
    public CompletableFuture<List<Message>> getMessagesByUser()
    {
        if (member == null)
        {
            throw new IllegalStateException("You must specify a member, which should be used for this command.");
        }

        return getMessagesByUser(member.getUser());
    }

    /**
     * Gets all the messages from a specific {@link User} in this channel. (max. 1000 messages per channel)
     *
     * @param user The {@link User}, from which the messages should be retrieved.
     *
     * @return The written messages of the specified {@link User} in this channel.
     */
    @Nullable
    public CompletableFuture<List<Message>> getMessagesByUser(@NotNull User user)
    {
        return channel.getIterableHistory()
                .takeAsync(1000)
                .thenApply(list ->
                        list.stream()
                                .filter(m -> m.getAuthor().equals(user))
                                .collect(Collectors.toList())
                );
    }

    /**
     * This works like a normal message sending, but with more given options and a delay between using this.
     * <br>You must specify a delay to time out a command. (the {@code delayInSeconds} parameter <b>must not equal to 0</b>.
     * <br>If this is {@code true} a {@link IllegalArgumentException} will be thrown. The same is applicable for numbers under 0.
     * <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
     * equals <b>null</b>, there will be sent a default error message)
     * <br>Another option is that you can use a specific {@link TimeUnit} like {@link TimeUnit#MINUTES},
     * {@link TimeUnit#HOURS} or {@link TimeUnit#DAYS}.
     * <br>(if the {@code unit} parameter equals <b>null</b>, {@link TimeUnit#SECONDS SECONDS} will be used)
     *
     * @param message The {@link MessageAction}, which should be used.
     * @param delayInSeconds The delay for the executing command in seconds.
     * @param delayMessage The error message, which should appear, if the member has not waited for the delay yet.
     * @param unit The {@link TimeUnit}, which is used for specifying the type of time for the delay.
     *             
     * @return The specified {@link MessageAction}.
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
     * <br>You must specify a delay to time out a command. (the {@code delayInSeconds} parameter <b>must not equal to 0</b>.
     * <br>If this is {@code true} a {@link IllegalArgumentException} will be thrown. The same is applicable for numbers under 0.
     * <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
     * equals <b>null</b>, there will be sent a default error message)
     *
     * @param message The {@link MessageAction}, which should be used.
     * @param delayInSeconds The delay for the executing command in seconds.
     * @param delayMessage The error message, which should appear, if the member has not waited for the delay yet.
     *
     * @return The specified {@link MessageAction}.
     */
    @NotNull
    @CheckReturnValue
    public MessageAction sendTimeoutedMessage(@NotNull MessageAction message, long delayInSeconds, @Nullable MessageAction delayMessage)
    {
        return sendTimeoutedMessage(message, delayInSeconds, delayMessage, null);
    }

    /**
     * This works like a normal (interaction) message sending, but with more given options and a delay between using this.
     * <br>You must specify a delay to time out a command. (the {@code delayInSeconds} parameter <b>must not equal to 0</b>.
     * <br>If this is {@code true} a {@link IllegalArgumentException} will be thrown. The same is applicable for numbers under 0.
     * <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
     * equals <b>null</b>, there will be sent a default error message)
     * <br>Another option is that you can use a specific {@link TimeUnit} like {@link TimeUnit#MINUTES},
     * {@link TimeUnit#HOURS} or {@link TimeUnit#DAYS}.
     * <br>(if the {@code unit} parameter equals <b>null</b>, {@link TimeUnit#SECONDS SECONDS} will be used)
     *
     * @param message The {@link ReplyCallbackAction}, which should be used.
     * @param delayInSeconds The delay for the executing command in seconds.
     * @param delayMessage The error message, which should appear, if the member has not waited for the delay yet.
     * @param unit The {@link TimeUnit}, which is used for specifying the type of time for the delay.
     *
     * @return The specified {@link ReplyCallbackAction}.
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
     * This works like a normal (interaction) message sending, but with more given options and a delay between using this.
     * <br>You must specify a delay to time out a command. (the {@code delayInSeconds} parameter <b>must not equal to 0</b>.
     * <br>If this is {@code true} a {@link IllegalArgumentException} will be thrown. The same is applicable for numbers under 0.
     * <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
     * equals <b>null</b>, there will be sent a default error message)
     *
     * @param message The {@link ReplyCallbackAction}, which should be used.
     * @param delayInSeconds The delay for the executing command in seconds.
     * @param delayMessage The error message, which should appear, if the member has not waited for the delay yet.
     *
     * @return The specified {@link ReplyCallbackAction}.
     */
    @NotNull
    @CheckReturnValue
    public ReplyCallbackAction replyTimeoutedMessage(@NotNull ReplyCallbackAction message, long delayInSeconds, @Nullable ReplyCallbackAction delayMessage)
    {
        return replyTimeoutedMessage(message, delayInSeconds, delayMessage, null);
    }

    /**
     * Attempts to cross post the provided message automatically.
     *
     * The following {@link ErrorResponse ErrorResponses} are possible:
     * <ul>
     * <li>
     * {@link ErrorResponse#ALREADY_CROSSPOSTED} - The target message has already been cross-posted.
     * </li>
     *
     * <li>
     * {@link ErrorResponse#MISSING_ACCESS} - The request was attempted after
     * the account lost access to the {@link Guild} typically due to being kicked
     * or removed, or after {@link Permission#VIEW_CHANNEL}
     * was revoked in the {@link MessageChannel}.
     * </li>
     *
     * <li>
     * {@link ErrorResponse#MISSING_PERMISSIONS} - The request was attempted
     * after the account lost {@link Permission#MESSAGE_MANAGE} in the
     * {@link MessageChannel}.
     * </li>
     *
     * <li>
     * {@link ErrorResponse#UNKNOWN_MESSAGE} - The provided messageId is unknown
     * in this {@link MessageChannel}, either due to the id being invalid, or
     * the message it referred to has already been deleted.
     * </li>
     *
     * <li>
     * {@link ErrorResponse#UNKNOWN_CHANNEL} - The request was attempted after
     * the channel was deleted. </li>
     * </ul>
     *
     * @return {@link RestAction} - Type: {@link Message}
     */
    @NotNull
    @CheckReturnValue
    public RestAction<Message> autoPublish()
    {
        return channel.crosspostMessageById(channel.getLatestMessageId());
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

        GuildNewsChannel that = (GuildNewsChannel) o;

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
        return "GuildNewsChannel{" +
                "channel=" + channel +
                ", member=" + member +
                '}';
    }
}