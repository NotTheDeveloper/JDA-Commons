package dev.blocky.library.testzone.commands.app.user;

import dev.blocky.library.jda.interfaces.app.user.IUserContext;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;

import javax.annotation.Nonnull;

/**
 * This is a simple avatar user context command
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0
 */
public class AvatarUserContextCommand implements IUserContext {

    @Override
    public void onUserContext(@Nonnull UserContextInteractionEvent event) {
        event.reply(event.getTargetMember().getUser().getAvatarUrl()).queue();
    }
}
