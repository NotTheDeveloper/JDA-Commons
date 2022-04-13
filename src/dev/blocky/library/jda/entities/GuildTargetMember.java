package dev.blocky.library.jda.entities;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;

import javax.annotation.Nonnull;

/**
 * Represents the {@link net.dv8tion.jda.api.entities.Member member} instance for the target
 * {@link net.dv8tion.jda.api.entities.User User}.
 *
 * @author BlockyDotJar
 * @version v1.0.0
 * @since v1.0.0-alpha.4
 */
public class GuildTargetMember {
    private UserContextInteractionEvent userEvent;
    private MessageContextInteractionEvent messageEvent;

    /**
     * Constructs a <b>new</b> {@link dev.blocky.library.jda.entities.GuildTargetMember Guild Target Member} instance. If you don't
     * initialize a {@link net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent
     * User Context Interaction Event}, {@link dev.blocky.library.jda.entities.GuildTargetMember Guild Target Member}
     * always will be <b>null</b>.
     *
     * @param userEvent The {@link net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent
     *                  User Context Interaction Event}, which should be initialized.
     */
    public GuildTargetMember(@Nonnull UserContextInteractionEvent userEvent) {
        this.userEvent = userEvent;
    }


    /**
     * Constructs a <b>new</b> {@link dev.blocky.library.jda.entities.GuildTargetMember Guild Target Member} instance. If you don't
     * initialize a {@link net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent
     * Message Context Interaction Event}, {@link dev.blocky.library.jda.entities.GuildTargetMember Guild Target Member}
     * always will be <b>null</b>.
     *
     * @param messageEvent The {@link net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent
     *                     Message Context Interaction Event}, which should be initialized.
     */
    public GuildTargetMember(@Nonnull MessageContextInteractionEvent messageEvent) {
        this.messageEvent = messageEvent;
    }

    /**
     * Constructs a <b>new</b> {@link dev.blocky.library.jda.entities.GuildTargetMember Guild Target Member} instance. If you don't
     * initialize a {@link net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent
     * User Context Interaction Event} or a {@link net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent
     * Message Context Interaction Event}, {@link dev.blocky.library.jda.entities.GuildTargetMember Guild Target Member}
     * always will be <b>null</b>.
     *
     * @param userEvent    The {@link net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent
     *                     User Context Interaction Event}, which should be initialized.
     * @param messageEvent The {@link net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent
     *                     Message Context Interaction Event}, which should be initialized.
     */
    public GuildTargetMember(@Nonnull UserContextInteractionEvent userEvent, @Nonnull MessageContextInteractionEvent messageEvent) {
        this.userEvent = userEvent;
        this.messageEvent = messageEvent;
    }

    /**
     * Checks if a
     * {@link net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent#getTargetMember()
     * Target Member} is a Server Booster or not.
     *
     * @return <b>true</b> If the target member is boosting the server. <br>
     * <b>false</b> If the target member is not boosting the server.
     */
    public boolean isServerBooster() {
        return userEvent.getTargetMember().getTimeBoosted() != null || messageEvent.getTarget().getMember().getTimeBoosted() != null;
    }
}
