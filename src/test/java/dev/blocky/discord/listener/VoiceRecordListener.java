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
package dev.blocky.discord.listener;

import dev.blocky.discord.DiscordBotExample;
import dev.blocky.library.jda.entities.voice.VoiceRecorder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.io.File;

/**
 * A listener that records voice chat.
 *
 * @author BlockyDotJar
 * @version v1.0.0
 * @since v1.1.6
 */
public class VoiceRecordListener extends ListenerAdapter
{
    private final Logger logger = JDALogger.getLog(VoiceRecorder.class);

    @Override
    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event)
    {
        Guild guild = event.getGuild();
        Member member = event.getMember();

        // Checks if the bot has the permission to join the voice channel.
        if (!guild.getSelfMember().hasPermission(Permission.VOICE_CONNECT))
        {
            logger.error("Cannot connect to voice channel, missing permission 'VOICE_CONNECT'.", new IllegalStateException());
        }

        if (!member.getUser().isBot() && guild.getSelfMember().hasPermission(Permission.VOICE_CONNECT))
        {
            // Joins a voice channel.
            guild.getAudioManager().openAudioConnection(member.getVoiceState().getChannel());
        }
    }

    @Override
    public void onGuildVoiceLeave(@NotNull GuildVoiceLeaveEvent event)
    {
        Guild guild = event.getGuild();
        Member member = event.getMember();

        // Checks if the bot can receive audio from the user.
        if (guild.getSelfMember().getVoiceState().isGuildDeafened())
        {
            logger.warn("Deafened, cannot record.");
        }

        if (!member.getUser().isBot() && !guild.getSelfMember().getVoiceState().isGuildDeafened())
        {
            // Leaves from the voice channel.
            guild.getAudioManager().closeAudioConnection();

            DiscordBotExample.getRecorder()
                    // Only use this if you want set the value to true, because it is false by default.
                    .shouldStack(true)
                    // Sets the volume, how loud the audio should be. (this cannot be negative)
                    // If this is not set it will set to 1.0d.
                    .setVolume(1.5)
                    // Sets the receiving handler, which is required to receive the audio.
                    .setReceivingHandler(guild)
                    // Starts recording the audio.
                    // PLEASE NOTE: Only use this feature to record conversations with the consent of all users in the channel.
                    // Recording a conversation against other users' consent is illegal, and you are violating the Discord Terms of Service.
                    .createRecording(new File("test.mp3"));
        }
    }
}
