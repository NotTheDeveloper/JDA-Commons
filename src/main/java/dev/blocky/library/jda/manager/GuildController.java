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
package dev.blocky.library.jda.manager;

import dev.blocky.library.jda.annotations.Deadline;
import dev.blocky.library.jda.entities.SelfMember;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * This is a controller you can control guilds with.
 * <br>
 * The exact use is still unknown.
 *
 * @author BlockyDotJar
 * @version v1.0.0-alpha.2
 * @since v1.0.0
 */
@Deadline(version = "v1.5.0")
public class GuildController {
    private static final Logger logger = LoggerFactory.getLogger(GuildController.class);
    private Guild guild;

    /**
     * Constructs a <b>new</b> {@link GuildController Guild Controller}.
     * <br>
     * This is a private constructor, because it should not be accessed for other classes.
     */
    private GuildController() {
    }

    /**
     * Constructs a <b>new</b> {@link GuildController Guild Controller}.
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     *
     * @param guild The {@link Guild Guild}, which should be used to get {@link GuildController Guild Controller}
     */
    private GuildController(@Nullable Guild guild) {
        this.guild = guild;

        if(JDALogger.SLF4J_ENABLED) {
            if (!guild.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MESSAGES) && !guild.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MEMBERS)) {
                logger.warn("The GUILD_MESSAGES and GUILD_MEMBERS Intents are not enabled, which means, that some stuff could not work.");
                return;
            }

            if (!guild.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MESSAGES)) {
                logger.warn("The GUILD_MESSAGES Intent is not enabled, which means, that some stuff could not work.");
                return;
            }

            if (!guild.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MEMBERS)) {
                logger.warn("The GUILD_MEMBERS Intent is not enabled, which means, that some stuff could not work.");
                return;
            }

            if (guild == null) {
                logger.error("The Guild you specify equals null.", new NullPointerException());
            }
        }
    }

    /**
     * Constructs a <b>new</b> {@link GuildController Guild Controller} instance. If you don't
     * initialize a {@link Guild Guild}, {@link GuildController Guild Controller} always will be <b>null</b>.
     *
     * @param guild The {@link Guild Guild}, which should be used to get {@link GuildController Guild Controller}
     * @return A <b>new</b> {@link GuildController Guild Controller} instance
     */
    @NotNull
    public static GuildController set(@Nullable Guild guild) {
        return new GuildController(guild);
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
     * Gets a <b>new</b> {@link SelfMember Self Member}, by initializing a specific {@link Guild Guild}.
     *
     * @return A <b>new</b> {@link SelfMember Self Member} instance
     */
    @NotNull
    public SelfMember getSelfMember() {
        return SelfMember.set(guild);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SelfMember that = (SelfMember) o;

        return guild.equals(that.getGuild());
    }

    @Override
    public int hashCode() {
        return Objects.hash(guild);
    }

    @Override
    public String toString() {
        return "GuildController{" +
                "guild=" + guild +
                '}';
    }
}
