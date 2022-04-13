package dev.blocky.library.jda;

import dev.blocky.library.jda.annotations.Deadline;

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
     * Constructs a new {@link dev.blocky.library.jda.CommonsClient Commons Client}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     */
    private CommonsClient() {
    }

    /**
     * This is the Builder for the {@link dev.blocky.library.jda.CommonsClient Commons Client}
     *
     * @author BlockyDotJar
     * @version v1.0.0-alpha.1
     * @since v1.0.0
     */
    @Deadline(version = "v1.6.0")
    public static class Builder {

        /**
         * Represents a new {@link dev.blocky.library.jda.CommonsClient Commons Client} instance
         *
         * @return new {@link dev.blocky.library.jda.CommonsClient Commons Client}
         */
        @Nonnull
        public static CommonsClient getCommonsClient() {
            return new CommonsClient();
        }
    }
}
