package dev.blocky.library.testzone;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import dev.blocky.library.jda.interfaces.app.message.IMessageContext;
import dev.blocky.library.jda.interfaces.app.slash.ISlashCommand;
import dev.blocky.library.jda.interfaces.app.user.IUserContext;
import dev.blocky.library.testzone.commands.app.message.IDMessageContextCommand;
import dev.blocky.library.testzone.commands.app.slash.PingSlashCommand;

import dev.blocky.library.testzone.commands.app.user.AvatarUserContextCommand;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;

/**
 * This is a class, which manages
 * {@link net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
 * Slash Commands},
 * {@link net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent
 * Message Context Menus} and
 * {@link net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent
 * User Context Menus}
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0
 */
public class ApplicationCommandManager extends ListenerAdapter {
    private static Map<String, ISlashCommand> slashMap;
    private static Map<String, IUserContext> userMap;
    private static Map<String, IMessageContext> messageMap;

    private static final Logger logger = LoggerFactory.getLogger(ApplicationCommandManager.class);

    /**
     * Constructs a new {@link dev.blocky.library.testzone.ApplicationCommandManager
     * Application Command Manager}
     */
    public ApplicationCommandManager() {
        slashMap = new ConcurrentHashMap<>();
        userMap = new ConcurrentHashMap<>();
        messageMap = new ConcurrentHashMap<>();

        /*
         * Here you can import your Slash Commands
         */

        slashMap.put("ping", new PingSlashCommand());

        /*
         * Here you can import your User Context Commands
         */

        userMap.put("avatar", new AvatarUserContextCommand());

        /*
         * Here you can import your Message Context Commands
         */

        messageMap.put("userID", new IDMessageContextCommand());

        DiscordBotExample.getJDA().updateCommands()
                .addCommands(Commands.slash("ping", "Shows the ping of the bot!"))
                .addCommands(Commands.user("avatar"))
                .addCommands(Commands.message("userID"))
                .queue();
    }

    @Override
    public void onSlashCommandInteraction(@Nonnull SlashCommandInteractionEvent event) {
        String commandName = event.getName();
        ISlashCommand command = slashMap.get(commandName);

        command.onSlashCommand(event);

        logger.debug(event.getGuild() == null ? "The specified Guild equals null" : "Successfully found guild");
    }

    @Override
    public void onMessageContextInteraction(@Nonnull MessageContextInteractionEvent event) {
        String commandName = event.getName();
        IMessageContext command = messageMap.get(commandName);

        command.onMessageContext(event);

        logger.debug(event.getGuild() == null ? "The specified Guild equals null" : "Successfully found guild");
    }

    @Override
    public void onUserContextInteraction(@Nonnull UserContextInteractionEvent event) {
        String commandName = event.getName();
        IUserContext command = userMap.get(commandName);

        command.onUserContext(event);

        logger.debug(event.getGuild() == null ? "The specified Guild equals null" : "Successfully found guild");
    }
}
