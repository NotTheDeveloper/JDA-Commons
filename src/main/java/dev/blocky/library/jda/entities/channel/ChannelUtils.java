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
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.internal.utils.Checks;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This is an interface, which has many utility methods for every channel class in it.
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0
 */
public sealed interface ChannelUtils permits DirectMessageChannel, GuildMessageChannel,
        GuildNewsChannel, GuildTextChannel, GuildThreadChannel, GuildVoiceChannel
{
    /**
     * The {@link Logger} to log different information.
     */
    Logger logger = JDALogger.getLog(ChannelUtils.class);

    /**
     * The {@link HashMap} to add {@link User} information to.
     */
    HashMap<Long, Long> map = new HashMap<>();

    /**
     * Checks, which {@link ClearSafety} enum is given. (if the {@code clear} parameter equals <b>null</b>, the {@link ClearSafety}
     * enum will be set to {@link ClearSafety#NONE NONE})
     *
     * @param safeties The {@link ClearSafety} options, which helps for specifying different message types, which will not be deleted.
     * @param channel The {@link MessageChannel}, which should be initialized.
     * @param amount The amount of messages to delete.
     *
     * @return A {@link List} of messages representing the precursor of all deletion tasks.
     */
    @NotNull
    @CheckReturnValue
    static List<Message> checkClearSafety(@NotNull MessageChannel channel, int amount, @NotNull ClearSafety... safeties)
    {
        Checks.check(amount > 0, "amount may not be negative");

        final List<Message> messages = new ArrayList<>();

        Arrays.stream(safeties).forEach((clear) ->
                {
                    int i = amount + 1;

                    for (Message message : channel.getIterableHistory().cache(false))
                    {
                        switch (clear)
                        {
                        case NONE -> messages.add(message);
                        case ALL ->
                        {
                            if (!message.isEdited() && !message.isPinned() && !message.isWebhookMessage() &&
                                    !message.isEphemeral() && !message.isTTS() && !message.isSuppressedEmbeds())
                            {
                                messages.add(message);
                            }
                        }
                        case EDITED_MESSAGES ->
                        {
                            if (!message.isEdited())
                            {
                                messages.add(message);
                            }
                        }
                        case PINNED_MESSAGES ->
                        {
                            if (!message.isPinned())
                            {
                                messages.add(message);
                            }
                        }
                        case WEBHOOK_MESSAGES ->
                        {
                            if (!message.isWebhookMessage())
                            {
                                messages.add(message);
                            }
                        }
                        case EPHEMERAL_MESSAGES ->
                        {
                            if (message.isEphemeral())
                            {
                                messages.add(message);
                            }
                        }
                        case TTS_MESSAGES ->
                        {
                            if (message.isTTS())
                            {
                                messages.add(message);
                            }
                        }
                        case SUPPRESSED_EMBEDS ->
                        {
                            if (message.isSuppressedEmbeds())
                            {
                                messages.add(message);
                            }
                        }
                        default -> {  }
                        }

                        if (--i <= 0)
                        {
                            break;
                        }
                    }
                }
        );
        return messages;
    }

    /**
     * Checks, which {@link ClearSafety} enum is given. (if the {@code clear} parameter equals <b>null</b>, the {@link ClearSafety}
     * enum will be set to {@link ClearSafety#NONE NONE})
     *
     * @param safeties The {@link ClearSafety} options, which helps for specifying different message types, which will not be deleted.
     * @param channel The {@link MessageChannel}, which should be initialized.
     *
     * @return A {@link List} of messages representing the precursor of all deletion tasks.
     */
    @NotNull
    @CheckReturnValue
    static List<Message> checkChannelClearSafety(@NotNull MessageChannel channel, @NotNull ClearSafety... safeties)
    {
        final List<Message> messages = new ArrayList<>();

        Arrays.stream(safeties).forEach((clear) ->
                {
                    for (Message message : channel.getIterableHistory().cache(false))
                    {
                        switch (clear)
                        {
                        case NONE -> messages.add(message);
                        case ALL ->
                        {
                            if (!message.isEdited() && !message.isPinned() && !message.isWebhookMessage() &&
                                    !message.isEphemeral() && !message.isTTS() && !message.isSuppressedEmbeds())
                            {
                                messages.add(message);
                            }
                        }
                        case EDITED_MESSAGES ->
                        {
                            if (!message.isEdited())
                            {
                                messages.add(message);
                            }
                        }
                        case PINNED_MESSAGES ->
                        {
                            if (!message.isPinned())
                            {
                                messages.add(message);
                            }
                        }
                        case WEBHOOK_MESSAGES ->
                        {
                            if (!message.isWebhookMessage())
                            {
                                messages.add(message);
                            }
                        }
                        case EPHEMERAL_MESSAGES ->
                        {
                            if (message.isEphemeral())
                            {
                                messages.add(message);
                            }
                        }
                        case TTS_MESSAGES ->
                        {
                            if (message.isTTS())
                            {
                                messages.add(message);
                            }
                        }
                        case SUPPRESSED_EMBEDS ->
                        {
                            if (message.isSuppressedEmbeds())
                            {
                                messages.add(message);
                            }
                        }
                        default -> {  }
                        }
                    }
                }
        );
        return messages;
    }

    /**
     * Calculates the delay, depending on which {@link TimeUnit} is specified.
     *
     * @param unit The {@link TimeUnit}, which should be used for calculating each time. (if the {@code unit} parameter
     *             equals <b>null</b>, {@link TimeUnit#SECONDS SECONDS} will be used)
     * @param delayInSeconds The delay in seconds which should be converted.
     *
     * @return The delay calculated to the specified {@link TimeUnit}.
     */
    static long calculateDelay(@Nullable TimeUnit unit, long delayInSeconds)
    {
        if (unit == null)
        {
            unit = TimeUnit.SECONDS;
            logger.info("'unit' equals null, defaulting to 'SECONDS'");
        }

        Checks.check(delayInSeconds > 0, "delayInSeconds may not be negative");

        return switch (unit)
                {
                    case NANOSECONDS -> delayInSeconds / 1000000;
                    case MICROSECONDS -> delayInSeconds / 1000;
                    case MILLISECONDS -> delayInSeconds;
                    case SECONDS -> delayInSeconds * 1000;
                    case MINUTES -> delayInSeconds * 60000;
                    case HOURS -> delayInSeconds * 3600000;
                    case DAYS -> delayInSeconds * 86400000;
                };
    }

    /**
     * The {@link ChannelUtils#map} instance from the {@link ChannelUtils} class.
     *
     * @return {@link ChannelUtils#map}.
     */
    @NotNull
    static HashMap<Long, Long> getHashMap()
    {
        return map;
    }
}
