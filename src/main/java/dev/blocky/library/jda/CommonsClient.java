package dev.blocky.library.jda;

import dev.blocky.library.jda.annotations.Deadline;
import dev.blocky.library.jda.entities.SelfMember;
import net.dv8tion.jda.api.entities.Guild;

import javax.annotation.Nonnull;

/**
 * This is a Client for the JDA-Commons Library.
 * <br>
 * The exact use is still unknown.
 *
 * @author BlockyDotJar
 * @version v1.0.0-alpha.1
 * @since v1.0.0
 */
@Deadline(version = "v1.5.0")
public final class CommonsClient {

    /**
     * Constructs a new {@link CommonsClient Commons Client}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     */
    private CommonsClient() {
    }

    /**
     * Get a new {@link SelfMember}, by initializing a specific {@link Guild Guild}
     *
     * @param guild The guild, which should be used to get the {@link SelfMember Self Member}
     * @return A <b>new</b> {@link SelfMember Self Member} instance
     */
    public SelfMember getSelfMember(Guild guild) {
        return new SelfMember(guild);
    }

    /**
     * This is the Builder for the {@link CommonsClient Commons Client}
     *
     * @author BlockyDotJar
     * @version v1.0.0-alpha.1
     * @since v1.0.0
     */
    @Deadline(version = "v1.6.0")
    public static class Builder {

        /**
         * Represents a new {@link CommonsClient Commons Client} instance
         *
         * @return new {@link CommonsClient Commons Client}
         */
        @Nonnull
        public static CommonsClient getCommonsClient() {
            return new CommonsClient();
        }
    }
}
