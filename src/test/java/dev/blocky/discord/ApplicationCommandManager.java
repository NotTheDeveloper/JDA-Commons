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
package dev.blocky.discord;

import dev.blocky.discord.commands.app.message.RickRollMessageContextCommand;
import dev.blocky.discord.commands.app.slash.FruitSlashCommand;
import dev.blocky.discord.commands.app.slash.PingSlashCommand;
import dev.blocky.discord.commands.app.slash.autocomplete.FruitAutoCompletable;
import dev.blocky.discord.commands.app.slash.modal.SupportModalCommand;
import dev.blocky.discord.commands.app.user.AvatarUserContextCommand;
import dev.blocky.library.jda.interfaces.app.message.IMessageContext;
import dev.blocky.library.jda.interfaces.app.slash.IAutoCompletable;
import dev.blocky.library.jda.interfaces.app.slash.ISlashCommand;
import dev.blocky.library.jda.interfaces.app.user.IUserContext;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This is a class, which manages
 * {@link SlashCommandInteractionEvent slash-commands},
 * {@link CommandAutoCompleteInteractionEvent auto-completable slash-commands},
 * {@link MessageContextInteractionEvent message context-menus},
 * {@link UserContextInteractionEvent user context-menus},
 * {@link ModalInteractionEvent modal interactions},
 * {@link ButtonInteractionEvent button interactions} and
 * {@link SelectMenuInteractionEvent select menu interactions}.
 *
 * @author BlockyDotJar
 * @version v2.2.1
 * @since v1.0.0
 */
public class ApplicationCommandManager extends ListenerAdapter
{
    private static final Logger logger = JDALogger.getLog(ApplicationCommandManager.class);
    private final Map<String, IAutoCompletable> autoCompletableMap;
    private final Map<String, ISlashCommand> slashMap;
    private final Map<String, IMessageContext> messageMap;
    private final Map<String, IUserContext> userMap;

    /**
     * Constructs a <b>new</b> {@link ApplicationCommandManager}.
     */
    public ApplicationCommandManager()
    {
        autoCompletableMap = new ConcurrentHashMap<>();
        slashMap = new ConcurrentHashMap<>();
        messageMap = new ConcurrentHashMap<>();
        userMap = new ConcurrentHashMap<>();

        /*
         * Here you can import your auto-completable slash-commands.
         */

        autoCompletableMap.put("fruit", new FruitAutoCompletable());

        /*
         * Here you can import your slash-commands.
         */

        slashMap.put("ping", new PingSlashCommand());
        slashMap.put("support", new SupportModalCommand());
        slashMap.put("fruit", new FruitSlashCommand());

        /*
         * Here you can import your user context-commands.
         */

        userMap.put("avatar", new AvatarUserContextCommand());

        /*
         * Here you can import your message context-commands.
         */

        messageMap.put("rick-roll", new RickRollMessageContextCommand());

        DiscordBotExample.getJDA().updateCommands()
                .addCommands(
                        Commands.slash("fruit", "Find a given fruit!")
                                .addOptions(new OptionData(OptionType.STRING, "name", "The fruit to find!")
                                        .setRequired(true)
                                        .setAutoComplete(true))
                                .setGuildOnly(false)
                )
                .addCommands(
                        Commands.slash("ping", "Shows the ping of the bot!")
                                .setGuildOnly(false)
                )
                .addCommands(
                        Commands.slash("support", "Sends an modal with different questions!")
                                .setGuildOnly(false)
                )
                .addCommands(
                        Commands.user("avatar")
                                .setGuildOnly(false)
                )
                .addCommands(
                        Commands.message("rick-roll")
                                .setGuildOnly(true)
                                .setDefaultPermissions(DefaultMemberPermissions.ENABLED)
                )
                .queue();
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event)
    {
        String commandName = event.getName();
        ISlashCommand command = slashMap.get(commandName);

        command.onSlashCommand(event);

        logger.debug(event.getGuild() == null ? "The specified guild equals null." : "Successfully found guild.");
    }

    @Override
    public void onCommandAutoCompleteInteraction(@NotNull CommandAutoCompleteInteractionEvent event)
    {
        String commandName = event.getName();
        IAutoCompletable command = autoCompletableMap.get(commandName);

        command.onCommandAutoComplete(event);

        logger.debug(event.getGuild() == null ? "The specified guild equals null." : "Successfully found guild.");
    }

    @Override
    public void onMessageContextInteraction(@NotNull MessageContextInteractionEvent event)
    {
        String commandName = event.getName();
        IMessageContext command = messageMap.get(commandName);

        command.onMessageContext(event);

        logger.debug(event.getGuild() == null ? "The specified guild equals null." : "Successfully found guild.");
    }

    @Override
    public void onUserContextInteraction(@NotNull UserContextInteractionEvent event)
    {
        String commandName = event.getName();
        IUserContext command = userMap.get(commandName);

        command.onUserContext(event);

        logger.debug(event.getGuild() == null ? "The specified guild equals null." : "Successfully found guild.");
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event)
    {
        String[] id = event.getButton().getId().split(":");
        String authorId = id[0];
        String type = id[1];

        EmbedBuilder builder = new EmbedBuilder();

        builder.setTitle("An error occurred!");
        builder.setDescription("Only <@" + authorId + "> can use this button!");
        builder.setColor(0xf22613);
        builder.setFooter(event.getMember().getUser().getAsTag());
        builder.setTimestamp(OffsetDateTime.now());

        if (!authorId.equals(event.getUser().getId()))
        {
            event.replyEmbeds(builder.build()).setEphemeral(true).queue();
            return;
        }

        if (type.equals("delete"))
        {
            event.getMessage().delete().queue();
        }
    }

    @Override
    public void onSelectMenuInteraction(@NotNull SelectMenuInteractionEvent event)
    {
        String[] id = event.getSelectedOptions().get(0).getValue().split(":");
        String authorId = id[0];
        String type = id[1];

        EmbedBuilder builder = new EmbedBuilder();

        builder.setTitle("An error occurred!");
        builder.setDescription("Only <@" + authorId + "> can use this select menu!");
        builder.setColor(0xf22613);
        builder.setFooter(event.getMember().getUser().getAsTag());
        builder.setTimestamp(OffsetDateTime.now());

        if (!authorId.equals(event.getUser().getId()))
        {
            event.replyEmbeds(builder.build()).setEphemeral(true).queue();
            return;
        }

        switch (type)
        {
        case "yes":
            event.getMessage().delete().queue();
            event.getChannel().sendMessage("Right choice!")
                    .setActionRow(
                            Button.link("https://www.youtube.com/watch?v=dQw4w9WgXcQ", "GET IT!!!")
                    )
                    .queue();
            break;
        case "no":
            event.getMessage().delete().queue();
            break;
        default:
            break;
        }
    }

    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent event)
    {
        String email = event.getValue("email").getAsString();
        String body = event.getValue("body").getAsString();

        EmbedBuilder builder = new EmbedBuilder();
        EmbedBuilder success = new EmbedBuilder();

        success.setColor(0x00ab2e);
        success.setTitle("Success!");
        success.setTimestamp(OffsetDateTime.now());
        success.setFooter(event.getUser().getAsTag());
        success.setDescription("Thanks for your request!");

        if (!email.contains("@"))
        {
            builder.setTitle("An error occurred!");
            builder.setDescription("Invalid Email! Email must contain a `@`!");
            builder.setColor(0xf22613);
            builder.setFooter(event.getMember().getUser().getAsTag());
            builder.setTimestamp(OffsetDateTime.now());
            event.replyEmbeds(builder.build()).setEphemeral(true).queue();
            return;
        }

        logger.info("Email: " + email + ", Body: " + body);

        event.replyEmbeds(success.build()).setEphemeral(true).queue();
    }
}
