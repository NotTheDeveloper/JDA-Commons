package dev.blocky.library.jda.interfaces.app.message;

import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * A simple Message Context Menu Interface, which you can use to easily program some message context menus.
 *
 * @author BlockyDotJar
 * @version v1.0.0
 * @since v1.0.0
 */
public interface IMessageContext {

    /**
     * An interface, which you can use to easily program some message context menus.
     *
     * <br>
     * <p>
     * This contains a
     * <a href="https://github.com/BlockyDotJar/JDA-Commons/blob/main/src/main/java/dev/blocky/library/testzone/ApplicationCommandManager.java">Application Command Manager</a>.
     *
     * @param event Indicates that a message context command was used
     */
    void onMessageContext(@NotNull MessageContextInteractionEvent event);
}
