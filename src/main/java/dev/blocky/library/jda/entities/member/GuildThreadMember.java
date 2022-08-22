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
package dev.blocky.library.jda.entities.member;

import com.google.errorprone.annotations.CheckReturnValue;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

/**
 * Represents a {@link Member}, who joined a {@link ThreadChannel}.
 *
 * @author BlockyDotJar
 * @version v1.1.4
 * @since v1.1.1
 */
public class GuildThreadMember
{
    private static final Logger logger = JDALogger.getLog(GuildThreadMember.class);
    private final ThreadMember member;

    private GuildThreadMember(@NotNull ThreadMember member)
    {
        this.member = member;

        EnumSet<GatewayIntent> intents = member.getJDA().getGatewayIntents();

        if (!intents.contains(GatewayIntent.GUILD_MESSAGES) && !intents.contains(GatewayIntent.GUILD_MEMBERS))
        {
            logger.warn("Both the 'GUILD_MESSAGES' and the 'GUILD_MEMBERS' intents are not enabled, which means, that some stuff could not work.");
        }

        if (!intents.contains(GatewayIntent.GUILD_MESSAGES))
        {
            logger.warn("The 'GUILD_MESSAGES' intent is not enabled, which means, that some stuff could not work.");
        }

        if (!intents.contains(GatewayIntent.GUILD_MEMBERS))
        {
            logger.warn("The 'GUILD_MEMBERS' intent is not enabled, which means, that some stuff could not work.");
        }
    }

    /**
     * Constructs a <b>new</b> {@link GuildThreadMember} instance.
     * <br>If you don't initialize a {@link ThreadMember}, the {@link GuildThreadMember} always will be <b>null</b>.
     *
     * @param member The {@link ThreadMember}, which should be used to get {@link GuildThreadMember}.
     *
     * @return A <b>new</b> {@link GuildThreadMember} instance.
     */
    @NotNull
    public static GuildThreadMember set(@NotNull ThreadMember member)
    {
        return new GuildThreadMember(member);
    }

    /**
     * The author of the {@link Message} received as {@link Member} object.
     *
     * @return The author of the {@link Message} as <b>non-null</b> {@link ThreadMember} object.
     */
    @NotNull
    public ThreadMember getMember()
    {
        return member;
    }

    /**
     * Checks if the {@link Role} with the id you specified, is found on the role board of the {@link ThreadMember}.
     *
     * @param roleId The id of the {@link Role}, which should be checked.
     *
     * @return The {@link Role} with the id you specified.
     */
    @Nullable
    @CheckReturnValue
    public Role findRoleById(long roleId)
    {
        List<Role> roles = member.getMember().getRoles();
        return roles.stream().filter(role -> role.getIdLong() == roleId).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Role} with the id you specified, is found on the role board of the {@link ThreadMember}.
     *
     * @param roleId The id of the {@link Role}, which should be checked.
     *
     * @return The {@link Role} with the id you specified.
     */
    @Nullable
    @CheckReturnValue
    public Role findRoleById(@NotNull String roleId)
    {
        List<Role> roles = member.getMember().getRoles();
        return roles.stream().filter(role -> role.getId().equals(roleId)).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Role} with the name you specified, is found on the role board of the {@link ThreadMember}.
     *
     * @param roleName The name of the {@link Role}, which should be checked.
     *
     * @return The {@link Role} with the name you specified.
     */
    @Nullable
    @CheckReturnValue
    public Role findRoleByName(@NotNull String roleName)
    {
        List<Role> roles = member.getMember().getRoles();
        return roles.stream().filter(role -> role.getName().equals(roleName)).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link ThreadMember} has the {@link Role} with the id you specified.
     *
     * @param roleId The id of the {@link Role}, which should be checked.
     *
     * @return <b>true</b> - If the {@link ThreadMember} has the {@link Role}.
     *         <br><b>false</b> - If the {@link ThreadMember} has not the {@link Role}.
     */
    public boolean hasRoleWithId(long roleId)
    {
        return findRoleById(roleId) != null;
    }

    /**
     * Checks if the {@link ThreadMember} has the {@link Role} with the id you specified.
     *
     * @param roleId The id of the {@link Role}, which should be checked.
     *
     * @return <b>true</b> - If the {@link ThreadMember} has the {@link Role}.
     *         <br><b>false</b> - If the {@link ThreadMember} has not the {@link Role}.
     */
    public boolean hasRoleWithId(@NotNull String roleId)
    {
        return findRoleById(roleId) != null;
    }

    /**
     * Checks if the {@link ThreadMember} has the {@link Role} with the name you specified.
     *
     * @param roleName The name of the {@link Role}, which should be checked.
     *
     * @return <b>true</b> - If the {@link ThreadMember} has the {@link Role}.
     *         <br><b>false</b> - If the {@link ThreadMember} has not the {@link Role}.
     */
    public boolean hasRoleWithName(@NotNull String roleName)
    {
        return findRoleByName(roleName) != null;
    }

    /**
     * Checks if the {@link ThreadMember} was pinged in a specified {@link Message}.
     *
     * @param message The {@link Message}, which should checked, if the {@link ThreadMember} got pinged in the {@link Message}.
     *
     * @return <b>true</b> - If the {@link ThreadMember} got pinged in the {@link Message}.
     *         <br><b>false</b> - If the {@link ThreadMember} got pinged in the {@link Message}.
     */
    public boolean isMentioned(@NotNull Message message)
    {
        return message.getMentions().isMentioned(member, Message.MentionType.USER);
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

        GuildThreadMember that = (GuildThreadMember) o;

        return Objects.equals(member, that.member);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(member);
    }

    @NotNull
    @Override
    public String toString()
    {
        return "GuildThreadMember{" +
                "member=" + member +
                '}';
    }
}
