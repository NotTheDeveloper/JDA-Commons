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

import dev.blocky.library.jda.interfaces.app.slash.ISlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.EntitySelectMenu;
import org.jetbrains.annotations.NotNull;

import static net.dv8tion.jda.api.interactions.components.selections.EntitySelectMenu.SelectTarget.*;

/**
 * This is a simple command, which shows how to use an {@link EntitySelectMenu}.
 *
 * @author BlockyDotJar
 * @version v1.0.0
 * @since v1.2.0-pr.6
 */
public class EntitySelectSlashCommand implements ISlashCommand
{
    @Override
    public void onSlashCommand(@NotNull SlashCommandInteractionEvent event)
    {
        final String userID = event.getUser().getId();

        // Replies a message with a channel, role and user SelectMenu.
        event.reply("Select a channel, role or user!")
                .addActionRow(
                        // Creates a channel SelectMenu.
                        EntitySelectMenu.create("channel-select", CHANNEL) // Sets the id and type of this SelectMenu.
                                .setEntityTypes(CHANNEL) // Sets the type to CHANNEL (if you want to specify channel types, you can use setChannelTypes(...))
                                .setPlaceholder("Choose a channel!")
                                .build()
                )
                .addActionRow(
                        // Creates a role SelectMenu.
                        EntitySelectMenu.create("role-select", ROLE) // Sets the id and type of this SelectMenu.
                                .setEntityTypes(ROLE) // Sets the type to ROLE.
                                .setPlaceholder("Choose a role!")
                                .build()
                )
                .addActionRow(
                        // Creates a user SelectMenu.
                        EntitySelectMenu.create("user-select", USER) // Sets the id and type of this SelectMenu.
                                .setEntityTypes(USER) // Sets the type to USER.
                                .setPlaceholder("Choose a user!")
                                .build()
                )
                .addActionRow(Button.danger(userID + ":delete", "Delete message!")) // Adds a button in a different action row.
                .queue();
    }
}
