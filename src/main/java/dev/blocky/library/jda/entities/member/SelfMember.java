/**
 * Copyright 2022 Dominic R. (aka. BlockyDotJar)
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
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Represents the {@link SelfMember} (aka. the bot itself) of a specific {@link Guild}.
 *
 * @param guild The {@link Guild}, which should be used to get the {@link SelfMember}.
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.1
 */
public record SelfMember(@NotNull Guild guild)
{

    /**
     * Checks if the {@link Role} with the id you specified, is found on the role board of the {@link SelfMember}.
     *
     * @param roleId The id of the {@link Role}, which should be checked.
     *
     * @return The {@link Role} with the id you specified.
     */
    @Nullable
    @CheckReturnValue
    public Role findRoleById(long roleId)
    {
        final List<Role> roles = guild.getSelfMember().getRoles();
        return roles.stream().filter(role -> role.getIdLong() == roleId).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Role} with the id you specified, is found on the role board of the {@link SelfMember}.
     *
     * @param roleId The id of the {@link Role}, which should be checked.
     *
     * @return The {@link Role} with the id you specified.
     */
    @Nullable
    @CheckReturnValue
    public Role findRoleById(@NotNull String roleId)
    {
        final List<Role> roles = guild.getSelfMember().getRoles();
        return roles.stream().filter(role -> role.getId().equals(roleId)).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Role} with the name you specified, is found on the role board of the {@link SelfMember}.
     *
     * @param roleName The name of the {@link Role}, which should be checked.
     *
     * @return The {@link Role} with the name you specified.
     */
    @Nullable
    @CheckReturnValue
    public Role findRoleByName(@NotNull String roleName)
    {
        final List<Role> roles = guild.getSelfMember().getRoles();
        return roles.stream().filter(role -> role.getName().equals(roleName)).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link SelfMember} has the {@link Role} with the id you specified.
     *
     * @param roleId The id of the {@link Role}, which should be checked.
     *
     * @return <b>true</b> - If the {@link SelfMember} has the {@link Role}.
     *         <br><b>false</b> - If the {@link SelfMember} has not the {@link Role}.
     */
    public boolean hasRoleWithId(long roleId)
    {
        return findRoleById(roleId) != null;
    }

    /**
     * Checks if the {@link SelfMember} has the {@link Role} with the id you specified.
     *
     * @param roleId The id of the {@link Role}, which should be checked.
     *
     * @return <b>true</b> - If the {@link SelfMember} has the {@link Role}.
     *         <br><b>false</b> - If the {@link SelfMember} has not the {@link Role}.
     */
    public boolean hasRoleWithId(@NotNull String roleId)
    {
        return findRoleById(roleId) != null;
    }

    /**
     * Checks if the {@link SelfMember} has the {@link Role} with the name you specified.
     *
     * @param roleName The name of the {@link Role}, which should be checked.
     *
     * @return <b>true</b> - If the {@link SelfMember} has the {@link Role}.
     *         <br><b>false</b> - If the {@link SelfMember} has not the {@link Role}.
     */
    public boolean hasRoleWithName(@NotNull String roleName)
    {
        return findRoleByName(roleName) != null;
    }

    /**
     * Checks if the {@link SelfMember} was pinged in a specified {@link Message}.
     *
     * @param message The {@link Message}, which should checked, if the {@link SelfMember} got pinged in the {@link Message}.
     *
     * @return <b>true</b> - If the {@link SelfMember} got pinged in the {@link Message}.
     *         <br><b>false</b> - If the {@link SelfMember} got pinged in the {@link Message}.
     */
    public boolean isMentioned(@NotNull Message message)
    {
        return message.getMentions().isMentioned(guild.getSelfMember(), Message.MentionType.USER);
    }
}
