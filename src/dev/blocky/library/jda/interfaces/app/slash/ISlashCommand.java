package dev.blocky.library.jda.interfaces.app.slash;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import javax.annotation.Nonnull;

/**
 * A simple Slash Command Interface, which you can use to easily program some slash commands.
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0
 */
public interface ISlashCommand {

    /**
     * An interface, which you can use to easily program some slash commands.
     *
     * <br>
     * <p>
     * This contains a <a href=
     * "https://github.com/BlockyDotJar/JDA-Commons/tree/main/src/dev/blocky/library/testzone/ApplicationCommandManager.java">Application
     * Command Manager</a>.
     *
     * @param event Indicates that a slash command was used in a
     *              {@link net.dv8tion.jda.api.entities.MessageChannel
     *              MessageChannel}.
     */
    void onSlashCommand(@Nonnull SlashCommandInteractionEvent event);
}
