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
package dev.blocky.library.testzone.commands.app.user;

import dev.blocky.library.jda.interfaces.app.user.IUserContext;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import org.jetbrains.annotations.NotNull;

import java.time.OffsetDateTime;

/**
 * This is a simple avatar user context command.
 *
 * @author BlockyDotJar
 * @version v2.1.0
 * @since v1.0.0
 */
public class AvatarUserContextCommand implements IUserContext
{
    @Override
    public void onUserContext(@NotNull UserContextInteractionEvent event)
    {
        EmbedBuilder builder = new EmbedBuilder();

        builder.setTimestamp(OffsetDateTime.now()); // Sets the timestamp to the time, when the message has been sent.
        builder.setColor(0x7289dd);

        builder.setTitle("Avatar of " + event.getTargetMember().getUser().getAsTag());
        builder.setDescription("[Here you can download the avatar](" + event.getTargetMember().getUser().getAvatarUrl() + ")"); // Gets the avatar url of the user, the context menu was used on.
        builder.setImage(event.getTargetMember().getUser().getAvatarUrl());
        event.replyEmbeds(builder.build()).queue(); // Sends the embed.
    }
}
