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

/**
 * This is a controller you can control guilds with.
 * <br> The exact use is still unknown.
 *
 * @author BlockyDotJar
 * @version v1.0.0-alpha.4
 * @since v1.0.0
 */
@Deadline(version = "v1.5.0")
public class GuildController
{
    private final Logger logger = JDALogger.getLog(GuildController.class);
    private final Guild guild;

    /**
     * Constructs a <b>new</b> {@link GuildController guild controller}.
     * <br> This is a private constructor, because it should not be accessed for other classes.
     *
     * @param guild The {@link Guild guild}, which should be used to get {@link GuildController guild controller}
     */
    private GuildController(@Nullable Guild guild)
    {
        this.guild = guild;

        if (!guild.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MESSAGES) && !guild.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MEMBERS))
        {
            logger.warn("Both the GUILD_MESSAGES and the GUILD_MEMBERS intents are not enabled, which means, that some stuff could not work.");
        }

        if (!guild.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MESSAGES))
        {
            logger.warn("The GUILD_MESSAGES intent is not enabled, which means, that some stuff could not work.");
        }

        if (!guild.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MEMBERS))
        {
            logger.warn("The GUILD_MEMBERS intent is not enabled, which means, that some stuff could not work.");
        }
    }

    /**
     * Constructs a <b>new</b> {@link GuildController guild controller} instance. If you don't
     * initialize a {@link Guild guild}, the {@link GuildController guild controller} always will be <b>null</b>.
     *
     * @param guild The {@link Guild guild}, which should be used to get the {@link GuildController guild controller}
     * @return A <b>new</b> {@link GuildController guild controller} instance
     */
    @NotNull
    public static GuildController set(@Nullable Guild guild)
    {
        return new GuildController(guild);
    }

    /**
     * The {@link Guild guild} the message was received in.
     *
     * @return The {@link Guild guild}, the message was received in
     */
    @NotNull
    public Guild getGuild()
    {
        return guild;
    }

    /**
     * Gets a <b>new</b> {@link SelfMember self member}, by initializing a specific {@link Guild guild}.
     *
     * @return A <b>new</b> {@link SelfMember self member} instance
     */
    @NotNull
    public SelfMember getSelfMember()
    {
        return SelfMember.set(guild);
    }

    @Override
    public boolean equals(@Nullable Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        GuildController that = (GuildController) o;
        return guild.equals(that.guild);
    }

    @Override
    public String toString()
    {
        return "GuildController{" +
                "guild=" + guild +
                '}';
    }
}
