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
package dev.blocky.discord.commands.app.slash;

import dev.blocky.discord.commands.app.slash.autocomplete.FruitAutoCompletable;
import dev.blocky.library.jda.interfaces.app.slash.ISlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * This is the implementation class of {@link FruitAutoCompletable}.
 *
 * @author BlockyDotJar
 * @version v1.0.2
 * @since v1.1.4
 */
public class FruitSlashCommand implements ISlashCommand
{

    @Override
    public void onSlashCommand(@NotNull SlashCommandInteractionEvent event)
    {
        switch (event.getOption("name").getAsString())
        {
        case "apple" -> event.reply("Apple was chosen.").queue();
        case "apricot" -> event.reply("Apricot was chosen.").queue();
        case "banana" -> event.reply("Banana was chosen.").queue();
        case "cherry" -> event.reply("Cherry was chosen.").queue();
        case "coconut" -> event.reply("Coconut was chosen.").queue();
        case "cranberry" -> event.reply("Cranberry was chosen.").queue();
        default -> event.reply("Unknown fruit.").queue();
        }
    }
}
