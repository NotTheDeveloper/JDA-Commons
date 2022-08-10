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

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.utils.data.DataObject;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to access the mentions of various entities.
 *
 * @author BlockyDotJar
 * @version v1.0.0
 * @since v1.1.6
 */
public class MessageMention
{
    private final List<String> mentionedSlashCommands = new ArrayList<>();
    private final Bag<String>  mentionedSlashCommandsBag = new HashBag<>();
    private final Message message;
    private final String content;

    private MessageMention(@NotNull Message message)
    {
        this.message = message;
        this.content = message.getContentRaw();
    }

    /**
     * Constructs a <b>new</b> {@link MessageMention} instance.
     * <br>If you don't initialize a {@link Message}, the {@link MessageMention} always will be <b>null</b>.
     *
     * @param message The {@link Message}, which should be used to get a {@link MessageMention}.
     *
     * @return A <b>new</b> {@link MessageMention} instance.
     */
    @NotNull
    public static MessageMention set(@NotNull Message message)
    {
        return new MessageMention(message);
    }

    /**
     * The received {@link Message} object.
     *
     * @return The received {@link Message} object.
     */
    @NotNull
    public Message getMessage()
    {
        return message;
    }

    /**
     * An immutable {@link List} of all mentioned slash-commands.
     * <br>If none were mentioned, this {@link List} is empty.
     * <br>Elements are sorted in order of appearance.
     *
     * @return A {@link List} of all mentioned slash-commands.
     */
    @NotNull
    public synchronized List<String> getSlashCommands()
    {
        Pattern pattern = Type.SLASH_COMMAND.getPattern();
        Matcher matcher = pattern.matcher(content);

        while (matcher.find())
        {
            mentionedSlashCommands.add(matcher.group());
        }
        return mentionedSlashCommands;
    }

    /**
     * A {@link Bag} of slash-commands used.
     * <br>This can be used to retrieve the amount of times a slash-command was used.
     * <br><b>Example:</b>
     * <br><pre>{@code
     * void sendCount(@NotNull MessageMention msg)
     * {
     *     List<String> mentions = msg.getSlashCommands(); // distinct list, in order of appearance
     *     Bag<String> count = msg.getSlashCommandsBag();
     *     StringBuilder content = new StringBuilder();
     *     for (String slash : mentions)
     *     {
     *         content.append(slash)
     *                .append(": ")
     *                .append(count.getCount(slash))
     *                .append("\n");
     *     }
     *     msg.getMessage().getChannel().sendMessage(content.toString()).queue();
     * }
     * }</pre>
     *
     * @return {@link Bag} of used slash-commands.
     */
    @NotNull
    public Bag<String> getSlashCommandsBag()
    {
        Pattern pattern = Type.SLASH_COMMAND.getPattern();
        Matcher matcher = pattern.matcher(content);

        while (matcher.find())
        {
            mentionedSlashCommandsBag.add(matcher.group());
        }
        return mentionedSlashCommandsBag;
    }

    /**
     * Checks if given {@link Type} is mentioned in the {@link Message}.
     *
     * @param type The {@link Type} to check for.
     *
     * @return <b>true</b> - If the {@link Type} is mentioned in the {@link Message}.
     *         <br><b>false</b> - If the {@link Type} is not mentioned in the {@link Message}.
     */
    public boolean isMentioned(@NotNull Type type)
    {
        return type.getPattern().matcher(content).find();
    }

    /**
     * Creates a slash-command mention for you.
     * <br>Only use this method in combination with {@link Event#getRawData() SlashCommandEventInteractionEvent.getRawData()} .
     *
     * @param rawData The {@link DataObject} to parse. (Only use this method in combination with {@link Event#getRawData()
     * SlashCommandEventInteractionEvent.getRawData()}).
     *
     * @return The slash-command mention as a string.
     */
    @NotNull
    public static String createSlashCommandMention(@NotNull DataObject rawData)
    {
        DataObject d = rawData.getObject("d");
        DataObject data = d.getObject("data");

        return "</"
                + (data.isNull("name") ? null : data.getString("name"))
                + ":" + (data.isNull("id") ? 0 : data.getString("id")) +
                ">";
    }

    /**
     * Mention constants, useful for use with {@link Pattern Patterns}.
     *
     * @author BlockyDotJar
     * @version v1.0.0
     * @since v1.1.6
     */
    public enum Type
    {
        /**
         * Represents a mention for a slash-command.
         * <br>The first group matches the name of the command and the second the id of the mention.
         */
        SLASH_COMMAND("</([a-zA-Z0-9_/[^\\S\\r\\n]/-]+):([0-9]+)>");

        private final Pattern pattern;

        Type(@NotNull String regex)
        {
            this.pattern = Pattern.compile(regex);
        }

        @NotNull
        public Pattern getPattern()
        {
            return pattern;
        }

        @Override
        public String toString()
        {
            return "Type{" +
                    "pattern=" + pattern +
                    '}';
        }
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

        MessageMention that = (MessageMention) o;

        return mentionedSlashCommands.equals(that.mentionedSlashCommands) && mentionedSlashCommandsBag.equals(that.mentionedSlashCommandsBag) && message.equals(that.message) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(mentionedSlashCommands, mentionedSlashCommandsBag, message, content);
    }

    @NotNull
    @Override
    public String toString()
    {
        return "MessageMention{" +
                "mentionedSlashCommands=" + mentionedSlashCommands +
                ", mentionedSlashCommandsBag=" + mentionedSlashCommandsBag +
                ", message=" + message +
                ", content='" + content + '\'' +
                '}';
    }
}
