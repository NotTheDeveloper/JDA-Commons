package dev.blocky.library.jda.entities;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

/**
 * Represents a Guild-specific {@link net.dv8tion.jda.api.entities.User User}.
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0-alpha.1
 */
public class GuildMember {
    private final Member member;

    /**
     * Constructs a <b>new</b> {@link GuildMember Guild Member} instance. If you don't
     * initialize a {@link net.dv8tion.jda.api.entities.Member Member},
     * {@link GuildMember Guild Member} always will be <b>null</b>.
     *
     * @param member The {@link net.dv8tion.jda.api.entities.Member Member}, which
     *               should be initialized.
     */
    public GuildMember(@Nonnull Member member) {
        this.member = member;
    }

    /**
     * Checks if the {@link net.dv8tion.jda.api.entities.Member Member} has the
     * {@link net.dv8tion.jda.api.entities.Role role} with the ID you specified.
     *
     * @param roleId The ID of the {@link net.dv8tion.jda.api.entities.Role role},
     *               which should be checked.
     * @return <b>null</b> If the {@link net.dv8tion.jda.api.entities.Member Member}
     * has not the {@link net.dv8tion.jda.api.entities.Role role}.
     */
    @Nullable
    public Role findRoleById(long roleId) {
        List<Role> roles = member.getRoles();
        return roles.stream().filter(role -> role.getIdLong() == roleId).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link net.dv8tion.jda.api.entities.Member Member} has the
     * {@link net.dv8tion.jda.api.entities.Role role} with the ID you specified.
     *
     * @param roleId The ID of the {@link net.dv8tion.jda.api.entities.Role role},
     *               which should be checked.
     * @return <b>null</b> If the {@link net.dv8tion.jda.api.entities.Member Member}
     * has not the {@link net.dv8tion.jda.api.entities.Role role}.
     */
    @Nullable
    public Role findRoleById(@Nonnull String roleId) {
        List<Role> roles = member.getRoles();
        return roles.stream().filter(role -> role.getId().equals(roleId)).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link net.dv8tion.jda.api.entities.Member Member} has the
     * {@link net.dv8tion.jda.api.entities.Role role} with the ID you specified.
     *
     * @param roleName The ID of the {@link net.dv8tion.jda.api.entities.Role role},
     *                 which should be checked.
     * @return <b>null</b> If the {@link net.dv8tion.jda.api.entities.Member Member}
     * has not the {@link net.dv8tion.jda.api.entities.Role role}.
     */
    @Nullable
    public Role findRoleByName(@Nonnull String roleName) {
        List<Role> roles = member.getRoles();
        return roles.stream().filter(role -> role.getName().equals(roleName)).findFirst().orElse(null);
    }

    /**
     * Checks if the {@link net.dv8tion.jda.api.entities.Member Member} has the
     * {@link net.dv8tion.jda.api.entities.Role role} with the ID you specified.
     *
     * @param roleId The ID of the {@link net.dv8tion.jda.api.entities.Role role},
     *               which should be checked.
     * @return <b>true</b> If the {@link net.dv8tion.jda.api.entities.Member Member}
     * has the {@link net.dv8tion.jda.api.entities.Role role}. <br>
     * <b>false</b> If the {@link net.dv8tion.jda.api.entities.Member
     * Member} has not the {@link net.dv8tion.jda.api.entities.Role role}.
     */
    public boolean hasRoleWithId(long roleId) {
        return findRoleById(roleId) != null;
    }

    /**
     * Checks if the {@link net.dv8tion.jda.api.entities.Member Member} has the
     * {@link net.dv8tion.jda.api.entities.Role role} with the ID you specified.
     *
     * @param roleId The ID of the {@link net.dv8tion.jda.api.entities.Role role},
     *               which should be checked.
     * @return <b>true</b> If the {@link net.dv8tion.jda.api.entities.Member Member}
     * has the {@link net.dv8tion.jda.api.entities.Role role}. <br>
     * <b>false</b> If the {@link net.dv8tion.jda.api.entities.Member
     * Member} has not the {@link net.dv8tion.jda.api.entities.Role role}.
     */
    public boolean hasRoleWithId(@Nonnull String roleId) {
        return findRoleById(roleId) != null;
    }

    /**
     * Checks if the {@link net.dv8tion.jda.api.entities.Member Member} has the
     * {@link net.dv8tion.jda.api.entities.Role role} with the name you specified.
     *
     * @param roleName The name of the {@link net.dv8tion.jda.api.entities.Role
     *                 role}, which should be checked.
     * @return <b>true</b> If the {@link net.dv8tion.jda.api.entities.Member Member}
     * has the {@link net.dv8tion.jda.api.entities.Role role}. <br>
     * <b>false</b> If the {@link net.dv8tion.jda.api.entities.Member
     * Member} has not the {@link net.dv8tion.jda.api.entities.Role role}.
     */
    public boolean hasRoleWithName(@Nonnull String roleName) {
        return findRoleByName(roleName) != null;
    }

    /**
     * Checks if a {@link net.dv8tion.jda.api.entities.Member Member} is a Server
     * Booster.
     *
     * @return <b>true</b> If the {@link net.dv8tion.jda.api.entities.Member Member}
     * is boosting the server. <br>
     * <b>false</b> If the {@link net.dv8tion.jda.api.entities.Member
     * Member} is not boosting the server.
     */
    public boolean isServerBooster() {
        return member.getTimeBoosted() != null;
    }
}
