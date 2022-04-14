package dev.blocky.library.testzone.commands.app.message;

import dev.blocky.library.jda.interfaces.app.message.IMessageContext;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;

import javax.annotation.Nonnull;

/**
 * This is a simple id message context command
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0
 */
public class IDMessageContextCommand implements IMessageContext {

    @Override
    public void onMessageContext(@Nonnull MessageContextInteractionEvent event) {
        event.reply(event.getMember().getId()).queue();
    }
}
