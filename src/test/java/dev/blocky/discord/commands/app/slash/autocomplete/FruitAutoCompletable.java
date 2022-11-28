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
package dev.blocky.discord.commands.app.slash.autocomplete;

import dev.blocky.library.jda.interfaces.app.slash.IAutoCompletable;
import dev.blocky.library.jda.manager.GuildController;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.Command;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * This is a simple slash-command with auto-complete.
 *
 * @author BlockyDotJar
 * @version v1.1.4
 * @since v1.1.4
 */
public class FruitAutoCompletable implements IAutoCompletable
{
    private final String[] words =
            {
                    // An autocompletion can suggest up to 25 options.
                    "apple", "apricot", "banana", "cherry", "coconut", "cranberry"
            };

    @Override
    public void onCommandAutoComplete(@NotNull CommandAutoCompleteInteractionEvent event)
    {
        // Checks if the current used option has the name 'name'.
        if (event.getFocusedOption().getName().equals("fruit"))
        {
            final GuildController controller = new GuildController(event.getGuild());
            // Maps the words to choices and only displays words that start with the user's current input.
            final List<Command.Choice> options = controller.upsertAutocompleteCommand(event.getFocusedOption(), words);

            event.replyChoices(options).queue();
        }
    }
}
