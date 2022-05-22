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

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

/**
 * Represents a Guild-specific {@link net.dv8tion.jda.api.entities.User User}.
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0-alpha.1
 */
public class GuildMember {
    private static final Logger logger = LoggerFactory.getLogger(GuildMember.class);
    private Member member;

    /**
     * Constructs a <b>new</b> {@link GuildMember Guild Member}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     */
    private GuildMember() {
    }

    /**
     * Constructs a <b>new</b> {@link GuildMember Guild Member}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     *
     * @param member The {@link Member Member}, which should be used to get {@link GuildMember Guild Member}
     */
    private GuildMember(@NotNull Member member) {
        this.member = member;

        if (JDALogger.SLF4J_ENABLED) {
            if (!member.getJDA().getGatewayIntents().contains(GatewayIntent.GUILD_MEMBERS)) {
                logger.warn("The GUILD_MEMBERS Intent is not enabled, which means, that some stuff could not work.");
                return;
            }

            if (member == null) {
                logger.error("The Member you specify equals null.", new NullPointerException());
            }
        }
    }

    /**
     * Constructs a <b>new</b> {@link GuildMember Guild Member} instance. If you don't
     * initialize a {@link Member Member}, {@link GuildMember Guild Member} always will be <b>null</b>.
     *
     * @param member The {@link Member Member}, which should be used to get {@link GuildMember Guild Member}
     * @return A <b>new</b> {@link GuildMember Guild Member} instance
     */
    @NotNull
    public static GuildMember set(@Nullable Member member) {
        return new GuildMember(member);
    }

    /**
     * The Author of the {@link net.dv8tion.jda.api.entities.Message Message} received as {@link Member Member} object.
     *
     * @return The Author of the {@link net.dv8tion.jda.api.entities.Message Message} as null-able Member object.
     */
    @Nullable
    public Member getMember() {
        return member;
    }

    /**
     * Checks if the {@link Member Member} has the {@link Role Role} with the ID you specified.
     *
     * @param roleId The ID of the {@link Role Role}, which should be checked
     * @return <b>null</b> If the {@link Member Member} has not the {@link Role Role}
     */
    @Nullable
    public Role findRoleById(long roleId) {
        List<Role> roles = member.getRoles();
        return roles.stream().filter(role -> role.getIdLong() == roleId).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Member Member} has the {@link Role Role} with the ID you specified.
     *
     * @param roleId The ID of the {@link Role Role}, which should be checked
     * @return <b>null</b> If the {@link Member Member} has not the {@link Role Role}
     */
    @Nullable
    public Role findRoleById(@NotNull String roleId) {
        List<Role> roles = member.getRoles();
        return roles.stream().filter(role -> role.getId().equals(roleId)).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Member Member} has the {@link Role Role} with the ID you specified.
     *
     * @param roleName The ID of the {@link Role Role}, which should be checked
     * @return <b>null</b> If the {@link Member Member} has not the {@link Role Role}
     */
    @Nullable
    public Role findRoleByName(@NotNull String roleName) {
        List<Role> roles = member.getRoles();
        return roles.stream().filter(role -> role.getName().equals(roleName)).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link Member Member} has the {@link Role Role} with the ID you specified.
     *
     * @param roleId The ID of the {@link Role Role}, which should be checked
     * @return <b>true</b> If the {@link Member Member} has the {@link Role Role} <br>
     * <b>false</b> If the {@link Member Member} has not the {@link Role Role}
     */
    public boolean hasRoleWithId(long roleId) {
        return findRoleById(roleId) != null;
    }

    /**
     * Checks if the {@link Member Member} has the {@link Role Role} with the ID you specified.
     *
     * @param roleId The ID of the {@link Role Role}, which should be checked
     * @return <b>true</b> If the {@link Member Member} has the {@link Role Role} <br>
     * <b>false</b> If the {@link Member Member} has not the {@link Role Role}
     */
    public boolean hasRoleWithId(@NotNull String roleId) {
        return findRoleById(roleId) != null;
    }

    /**
     * Checks if the {@link Member Member} has the {@link Role Role} with the name you specified.
     *
     * @param roleName The name of the {@link Role Role}, which should be checked
     * @return <b>true</b> If the {@link Member Member} has the {@link Role Role} <br>
     * <b>false</b> If the {@link Member Member} has not the {@link Role Role}
     */
    public boolean hasRoleWithName(@NotNull String roleName) {
        return findRoleByName(roleName) != null;
    }

    /**
     * Checks if a {@link Member Member} is a Server Booster.
     *
     * @return <b>true</b> If the {@link Member Member} is boosting the server <br>
     * <b>false</b> If the {@link Member Member} is not boosting the server
     */
    public boolean isServerBooster() {
        return member.getTimeBoosted() != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GuildMember that = (GuildMember) o;

        return Objects.equals(member, that.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member);
    }

    @Override
    public String toString() {
        return "GuildMember{" +
                "member=" + member +
                '}';
    }
}
