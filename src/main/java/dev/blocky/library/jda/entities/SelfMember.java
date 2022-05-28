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
package dev.blocky.library.jda.entities;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Represents the self member (aka. the bot itself) of a specific {@link Guild guild}.
 *
 * @author BlockyDotJar
 * @version v1.1.0
 * @since v1.0.1
 */
public class SelfMember
{
    private static final Logger logger = LoggerFactory.getLogger(SelfMember.class);
    private Guild guild;

    /**
     * Constructs a <b>new</b> {@link SelfMember self member}.
     * <br> This is a private constructor, because it should not be accessed for other classes.
     */
    private SelfMember()
    {
    }

    /**
     * Constructs a <b>new</b> {@link SelfMember self member}.
     * <br> This is a private constructor, because it should not be accessed for other classes.
     *
     * @param guild The {@link Guild guild}, which should be used to get {@link SelfMember self member}
     */
    private SelfMember(@NotNull Guild guild)
    {
        this.guild = guild;

        if (JDALogger.SLF4J_ENABLED)
        {
            if (!guild.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MESSAGES) && !guild.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MEMBERS))
            {
                logger.warn("Both the GUILD_MESSAGES and the GUILD_MEMBERS intents are not enabled, which means, that some stuff could not work.");
                return;
            }

            if (!guild.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MESSAGES))
            {
                logger.warn("The GUILD_MESSAGES intent is not enabled, which means, that some stuff could not work.");
                return;
            }

            if (!guild.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MEMBERS))
            {
                logger.warn("The GUILD_MEMBERS intent is not enabled, which means, that some stuff could not work.");
                return;
            }

            if (guild == null)
            {
                logger.error("The guild you specify equals null.", new NullPointerException());
            }
        }
    }

    /**
     * Constructs a <b>new</b> {@link SelfMember self member} instance. If you don't
     * initialize a {@link Guild guild}, {@link SelfMember self member} always will be <b>null</b>.
     *
     * @param guild The {@link Guild guild}, which should be used to get {@link SelfMember self member}
     * @return A <b>new</b> {@link SelfMember self member} instance
     */
    @NotNull
    public static SelfMember set(@Nullable Guild guild)
    {
        return new SelfMember(guild);
    }

    /**
     * The {@link Guild guild} the Message was received in.
     *
     * @return The {@link Guild guild} the message was received in
     */
    @NotNull
    public Guild getGuild()
    {
        return guild;
    }

    /**
     * Checks if {@link SelfMember self member} was pinged in a specified message.
     *
     * @param message The {@link Message message}, which should checked, if there is a {@link SelfMember self member} ping in it
     * @return
     * <b>true -</b> If the {@link SelfMember self member} was pinged <br>
     * <b>false -</b> If the {@link SelfMember self member} was not pinged
     */
    public boolean isPinged(@NotNull Message message)
    {
        return message.getMentions().isMentioned(guild.getSelfMember(), Message.MentionType.USER);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        SelfMember that = (SelfMember) o;

        return guild.equals(that.getGuild());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(guild);
    }

    @Override
    public String toString()
    {
        return "SelfMember{" +
                "guild=" + guild +
                '}';
    }
}
