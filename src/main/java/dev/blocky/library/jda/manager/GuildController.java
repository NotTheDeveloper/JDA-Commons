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
package dev.blocky.library.jda.manager;

import com.google.errorprone.annotations.CheckReturnValue;
import dev.blocky.library.jda.annotations.Deadline;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.interactions.AutoCompleteQuery;
import net.dv8tion.jda.api.interactions.callbacks.IAutoCompleteCallback;
import net.dv8tion.jda.api.interactions.commands.Command;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This is a controller you can control guilds with.
 * <br>The exact use is still <b>unknown</b>.
 *
 * @param guild The {@link Guild}, which should be used to get the {@link GuildController}.
 *
 * @author BlockyDotJar
 * @version v1.0.0-beta.2
 * @since v1.0.0
 */
@Deadline(version = "v1.3.0")
public record GuildController(@NotNull Guild guild)
{

    /**
     * As the user is typing an argument that has autocomplete enabled for it, the bot will receive an
     * {@link CommandAutoCompleteInteractionEvent}.
     * <br>This event isn't fired for each keystroke, but is sent when Discord determines the user has paused typing for a bit.
     *
     * <p>An autocompletion can suggest up to 25 options, and users don't have to send a command with one of the options.
     * <br>Maps the words to choices and only displays words that start with the user's current input.
     *
     * @param query The query input for a {@link IAutoCompleteCallback}.
     * @param words An array of words that can be displayed in the autocomplete menu.
     *
     * @return A {@link List} of {@link Command.Choice}, you can use to display it with
     * {@link CommandAutoCompleteInteractionEvent#replyChoices(Collection)}.
     */
    @NotNull
    @CheckReturnValue
    public List<Command.Choice> upsertAutocompleteCommand(@NotNull AutoCompleteQuery query, @NotNull String[] words)
    {
        return Stream.of(words)
                .filter(word -> word.startsWith(query.getValue()))
                .map(word -> new Command.Choice(word, word))
                .collect(Collectors.toList());
    }
}
