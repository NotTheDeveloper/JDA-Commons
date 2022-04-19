package dev.blocky.library.jda.entities;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;

/**
 * Represents the Self Member (aka. the bot itself) of a specific {@link Guild Guild}.
 *
 * @author BlockyDotJar
 * @version v1.0.0
 * @since v1.0.1
 */
public class SelfMember {
    private Guild guild;

    /**
     * Constructs a new {@link SelfMember Self Member}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     */
    private SelfMember() {
    }

    /**
     * Constructs a new {@link SelfMember Self Member}
     *
     * @param guild The {@link Guild Guild}, which should be used to get {@link SelfMember Self Member}
     */
    public SelfMember(Guild guild) {
        this.guild = guild;
    }

    /**
     * Checks if {@link SelfMember Self Member} was pinged in a specified message.
     *
     * @param message The {@link Message Message}, which should checked, if there is a {@link SelfMember Self Member} ping in it
     * @return <b>true -</b> If the {@link SelfMember Self Member} was pinged
     * <b>false -</b> If the {@link SelfMember Self Member} was not pinged
     */
    public boolean isPinged(Message message) {
        return message.getContentDisplay().startsWith("@" + guild.getSelfMember().getEffectiveName());
    }
}
