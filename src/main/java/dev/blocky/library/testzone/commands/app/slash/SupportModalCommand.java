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
package dev.blocky.library.testzone.commands.app.slash;

import dev.blocky.library.jda.interfaces.app.slash.ISlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.Modal;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import org.jetbrains.annotations.NotNull;

/**
 * This is a simple modal slash command.
 *
 * @author BlockyDotJar
 * @version v1.1.0
 * @since v1.1.1
 */
public class SupportModalCommand implements ISlashCommand
{
    @Override
    public void onSlashCommand(@NotNull SlashCommandInteractionEvent event)
    {
        TextInput email =
                TextInput.create("email", "Email", TextInputStyle.SHORT) // Creates a text input with a SHORT input style.
                .setPlaceholder("Enter your E-mail")
                .setRequiredRange(10, 100) // Sets a minimum of 10 and a maximum of 100 required characters.
                .build();

        TextInput body =
                TextInput.create("body", "Body", TextInputStyle.PARAGRAPH) // Creates a text input with a PARAGRAPH input style.
                .setPlaceholder("Your concerns go here")
                .setRequiredRange(30, 1000) // Sets a minimum of 30 and a maximum of 1000 required characters.
                .build();

        // Creates the modal, by simply pasting the two TextInputs into two different action rows.
        Modal modal =
                Modal.create("support", "Support")
                .addActionRows(ActionRow.of(email), ActionRow.of(body))
                .build();

        // Sends the modal.
        event.replyModal(modal).queue();
    }
}
