/**
 * Copyright 2022 Dominic R. (aka. BlockyDotJar)
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
import dev.blocky.library.jda.enums.ClearSafety;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import net.dv8tion.jda.internal.utils.Checks;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Represents a Discord voice {@link GuildChannel}.
 * <br>Adds additional information specific to {@link VoiceChannel VoiceChannels} in Discord.
 *
 * @param channel The {@link VoiceChannel}, which should be initialized.
 * @param user The {@link User}, which should be initialized.
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.1.5
 */
public record GuildVoiceChannel(@NotNull VoiceChannel channel, @Nullable User user) implements ChannelUtils
{
    private static final Logger logger = JDALogger.getLog(GuildVoiceChannel.class);

    /**
     * Convenience method to delete messages in the most efficient way available.
     * <br>No checks will be done to prevent failures, use {@link CompletionStage#exceptionally(Function)} to handle failures.
     *
     * @param amount The amount of messages to delete.
     * @param safeties The {@link ClearSafety} options, which helps for specifying different message types, which will not be deleted.
     *
     * @return A {@link List} of futures representing all deletion task.
     */
    @NotNull
    public List<CompletableFuture<Void>> purgeMessages(int amount, @NotNull ClearSafety... safeties)
    {
        return channel.purgeMessages(ChannelUtils.checkClearSafety(channel, amount, safeties));
    }

    /**
     * Convenience method to delete a complete {@link VoiceChannel} in the most efficient way available.
     * <br>No checks will be done to prevent failures, use {@link CompletionStage#exceptionally(Function)} to handle failures.
     *
     * @param safeties The {@link ClearSafety} options, which helps for specifying different message types, which will not be deleted.
     *
     * @return A {@link List} of futures representing all deletion task.
     */
    @NotNull
    public List<CompletableFuture<Void>> purgeChannel(@NotNull ClearSafety... safeties)
    {
        return channel.purgeMessages(ChannelUtils.checkChannelClearSafety(channel, safeties));
    }

    /**
     * Convenience method to delete a complete {@link VoiceChannel} in the most efficient way available.
     * <br>No checks will be done to prevent failures, use {@link CompletionStage#exceptionally(Function)} to handle failures.
     *
     * @return A {@link List} of futures representing all deletion task.
     */
    @NotNull
    public List<CompletableFuture<Void>> purgeChannel()
    {
        return purgeChannel(ClearSafety.NONE);
    }

    /**
     * Checks if the content, you specified, is written in this channel.
     *
     * @param content The message content, which should be checked.
     * @param checkAmount The amount of messages, which should be checked.
     *
     * @return <b>true</b> If the content, you specified, is written in this channel.
     *         <br><b>false</b> If the content, you specified, is not written in this channel.
     */
    public boolean containsMessage(@NotNull CharSequence content, int checkAmount)
    {
        Checks.check(checkAmount > 0, "checkAmount may not be negative");

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
     * Gets all the messages from the {@link User} in this channel. (max. 1000 messages per channel)
     *
     * @return The written messages of the specified {@link User} in this channel
     */
    @Nullable
    public CompletableFuture<List<Message>> getMessagesByUser()
    {
        if (user == null)
        {
            throw new IllegalStateException("You must specify a user, which should be used for this command.");
        }

        return getMessagesByUser(user);
    }

    /**
     * Gets all the messages from a specific {@link User} in this channel. (max. 1000 messages per channel)
     *
     * @param user The {@link User}, from which the messages should be retrieved
     *
     * @return The written messages of the specified {@link User} in this channel
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
     * <br>You must specify a delay to time out a command. (the {@code delayInSeconds} parameter <b>must not equal to 0</b>)
     * <br>If this is {@code true} a {@link IllegalArgumentException} will be thrown. The same is applicable for numbers under 0.
     * <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
     * equals <b>null</b>, there will be sent a default error message)
     * <br>Another option is that you can use a specific {@link TimeUnit} like {@link TimeUnit#MINUTES},
     * {@link TimeUnit#HOURS} or {@link TimeUnit#DAYS}.
     * <br>(if the {@code unit} parameter equals <b>null</b>, {@link TimeUnit#SECONDS SECONDS} will be used)
     *
     * @param message The {@link MessageCreateAction}, which should be used.
     * @param delayInSeconds The delay for the executing command in seconds.
     * @param delayMessage The error message, which should appear, if the member has not waited for the delay yet.
     * @param unit The {@link TimeUnit}, which is used for specifying the type of time for the delay.
     *
     * @return The specified {@link MessageCreateAction}.
     */
    @NotNull
    @CheckReturnValue
    public MessageCreateAction sendTimeoutedMessage(@NotNull MessageCreateAction message, long delayInSeconds, @Nullable MessageCreateAction delayMessage,
                                                    @Nullable TimeUnit unit)
    {
        if (user == null)
        {
            throw new IllegalStateException("You must specify a user, which should be used for this command.");
        }

        long id = user.getIdLong();

        if (!ChannelUtils.getHashMap().containsKey(id))
        {
            ChannelUtils.getHashMap().put(id, System.currentTimeMillis());
            return message;
        }

        long time = ChannelUtils.getHashMap().get(id);

        if ((System.currentTimeMillis() - time) >= ChannelUtils.calculateDelay(unit, delayInSeconds))
        {
            ChannelUtils.getHashMap().put(id, System.currentTimeMillis());
            return message;
        }

        if (delayMessage != null)
        {
            return delayMessage;
        }

        DecimalFormat df = new DecimalFormat("0.00");

        MessageCreateBuilder builder = new MessageCreateBuilder()
                .setContent(user.getName() + ", you must wait " +
                        df.format((ChannelUtils.calculateDelay(unit, delayInSeconds) - (System.currentTimeMillis() - time)) / 1000.d) +
                        " " + (unit == null ? "seconds" : unit.toString().toLowerCase()) + " ⌛");

        try (MessageCreateData createData = builder.build())
        {
            delayMessage = channel.sendMessage(createData);
        }
        return delayMessage;
    }

    /**
     * This works like a normal message sending, but with more given options and a delay between using this.
     * <br>You must specify a delay to time out a command. (the {@code delayInSeconds} parameter <b>must not equal to 0</b>)
     * <br>If this is {@code true} a {@link IllegalArgumentException} will be thrown. The same is applicable for numbers under 0.
     * <br>You also can specify a delay message, which will be sent if you are under a delay. (if the delay message
     * equals <b>null</b>, there will be sent a default error message)
     *
     * @param message The {@link MessageCreateAction}, which should be used.
     * @param delayInSeconds The delay for the executing command in seconds.
     * @param delayMessage The error message, which should appear, if the member has not waited for the delay yet.
     *
     * @return The specified {@link MessageCreateAction}.
     */
    @NotNull
    @CheckReturnValue
    public MessageCreateAction sendTimeoutedMessage(@NotNull MessageCreateAction message, long delayInSeconds, @Nullable MessageCreateAction delayMessage)
    {
        return sendTimeoutedMessage(message, delayInSeconds, delayMessage, null);
    }

    /**
     * This works like a normal (interaction) message sending, but with more given options and a delay between using this.
     * <br>You must specify a delay to time out a command. (the {@code delayInSeconds} parameter <b>must not equal to 0</b>)
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
    public ReplyCallbackAction replyTimeoutedMessage(@NotNull ReplyCallbackAction message, long delayInSeconds, @NotNull ReplyCallbackAction delayMessage,
                                                     @Nullable TimeUnit unit)
    {
        if (user == null)
        {
            throw new IllegalStateException("You must specify a member, which should be used for this command.");
        }

        long id = user.getIdLong();

        if (!ChannelUtils.getHashMap().containsKey(id))
        {
            ChannelUtils.getHashMap().put(id, System.currentTimeMillis());
            return message;
        }

        long time = ChannelUtils.getHashMap().get(id);

        if ((System.currentTimeMillis() - time) >= ChannelUtils.calculateDelay(unit, delayInSeconds))
        {
            ChannelUtils.getHashMap().put(id, System.currentTimeMillis());
            return message;
        }
        return delayMessage;
    }

    /**
     * This works like a normal (interaction) message sending, but with more given options and a delay between using this.
     * <br>You must specify a delay to time out a command. (the {@code delayInSeconds} parameter <b>must not equal to 0</b>)
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
    public ReplyCallbackAction replyTimeoutedMessage(@NotNull ReplyCallbackAction message, long delayInSeconds, @NotNull ReplyCallbackAction delayMessage)
    {
        return replyTimeoutedMessage(message, delayInSeconds, delayMessage, null);
    }
}
