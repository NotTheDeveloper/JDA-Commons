package dev.blocky.library.jda.entities.manager;

import dev.blocky.library.jda.annotations.Deadline;

import javax.annotation.Nonnull;

/**
 * This is a controller you can control guilds with.
 * <br>
 * The exact use is still unknown.
 *
 * @author BlockyDotJar
 * @version v1.0.0-alpha.1
 * @since v1.0.0
 */
@Deadline(version = "v1.5.0")
public class GuildController {

    /**
     * Constructs a new {@link dev.blocky.library.jda.entities.manager.GuildController Guild Controller}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     */
    private GuildController() {
    }

    /**
     * Represents a new {@link dev.blocky.library.jda.entities.manager.GuildController Guild Controller} instance
     *
     * @return new {@link dev.blocky.library.jda.entities.manager.GuildController Guild Controller}
     */
    @Nonnull
    public static GuildController getGuildController() {
        return new GuildController();
    }
}
