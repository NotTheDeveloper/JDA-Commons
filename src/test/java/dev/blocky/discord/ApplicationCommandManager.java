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
package dev.blocky.discord;

import dev.blocky.discord.commands.app.message.RickRollMessageContextCommand;
import dev.blocky.discord.commands.app.slash.EntitySelectSlashCommand;
import dev.blocky.discord.commands.app.slash.FruitSlashCommand;
import dev.blocky.discord.commands.app.slash.PingSlashCommand;
import dev.blocky.discord.commands.app.slash.autocomplete.FruitAutoCompletable;
import dev.blocky.discord.commands.app.slash.modal.SupportModalCommand;
import dev.blocky.discord.commands.app.user.AvatarUserContextCommand;
import dev.blocky.library.jda.entities.member.GuildMember;
import dev.blocky.library.jda.interfaces.app.message.IMessageContext;
import dev.blocky.library.jda.interfaces.app.slash.IAutoCompletable;
import dev.blocky.library.jda.interfaces.app.slash.ISlashCommand;
import dev.blocky.library.jda.interfaces.app.user.IUserContext;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.EntitySelectInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
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
 * {@link ButtonInteractionEvent button interactions},
 * {@link StringSelectInteractionEvent string select interactions} and
 * {@link EntitySelectInteractionEvent entitiy select interactions}.
 *
 * @author BlockyDotJar
 * @version v2.2.3
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
        slashMap.put("entity-select", new EntitySelectSlashCommand());

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
                )
                .addCommands(
                        Commands.slash("ping", "Shows the ping of the bot!")
                )
                .addCommands(
                        Commands.slash("support", "Sends an modal with different questions!")
                )
                .addCommands(
                        Commands.slash("entity-select", "Sends some entity select menus!")
                )
                .addCommands(
                        Commands.user("avatar")
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
        final String commandName = event.getName();
        final ISlashCommand command = slashMap.get(commandName);

        command.onSlashCommand(event);

        logger.debug(event.getGuild() == null ? "The specified guild equals null." : "Successfully found guild.");
    }

    @Override
    public void onCommandAutoCompleteInteraction(@NotNull CommandAutoCompleteInteractionEvent event)
    {
        final String commandName = event.getName();
        final IAutoCompletable command = autoCompletableMap.get(commandName);

        command.onCommandAutoComplete(event);

        logger.debug(event.getGuild() == null ? "The specified guild equals null." : "Successfully found guild.");
    }

    @Override
    public void onMessageContextInteraction(@NotNull MessageContextInteractionEvent event)
    {
        final String commandName = event.getName();
        final IMessageContext command = messageMap.get(commandName);

        command.onMessageContext(event);

        logger.debug(event.getGuild() == null ? "The specified guild equals null." : "Successfully found guild.");
    }

    @Override
    public void onUserContextInteraction(@NotNull UserContextInteractionEvent event)
    {
        final String commandName = event.getName();
        final IUserContext command = userMap.get(commandName);

        command.onUserContext(event);

        logger.debug(event.getGuild() == null ? "The specified guild equals null." : "Successfully found guild.");
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event)
    {
        final String[] id = event.getButton().getId().split(":");
        final String authorId = id[0];
        final String type = id[1];

        final EmbedBuilder builder = new EmbedBuilder();

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
    public void onStringSelectInteraction(@NotNull StringSelectInteractionEvent event)
    {
        final String[] id = event.getSelectedOptions().get(0).getValue().split(":");
        final String authorId = id[0];
        final String type = id[1];

        final EmbedBuilder builder = new EmbedBuilder();

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
        case "yes" ->
        {
            event.getMessage().delete().queue();
            event.getChannel().sendMessage("Right choice!")
                    .setActionRow(
                            Button.link("https://www.youtube.com/watch?v=dQw4w9WgXcQ", "GET IT!!!")
                    )
                    .queue();
        }
        case "no" -> event.getMessage().delete().queue();
        default -> { }
        }
    }

    @Override
    public void onEntitySelectInteraction(@NotNull EntitySelectInteractionEvent event)
    {
        switch (event.getSelectMenu().getId())
        {
        case "channel-select" ->
        {
            final GuildChannel guildChannel = event.getMentions().getChannels().get(0);

            event.reply("Channel selected: " + guildChannel.getAsMention() + "!").queue();

            final Guild guild = event.getGuild();
            final MessageChannel channel = guild.getChannelById(MessageChannel.class, guildChannel.getIdLong());

            channel.sendMessage("Hello there!").queue();
        }
        case "role-select" ->
        {
            final GuildMember member = new GuildMember(event.getMember());
            final Role role = event.getMentions().getRoles().get(0);
            final Guild guild = event.getGuild();

            if (!event.getGuild().getSelfMember().canInteract(role))
            {
                event.reply("Can't interact with this role!").queue();
            }

            if (member.hasRoleWithId(role.getIdLong()))
            {
                guild.removeRoleFromMember(UserSnowflake.fromId(event.getUser().getIdLong()), role).queue();
                event.reply("Removed role " + role.getAsMention() + " from user " + event.getMember().getAsMention()).queue();
            }
            else
            {
                guild.addRoleToMember(UserSnowflake.fromId(event.getUser().getIdLong()), role).queue();
                event.reply("Added role " + role.getAsMention() + " to user " + event.getMember().getAsMention()).queue();
            }
        }
        case "user-select" ->
        {
            final User user = event.getMentions().getUsers().get(0);

            event.reply("User selected: " + user.getAsMention() + "!").queue();

            user.openPrivateChannel().queue(
                    (success) -> success.sendMessage("Hello there!").queue(),
                    (failed) -> logger.warn(user.getAsTag() + " doesn't allow private messages")
            );
        }
        default -> { }
        }
    }

    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent event)
    {
        final String email = event.getValue("email").getAsString();
        final String body = event.getValue("body").getAsString();

        final EmbedBuilder builder = new EmbedBuilder();
        final EmbedBuilder success = new EmbedBuilder();

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
