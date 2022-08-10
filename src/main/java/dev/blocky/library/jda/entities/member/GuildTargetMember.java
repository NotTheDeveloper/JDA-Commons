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

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import com.google.errorprone.annotations.CheckReturnValue;
import java.util.List;
import java.util.Objects;

/**
 * Represents the {@link Member} instance for the target {@link User}.
 *
 * @author BlockyDotJar
 * @version v1.1.4
 * @since v1.0.0-alpha.4
 */
public class GuildTargetMember
{
    private static final Logger logger = JDALogger.getLog(GuildTargetMember.class);
    private UserContextInteractionEvent userEvent;
    private MessageContextInteractionEvent messageEvent;

    private GuildTargetMember(@NotNull UserContextInteractionEvent userEvent)
    {
        this.userEvent = userEvent;

        if (!userEvent.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MEMBERS))
        {
            logger.warn("The GUILD_MEMBERS intent is not enabled, which means, that some stuff could not work.");
        }
    }

    private GuildTargetMember(@NotNull MessageContextInteractionEvent messageEvent)
    {
        this.messageEvent = messageEvent;

        if (!messageEvent.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MEMBERS))
        {
            logger.warn("The GUILD_MEMBERS Intent is not enabled, which means, that some stuff could not work.");
        }
    }

    /**
     * Constructs a <b>new</b> {@link GuildTargetMember} instance.
     * <br>If you don't initialize a {@link UserContextInteractionEvent}, the
     * {@link GuildTargetMember} always will be <b>null</b>.
     *
     * @param userEvent The {@link UserContextInteractionEvent}, which should be initialized.
     *
     * @return A <b>new</b> {@link GuildTargetMember} instance.
     */
    @NotNull
    public static GuildTargetMember set(@NotNull UserContextInteractionEvent userEvent)
    {
        return new GuildTargetMember(userEvent);
    }

    /**
     * Constructs a <b>new</b> {@link GuildTargetMember} instance.
     * <br>If you don't initialize a {@link MessageContextInteractionEvent}, the
     * {@link GuildTargetMember} always will be <b>null</b>.
     *
     * @param messageEvent The {@link MessageContextInteractionEvent}, which should be initialized.
     *
     * @return A <b>new</b> {@link GuildTargetMember} instance.
     */
    @NotNull
    public static GuildTargetMember set(@NotNull MessageContextInteractionEvent messageEvent)
    {
        return new GuildTargetMember(messageEvent);
    }

    /**
     * Indicates that a user context-command was used.
     *
     * @return The {@link UserContextInteractionEvent}.
     */
    @NotNull
    public UserContextInteractionEvent getUserContext()
    {
        return userEvent;
    }

    /**
     * Indicates that a message context-command was used.
     *
     * @return The {@link MessageContextInteractionEvent}.
     */
    @NotNull
    public MessageContextInteractionEvent getMessageContext()
    {
        return messageEvent;
    }

    /**
     * Checks if the {@link Role} with the id you specified, is found on the role board of the {@link Member}.
     *
     * @param roleId The id of the {@link Role}, which should be checked.
     *
     * @return The {@link Role} with the id you specified.
     */
    @Nullable
    @CheckReturnValue
    public Role findRoleById(long roleId)
    {
        List<Role> roles = userEvent != null ? userEvent.getTargetMember().getRoles() : messageEvent.getTarget().getMember().getRoles();
        return roles.stream().filter(role -> role.getIdLong() == roleId).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Role} with the id you specified, is found on the role board of the {@link Member}.
     *
     * @param roleId The id of the {@link Role}, which should be checked.
     *
     * @return The {@link Role} with the id you specified.
     */
    @Nullable
    @CheckReturnValue
    public Role findRoleById(@NotNull String roleId)
    {
        List<Role> roles = userEvent != null ? userEvent.getTargetMember().getRoles() : messageEvent.getTarget().getMember().getRoles();
        return roles.stream().filter(role -> role.getId().equals(roleId)).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Role} with the name you specified, is found on the role board of the {@link Member}.
     *
     * @param roleName The name of the {@link Role}, which should be checked.
     *
     * @return The {@link Role} with the name you specified.
     */
    @Nullable
    @CheckReturnValue
    public Role findRoleByName(@NotNull String roleName)
    {
        List<Role> roles = userEvent != null ? userEvent.getTargetMember().getRoles() : messageEvent.getTarget().getMember().getRoles();
        return roles.stream().filter(role -> role.getName().equals(roleName)).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Member} has the {@link Role} with the id you specified.
     *
     * @param roleId The id of the {@link Role}, which should be checked.
     *
     * @return <b>true</b> - If the {@link Member} has the {@link Role}.
     *         <br><b>false</b> - If the {@link Member} has not the {@link Role}.
     */
    public boolean hasRoleWithId(long roleId)
    {
        return findRoleById(roleId) != null;
    }

    /**
     * Checks if the {@link Member} has the {@link Role} with the id you specified.
     *
     * @param roleId The id of the {@link Role}, which should be checked.
     *
     * @return <b>true</b> - If the {@link Member} has the {@link Role}.
     *         <br><b>false</b> - If the {@link Member} has not the {@link Role}.
     */
    public boolean hasRoleWithId(@NotNull String roleId)
    {
        return findRoleById(roleId) != null;
    }

    /**
     * Checks if the {@link Member} has the {@link Role} with the name you specified.
     *
     * @param roleName The name of the {@link Role}, which should be checked.
     *
     * @return <b>true</b> - If the {@link Member} has the {@link Role}.
     *         <br><b>false</b> - If the {@link Member} has not the {@link Role}.
     */
    public boolean hasRoleWithName(@NotNull String roleName)
    {
        return findRoleByName(roleName) != null;
    }

    /**
     * Checks if the {@link Member} was pinged in a specified {@link Message}.
     *
     * @param message The {@link Message}, which should checked, if the {@link Member} got pinged in the {@link Message}.
     *
     * @return <b>true</b> - If the {@link Member} got pinged in the {@link Message}.
     *         <br><b>false</b> - If the {@link Member} got pinged in the {@link Message}.
     */
    public boolean isMentioned(@NotNull Message message)
    {
        return message.getMentions().isMentioned(userEvent != null ? userEvent.getTargetMember(): messageEvent.getTarget().getMember(), Message.MentionType.USER);
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

        GuildTargetMember that = (GuildTargetMember) o;

        return Objects.equals(userEvent, that.userEvent) && Objects.equals(messageEvent, that.messageEvent);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(userEvent, messageEvent);
    }

    @NotNull
    @Override
    public String toString()
    {
        return userEvent != null ?
                "GuildTargetMember{" +
                        "userEvent=" + userEvent +
                        '}' :
                "GuildTargetMember{" +
                        ", messageEvent=" + messageEvent +
                        '}';
    }
}
