/**
 * Copyright 2022 Dominic (aka. BlockyDotJar)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.blocky.library.jda.entities;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the Self Member (aka. the bot itself) of a specific {@link Guild Guild}.
 *
 * @author BlockyDotJar
 * @version v1.0.0
 * @since v1.0.1
 */
public class SelfMember {
    private static final Logger logger = LoggerFactory.getLogger(SelfMember.class);
    private Guild guild;

    /**
     * Constructs a <b>new</b> {@link SelfMember Self Member}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     */
    private SelfMember() {
    }

    /**
     * Constructs a <b>new</b> {@link SelfMember Self Member}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     *
     * @param guild The {@link Guild Guild}, which should be used to get {@link SelfMember Self Member}
     */
    private SelfMember(@NotNull Guild guild) {
        this.guild = guild;

        if (guild == null) {
            logger.error("The Guild you specify equals null", new NullPointerException());
        }
    }

    /**
     * Constructs a <b>new</b> {@link SelfMember Self Member} instance. If you don't
     * initialize a {@link Guild Guild}, {@link SelfMember Self Member} always will be <b>null</b>.
     *
     * @param guild The {@link Guild Guild}, which should be used to get {@link SelfMember Self Member}
     * @return A <b>new</b> {@link SelfMember Self Member} instance
     */
    @NotNull
    public static SelfMember set(@Nullable Guild guild) {
        return new SelfMember(guild);
    }

    /**
     * The {@link Guild Guild} the Message was received in.
     *
     * @return The {@link Guild Guild} the Message was received in
     */
    @NotNull
    public Guild getGuild() {
        return guild;
    }

    /**
     * Checks if {@link SelfMember Self Member} was pinged in a specified message.
     *
     * @param message The {@link Message Message}, which should checked, if there is a {@link SelfMember Self Member} ping in it
     * @return <b>true -</b> If the {@link SelfMember Self Member} was pinged <br>
     * <b>false -</b> If the {@link SelfMember Self Member} was not pinged
     */
    public boolean isPinged(@NotNull Message message) {
        return message.getContentDisplay().startsWith("<@" + guild.getSelfMember().getId() + ">");
    }
}
