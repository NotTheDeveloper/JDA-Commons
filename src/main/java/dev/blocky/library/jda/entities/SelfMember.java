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
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import javax.annotation.CheckReturnValue;
import java.util.List;
import java.util.Objects;

/**
 * Represents the self member (aka. the bot itself) of a specific {@link Guild guild}.
 *
 * @author BlockyDotJar
 * @version v1.1.3
 * @since v1.0.1
 */
public class SelfMember
{
    private static final Logger logger = JDALogger.getLog(SelfMember.class);
    private final Guild guild;

    /**
     * Constructs a <b>new</b> {@link SelfMember self member}.
     * <br>This is a private constructor, because it should not be accessed for other classes.
     *
     * @param guild The {@link Guild guild}, which should be used to get {@link SelfMember self member}
     */
    private SelfMember(@Nullable Guild guild)
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
     * Constructs a <b>new</b> {@link SelfMember self member} instance.
     * <br>If you don't  initialize a {@link Guild guild}, the {@link SelfMember self member} always will be <b>null</b>.
     *
     * @param guild The {@link Guild guild}, which should be used to get the {@link SelfMember self member}
     * @return A <b>new</b> {@link SelfMember self member} instance
     */
    @NotNull
    public static SelfMember set(@Nullable Guild guild)
    {
        return new SelfMember(guild);
    }

    /**
     * The {@link Guild guild}, the message was received in.
     *
     * @return The {@link Guild guild}, the message was received in
     */
    @NotNull
    public Guild getGuild()
    {
        return guild;
    }

    /**
     * Checks if the {@link Role role} with the id you specified, is found on the role board of the {@link SelfMember self member}.
     *
     * @param roleId The id of the {@link Role role}, which should be checked
     * @return The {@link Role role} with the id you specified
     */
    @Nullable
    @CheckReturnValue
    public Role findRoleById(long roleId)
    {
        List<Role> roles = guild.getSelfMember().getRoles();
        return roles.stream().filter(role -> role.getIdLong() == roleId).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Role role} with the id you specified, is found on the role board of the {@link SelfMember self member}.
     *
     * @param roleId The id of the {@link Role role}, which should be checked
     * @return The {@link Role role} with the id you specified
     */
    @Nullable
    @CheckReturnValue
    public Role findRoleById(@NotNull String roleId)
    {
        List<Role> roles = guild.getSelfMember().getRoles();
        return roles.stream().filter(role -> role.getId().equals(roleId)).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Role role} with the name you specified, is found on the role board of the {@link SelfMember self member}.
     *
     * @param roleName The name of the {@link Role role}, which should be checked
     * @return The {@link Role role} with the name you specified
     */
    @Nullable
    @CheckReturnValue
    public Role findRoleByName(@NotNull String roleName)
    {
        List<Role> roles = guild.getSelfMember().getRoles();
        return roles.stream().filter(role -> role.getName().equals(roleName)).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link SelfMember self member} has the {@link Role role} with the id you specified.
     *
     * @param roleId The id of the {@link Role role}, which should be checked
     * @return
     * <b>true</b> If the {@link SelfMember self member} has the {@link Role role}
     * <br><b>false</b> If the {@link SelfMember self member} has not the {@link Role role}
     */
    public boolean hasRoleWithId(long roleId)
    {
        return findRoleById(roleId) != null;
    }

    /**
     * Checks if the {@link SelfMember self member} has the {@link Role role} with the id you specified.
     *
     * @param roleId The id of the {@link Role role}, which should be checked
     * @return
     * <b>true</b> If the {@link SelfMember self member} has the {@link Role role}
     * <br><b>false</b> If the {@link SelfMember self member} has not the {@link Role role}
     */
    public boolean hasRoleWithId(@NotNull String roleId)
    {
        return findRoleById(roleId) != null;
    }

    /**
     * Checks if the {@link SelfMember self member} has the {@link Role role} with the name you specified.
     *
     * @param roleName The name of the {@link Role role}, which should be checked
     * @return
     * <b>true</b> If the {@link SelfMember self member} has the {@link Role role}
     * <br><b>false</b> If the {@link SelfMember self member} has not the {@link Role role}
     */
    public boolean hasRoleWithName(@NotNull String roleName)
    {
        return findRoleByName(roleName) != null;
    }

    /**
     * Checks if the {@link SelfMember self member} was pinged in a specified {@link Message message}.
     *
     * @param message The {@link Message message}, which should checked, if the {@link SelfMember self member} got pinged in the {@link Message message}
     * @return
     * <b>true</b> If the {@link SelfMember self member} got pinged in the {@link Message message}
     * <br><b>false</b> If the {@link SelfMember self member} got pinged in the {@link Message message}
     */
    public boolean isMentioned(@NotNull Message message)
    {
        return message.getMentions().isMentioned(guild.getSelfMember(), Message.MentionType.USER);
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
