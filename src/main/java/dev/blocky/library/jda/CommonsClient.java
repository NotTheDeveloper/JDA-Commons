/**
 * Copyright 2022 Dominic (aka. BlockyDotJar)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.blocky.library.jda;

import dev.blocky.library.jda.annotations.Deadline;

import org.jetbrains.annotations.NotNull;

/**
 * This is a client for the JDA-Commons library.
 * <br>The exact use is still unknown.
 *
 * @author BlockyDotJar
 * @version v1.0.0-alpha.4
 * @since v1.0.0
 */
@Deadline(version = "v1.5.0")
public final class CommonsClient
{
    /**
     * Constructs a <b>new</b> {@link CommonsClient commons client}.
     * <br>This is a private constructor, because it should not be accessed for other classes.
     */
    private CommonsClient()
    {
    }

    /**
     * This is the builder for the {@link CommonsClient commons client}.
     *
     * @author BlockyDotJar
     * @version v1.0.0-alpha.5
     * @since v1.0.0
     */
    @Deadline(version = "v1.6.0")
    public static class Builder
    {

        /**
         * Constructs a <b>new</b> {@link CommonsClient.Builder commons client builder}.
         * <br>This is a private constructor, because it should not be accessed for other classes.
         */
        private Builder()
        {
        }

        /**
         * Represents a <b>new</b> {@link CommonsClient commons client} instance.
         *
         * @return A <b>new</b> {@link CommonsClient commons client} instance
         */
        @NotNull
        public static CommonsClient getCommonsClient()
        {
            return new CommonsClient();
        }
    }
}
