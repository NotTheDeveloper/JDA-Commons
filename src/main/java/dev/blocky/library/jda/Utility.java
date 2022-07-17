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
package dev.blocky.library.jda;

import dev.blocky.library.jda.enums.SafetyClear;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import javax.annotation.CheckReturnValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This is a class, which has many utility methods in it.
 *
 * @author BlockyDotJar
 * @version v1.1.3
 * @since v1.0.0
 */
public class Utility
{
    private final static Logger logger = JDALogger.getLog(Utility.class);
    private static final HashMap<Long, Long> map = new HashMap<>();

    /**
     * Constructs a <b>new</b> {@link Utility utility}.
     * <br>This is a private constructor, because it should not be accessed for other classes.
     */
    protected Utility()
    {
    }

    /**
     * Checks, which {@link SafetyClear safety clear} enum is given. (if <b>clear</b> equals null, the
     * {@link SafetyClear safety clear} enum  will be set to {@link SafetyClear#NONE SafetyClear#NONE})
     *
     * @param clear   The {@link SafetyClear safety clear} option, which helps for specifying different message types, which will not be deleted
     * @param channel The {@link TextChannel text channel}, which should be initialized
     * @param amount  The amount of messages to delete
     * @return A list of messages representing the precursor of all deletion tasks
     */
    @NotNull
    @CheckReturnValue
    protected static List<Message> checkClearSafety(@Nullable SafetyClear clear, @NotNull TextChannel channel, int amount)
    {
        List<Message> messages = new ArrayList<>();

        if (clear == null)
        {
            clear = SafetyClear.NONE;
        }

        if (amount == 0)
        {
            logger.error("The amount of messages, which you are specifying, equals 0, so it makes no sense that you use this method.",
                    new IllegalArgumentException());
        }

        if (amount < 0)
        {
            logger.error("The amount of messages, which you are specifying, can not be under 0.",
                    new IllegalArgumentException());
        }


        int i = amount + 1;

        for (Message message : channel.getIterableHistory().cache(false))
        {
            switch (clear)
            {
                case NONE:
                    if (message.isFromGuild())
                    {
                        messages.add(message);
                    }
                    break;
                case ALL:
                    if (!message.isEdited() && !message.isPinned() && !message.isWebhookMessage())
                    {
                        messages.add(message);
                    }
                    break;
                case PINNED_MESSAGES:
                    if (!message.isPinned())
                    {
                        messages.add(message);
                    }
                    break;
                case WEBHOOK_MESSAGES:
                    if (!message.isWebhookMessage())
                    {
                        messages.add(message);
                    }
                    break;
                case EDITED_MESSAGES:
                    if (!message.isEdited())
                    {
                        messages.add(message);
                    }
                    break;
                default:
                    break;
            }

            if (--i <= 0)
            {
                break;
            }
        }
        return messages;
    }

    /**
     * Checks, which {@link SafetyClear safety clear} enum is given. (if <b>clear</b> equals null, the
     * {@link SafetyClear safety clear} enum  will be set to {@link SafetyClear#NONE SafetyClear#NONE})
     *
     * @param clear   The {@link SafetyClear safety clear} option, which helps for specifying different message types, which will not be deleted
     * @param channel The {@link MessageChannel message channel}, which  should be initialized
     * @param amount  The amount of messages to delete
     * @return A list of messages representing the precursor of all deletion tasks
     */
    @NotNull
    @CheckReturnValue
    protected static List<Message> checkClearSafety(@Nullable SafetyClear clear, @NotNull MessageChannel channel, int amount)
    {
        List<Message> messages = new ArrayList<>();

        if (clear == null)
        {
            clear = SafetyClear.NONE;
        }

        if (amount == 0)
        {
            logger.error("The amount of messages, which you are specifying, equals 0, so it makes no sense that you use this method.",
                    new IllegalArgumentException());
        }

        if (amount < 0)
        {
            logger.error("The amount of messages, which you are specifying, can not be under 0.",
                    new IllegalArgumentException());
        }

        int i = amount + 1;

        for (Message message : channel.getIterableHistory().cache(false))
        {
            switch (clear)
            {
                case NONE:
                    if (message.isFromGuild())
                    {
                        messages.add(message);
                    }
                    break;
                case ALL:
                    if (!message.isEdited() && !message.isPinned() && !message.isWebhookMessage())
                    {
                        messages.add(message);
                    }
                    break;
                case PINNED_MESSAGES:
                    if (!message.isPinned())
                    {
                        messages.add(message);
                    }
                    break;
                case WEBHOOK_MESSAGES:
                    if (!message.isWebhookMessage())
                    {
                        messages.add(message);
                    }
                    break;
                case EDITED_MESSAGES:
                    if (!message.isEdited())
                    {
                        messages.add(message);
                    }
                    break;
                default:
                    break;
            }

            if (--i <= 0)
            {
                break;
            }
        }
        return messages;
    }

    /**
     * Checks, which {@link SafetyClear safety clear} enum is given. (if <b>clear</b> equals null, the
     * {@link SafetyClear safety clear} enum will be set to {@link SafetyClear#NONE SafetyClear#NONE}).
     *
     * @param clear   The {@link SafetyClear safety clear} option, which helps for specifying different message types, which will not be deleted
     * @param channel The {@link TextChannel text channel}, which should be initialized
     * @return A list of messages representing the precursor of all deletion tasks
     */
    @NotNull
    @CheckReturnValue
    protected static List<Message> checkChannelClearSafety(@Nullable SafetyClear clear, @NotNull TextChannel channel)
    {
        List<Message> messages = new ArrayList<>();

        if (clear == null)
        {
            clear = SafetyClear.NONE;
        }

        for (Message message : channel.getIterableHistory().cache(false))
        {
            switch (clear)
            {
                case NONE:
                    if (message.isFromGuild())
                    {
                        messages.add(message);
                    }
                    break;
                case ALL:
                    if (!message.isEdited() && !message.isPinned() && !message.isWebhookMessage())
                    {
                        messages.add(message);
                    }
                    break;
                case PINNED_MESSAGES:
                    if (!message.isPinned())
                    {
                        messages.add(message);
                    }
                    break;
                case WEBHOOK_MESSAGES:
                    if (!message.isWebhookMessage())
                    {
                        messages.add(message);
                    }
                    break;
                case EDITED_MESSAGES:
                    if (!message.isEdited())
                    {
                        messages.add(message);
                    }
                    break;
                default:
                    break;
            }
        }
        return messages;
    }

    /**
     * Checks, which {@link SafetyClear safety clear} enum is given. (if <b>clear</b> equals null, the
     * {@link SafetyClear safety clear} enum will be set to {@link SafetyClear#NONE SafetyClear#NONE}).
     *
     * @param clear   The {@link SafetyClear safety clear} option, which helps for specifying different message types, which will not be deleted
     * @param channel The {@link MessageChannel message channel}, which should be initialized
     * @return A list of messages representing the precursor of all deletion tasks
     */
    @NotNull
    @CheckReturnValue
    protected static List<Message> checkChannelClearSafety(@Nullable SafetyClear clear, @NotNull MessageChannel channel)
    {
        List<Message> messages = new ArrayList<>();

        if (clear == null)
        {
            clear = SafetyClear.NONE;
        }

        for (Message message : channel.getIterableHistory().cache(false))
        {
            switch (clear)
            {
                case NONE:
                    if (message.isFromGuild())
                    {
                        messages.add(message);
                    }
                    break;
                case ALL:
                    if (!message.isEdited() && !message.isPinned() && !message.isWebhookMessage())
                    {
                        messages.add(message);
                    }
                    break;
                case PINNED_MESSAGES:
                    if (!message.isPinned())
                    {
                        messages.add(message);
                    }
                    break;
                case WEBHOOK_MESSAGES:
                    if (!message.isWebhookMessage())
                    {
                        messages.add(message);
                    }
                    break;
                case EDITED_MESSAGES:
                    if (!message.isEdited())
                    {
                        messages.add(message);
                    }
                    break;
                default:
                    break;
            }
        }
        return messages;
    }

    /**
     * Calculates the delay, depending on which {@link TimeUnit time unit} is specified.
     *
     * @param unit           The {@link TimeUnit time unit}, which should be used for calculating each time (if {@link TimeUnit time unit} equals null the
     *                       default {@link TimeUnit time unit} will be used [{@link TimeUnit#SECONDS TimeUnit#SECONDS}])
     * @param delayInSeconds The delay in seconds which should be converted
     * @return The delay calculated to the specified {@link TimeUnit time unit}
     */
    protected static long calculateDelay(@Nullable TimeUnit unit, long delayInSeconds)
    {
        if (unit == null)
        {
            unit = TimeUnit.SECONDS;
        }

        if (delayInSeconds == 0)
        {
            logger.error("The delay in seconds, which you are specifying, equals 0, so it makes no sense that you chose a timeouted message.",
                    new IllegalArgumentException());
        }

        if (delayInSeconds < 0)
        {
            logger.error("The delay in seconds, which you are specifying, can not be under 0.",
                    new IllegalArgumentException());
        }


        long delay = 0;
        switch (unit)
        {
            case NANOSECONDS:
                delay = delayInSeconds / 1000000;
                break;
            case MICROSECONDS:
                delay = delayInSeconds / 1000;
                break;
            case MILLISECONDS:
                delay = delayInSeconds;
                break;
            case SECONDS:
                delay = delayInSeconds * 1000;
                break;
            case MINUTES:
                delay = delayInSeconds * 60000;
                break;
            case HOURS:
                delay = delayInSeconds * 3600000;
                break;
            case DAYS:
                delay = delayInSeconds * 86400000;
                break;
            default:
                break;
        }
        return delay;
    }

    /**
     * The {@link Utility#map hash map} instance from the {@link Utility utility} class.
     *
     * @return {@link Utility#map Utility#map}
     */
    @NotNull
    @CheckReturnValue
    public static HashMap<Long, Long> getHashMap()
    {
        return map;
    }
}
