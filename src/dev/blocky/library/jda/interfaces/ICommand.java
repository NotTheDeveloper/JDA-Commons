package dev.blocky.library.jda.interfaces;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import javax.annotation.Nonnull;

/**
 * A simple Command Interface, which you can use to easily program message commands.
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0-alpha.3
 */
public interface ICommand {

    /**
     * An interface, which you can use to easily program message commands.
     *
     * <br>
     * <p>
     * <p>
     * This contains a <a href=
     * "https://github.com/BlockyDotJar/JDA-Commons/tree/main/src/dev/blocky/library/testzone/CommandListener.java">Command
     * Listener</a> and a <a href=
     * "https://github.com/BlockyDotJar/JDA-Commons/tree/main/src/dev/blocky/library/testzone/CommandManager.java">Command
     * Manager</a>.
     *
     * @param event The {@link net.dv8tion.jda.api.events.message.MessageReceivedEvent Message Received Event} for performing a command
     * @param args  An {@link java.lang.reflect.Array Array} of Strings for performing a command
     */
    void onCommand(@Nonnull MessageReceivedEvent event, @Nonnull String[] args);
}
