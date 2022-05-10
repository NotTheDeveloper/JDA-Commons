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

import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents the {@link net.dv8tion.jda.api.entities.Member member} instance for the target
 * {@link net.dv8tion.jda.api.entities.User User}.
 *
 * @author BlockyDotJar
 * @version v1.0.0
 * @since v1.0.0-alpha.4
 */
public class GuildTargetMember {
    private UserContextInteractionEvent userEvent;
    private MessageContextInteractionEvent messageEvent;

    /**
     * Constructs a new {@link GuildTargetMember Guild Target Member}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     */
    private GuildTargetMember() {
    }

    /**
     * Constructs a new {@link GuildTargetMember Guild Target Member}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     *
     * @param userEvent The {@link UserContextInteractionEvent User Context Interaction Event}, which should be
     *                  used to get {@link GuildTargetMember Guild Target Member}
     */
    private GuildTargetMember(@NotNull UserContextInteractionEvent userEvent) {
        this.userEvent = userEvent;
    }


    /**
     * Constructs a new {@link GuildTargetMember Guild Target Member}
     * <br>
     * This is a private constructor, because it should not be accessed for other classes
     *
     * @param messageEvent The {@link MessageContextInteractionEvent  Message Context Interaction Event}, which should be
     *                     used to get {@link GuildTargetMember Guild Target Member}
     */
    private GuildTargetMember(@NotNull MessageContextInteractionEvent messageEvent) {
        this.messageEvent = messageEvent;
    }

    /**
     * Constructs a <b>new</b> {@link GuildTargetMember Guild Target Member} instance. If you don't
     * initialize a {@link UserContextInteractionEvent
     * User Context Interaction Event}, {@link GuildTargetMember Guild Target Member}
     * always will be <b>null</b>.
     *
     * @param userEvent The {@link UserContextInteractionEvent User Context Interaction Event}, which should be initialized
     * @return A <b>new</b> {@link GuildTargetMember Guild Target Member} instance
     */
    public static GuildTargetMember set(UserContextInteractionEvent userEvent) {
        return new GuildTargetMember(userEvent);
    }

    /**
     * Constructs a <b>new</b> {@link GuildTargetMember Guild Target Member} instance. If you don't
     * initialize a {@link MessageContextInteractionEvent
     * Message Context Interaction Event}, {@link GuildTargetMember Guild Target Member}
     * always will be <b>null</b>.
     *
     * @param messageEvent The {@link MessageContextInteractionEvent  Message Context Interaction Event}, which should be initialized
     * @return A <b>new</b> {@link GuildTargetMember Guild Target Member} instance
     */
    public static GuildTargetMember set(MessageContextInteractionEvent messageEvent) {
        return new GuildTargetMember(messageEvent);
    }

    /**
     * Indicates that a user context command was used.
     *
     * @return The {@link UserContextInteractionEvent User Context Interaction Event}
     */
    @Nullable
    public UserContextInteractionEvent getUserContext() {
        return userEvent;
    }

    /**
     * Indicates that a message context command was used.
     *
     * @return The {@link MessageContextInteractionEvent Message Context Interaction Event}
     */
    @Nullable
    public MessageContextInteractionEvent getMessageContext() {
        return messageEvent;
    }

    /**
     * Checks if a {@link UserContextInteractionEvent#getTargetMember() Target Member} is a Server Booster or not.
     *
     * @return <b>true</b> If the target member is boosting the server <br>
     * <b>false</b> If the target member is not boosting the server
     */
    public boolean isServerBooster() {
        return userEvent != null ? userEvent.getTargetMember().getTimeBoosted() != null :
                messageEvent.getTarget().getMember().getTimeBoosted() != null;
    }
}
