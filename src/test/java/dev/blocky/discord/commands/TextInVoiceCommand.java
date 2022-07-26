/**
 * Copyright 2022 Dominic (aka. BlockyDotJar)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.blocky.discord.commands;

import dev.blocky.library.jda.entities.GuildVoiceChannel;
import dev.blocky.library.jda.interfaces.ICommand;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.requests.restaction.MessageAction;
import org.jetbrains.annotations.NotNull;

/**
 * This is a simple example for the <b>new</b> channel unions, which got added in JDA {@code v5.0.0-alpha.14}.
 * <br>This command also represents text in voice.
 *
 * @author BlockyDotJar
 * @version v1.0.1
 * @since v1.1.5
 */
public class TextInVoiceCommand implements ICommand
{
    @Override
    public void onCommand(@NotNull MessageReceivedEvent event, @NotNull String[] args)
    {
        MessageChannelUnion channel = event.getChannel();

        // Specialized handling on concrete types.
        if (channel.getType() == ChannelType.VOICE)
        {
            VoiceChannel vc = channel.asVoiceChannel(); // Easy type conversion, just like casting, but with clear type information.

            if (!event.getGuild().getSelfMember().getVoiceState().inAudioChannel())
            {
                vc.getGuild().getAudioManager().openAudioConnection(vc);
            }

            // Creates a new guild voice channel, by initializing a voice channel and a member.
            GuildVoiceChannel voiceChannel = GuildVoiceChannel.set(vc, event.getMember());
            // Creates a message action by simply sending a message.
            MessageAction action = channel.sendMessage("Hello World!");
            //Creates a timeouted message by handing over the message action above and setting a delay of 10 seconds.
            voiceChannel.sendTimeoutedMessage(action, 10L, null).queue();
        }
    }
}
