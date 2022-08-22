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

import com.google.errorprone.annotations.CheckReturnValue;
import dev.blocky.library.jda.enums.SafetyClear;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This is a class, which has many utility methods in it.
 *
 * @author BlockyDotJar
 * @version v1.1.5
 * @since v1.0.0
 */
public class Utility
{
    private final static Logger logger = JDALogger.getLog(Utility.class);
    private static final HashMap<Long, Long> map = new HashMap<>();

    /**
     * Constructs a <b>new</b> {@link Utility}.
     * <br>This is a private constructor, because it should not be accessed for other classes.
     */
    protected Utility()
    {
    }

    /**
     * Checks, which {@link SafetyClear} enum is given. (if the {@code clear} parameter equals <b>null</b>, the {@link SafetyClear}
     * enum will be set to {@link SafetyClear#NONE NONE})
     *
     * @param clear The {@link SafetyClear} option, which helps for specifying different message types, which will not be deleted.
     * @param channel The {@link MessageChannelUnion}, which should be initialized.
     * @param amount The amount of messages to delete.
     *
     * @return A {@link List} of messages representing the precursor of all deletion tasks.
     */
    @NotNull
    @CheckReturnValue
    protected static List<Message> checkClearSafety(@Nullable SafetyClear clear, @NotNull MessageChannelUnion channel, int amount)
    {
        List<Message> messages = new ArrayList<>();

        if (clear == null)
        {
            clear = SafetyClear.NONE;
            logger.info("'clear' equals null, defaulting to 'NONE'");
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
                messages.add(message);
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
     * Checks, which {@link SafetyClear} enum is given. (if the {@code clear} parameter equals <b>null</b>, the {@link SafetyClear}
     * enum will be set to {@link SafetyClear#NONE NONE})
     *
     * @param clear The {@link SafetyClear} option, which helps for specifying different message types, which will not be deleted.
     * @param channel The {@link MessageChannelUnion}, which should be initialized.
     *
     * @return A {@link List} of messages representing the precursor of all deletion tasks.
     */
    @NotNull
    @CheckReturnValue
    protected static List<Message> checkChannelClearSafety(@Nullable SafetyClear clear, @NotNull MessageChannelUnion channel)
    {
        List<Message> messages = new ArrayList<>();

        if (clear == null)
        {
            clear = SafetyClear.NONE;
            logger.info("'clear' equals null, defaulting to 'NONE'");
        }

        for (Message message : channel.getIterableHistory().cache(false))
        {
            switch (clear)
            {
            case NONE:
                messages.add(message);
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
     * Calculates the delay, depending on which {@link TimeUnit} is specified.
     *
     * @param unit The {@link TimeUnit}, which should be used for calculating each time. (if the {@code unit} parameter
     *             equals <b>null</b>, {@link TimeUnit#SECONDS SECONDS} will be used)
     * @param delayInSeconds The delay in seconds which should be converted.
     *
     * @return The delay calculated to the specified {@link TimeUnit}.
     */
    protected static long calculateDelay(@Nullable TimeUnit unit, long delayInSeconds)
    {
        if (unit == null)
        {
            unit = TimeUnit.SECONDS;
            logger.info("'unit' equals null, defaulting to 'SECONDS'");
        }

        if (delayInSeconds == 0)
        {
            throw new IllegalArgumentException("The delay in seconds, which you are specifying, equals 0, so it makes no sense that you chose a timeouted message.");
        }

        if (delayInSeconds < 0)
        {
            throw new IllegalArgumentException("The delay in seconds, which you are specifying, can not be under 0.");
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
     * The {@link Utility#map} instance from the {@link Utility} class.
     *
     * @return {@link Utility#map}.
     */
    @NotNull
    protected static HashMap<Long, Long> getHashMap()
    {
        return map;
    }
}
