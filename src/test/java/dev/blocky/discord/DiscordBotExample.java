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
package dev.blocky.discord;

import dev.blocky.discord.listener.VoiceRecordListener;
import dev.blocky.library.jda.entities.voice.VoiceRecorder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumSet;

/**
 * This is the main class of the Discord-Bot.
 *
 * @author BlockyDotJar
 * @version v2.1.3
 * @since v1.0.0-alpha.1
 */
public class DiscordBotExample
{
    private static final Logger logger = JDALogger.getLog(DiscordBotExample.class);
    private static final VoiceRecordListener recordListener = new VoiceRecordListener();
    private static final VoiceRecorder recorder = VoiceRecorder.newRecorder();
    private static final CommandManager cmdMan = new CommandManager();
    private static JDA jda;

    /**
     * This is the main method of the Discord-Bot.
     *
     * @param args An array of string arguments
     *
     * @throws LoginException If an login failure occurs
     */
    public static void main(@NotNull String[] args) throws LoginException
    {
        new DiscordBotExample();
    }

    /**
     * Constructs a <b>new</b> {@link DiscordBotExample Discord-Bot example}.
     *
     * @throws LoginException If an login failure occurs
     */
    public DiscordBotExample() throws LoginException
    {
        jda = JDABuilder
                .createDefault("BOT_TOKEN", // Replace BOT_TOKEN with the token of your bot.
                        EnumSet.of(
                                // All needed intents.
                                GatewayIntent.GUILD_MESSAGES,
                                GatewayIntent.GUILD_MEMBERS,
                                GatewayIntent.GUILD_VOICE_STATES,
                                GatewayIntent.MESSAGE_CONTENT
                        )
                )
                // This cache flag is needed for the text-in-voice command.
                .enableCache(CacheFlag.VOICE_STATE)
                .disableCache(
                        EnumSet.of(
                                // Disables all not needed cache flags.
                                CacheFlag.CLIENT_STATUS,
                                CacheFlag.ACTIVITY,
                                CacheFlag.EMOJI,
                                CacheFlag.STICKER
                        )
                )
                // Policy which decides whether a member (and respective user) should be kept in cache.
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                // Since v5.0.0-alpha.13 we now can use a ChunkingFilter *AND* MemberCachePolicy at the same time.
                .setChunkingFilter(ChunkingFilter.ALL)
                // Adds all provided listeners to the list of listeners that will be used to populate the JDA object.
                .addEventListeners(cmdMan, recordListener)
                // Sets the Activity to 'Playing with the voice recorder'
                .setActivity(Activity.playing("with the voice recorder"))
                // Sets the status of the bot to 'Do not disturb'
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .build();
        // Adds all provided listeners to the event listeners that will be used to handle events.
        jda.addEventListener(new ApplicationCommandManager());

        // Initializes the shutdown method.
        shutdown();
    }

    /**
     * Shutdowns the system and the {@link DiscordBotExample#jda JDA} instance after five seconds, when the exit
     * command was typed.
     */
    private static void shutdown()
    {
        new Thread(() ->
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try
            {
                String line = reader.readLine();
                while (line != null)
                {
                    if (line.equalsIgnoreCase("exit") && jda != null)
                    {
                        for (int i = 5; i > 0; i--)
                        {
                            if (i != 1)
                            {
                                logger.info("Bot stops in " + i + " seconds.");
                            }
                            else
                            {
                                logger.info("Bot stops in " + i + " second.");
                            }
                            Thread.sleep(1000);
                        }
                        // Sets the presence of the bot to OFFLINE.
                        jda.getPresence().setStatus(OnlineStatus.OFFLINE);
                        // Shuts this JDA instance down and closes all its connections.
                        jda.shutdown();
                        // Terminates the currently running Java virtual machine.
                        System.exit(0);
                    }
                }
            }
            catch (IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        ).start(); // Causes this thread to begin execution.
    }

    /**
     * The {@link DiscordBotExample#jda JDA} instance from the {@link DiscordBotExample Discord-Bot example} class.
     *
     * @return {@link DiscordBotExample#jda}
     */
    @NotNull
    public static JDA getJDA()
    {
        return jda;
    }

    /**
     * The {@link DiscordBotExample#recorder voice recorder} instance from the {@link DiscordBotExample Discord-Bot example} class.
     *
     * @return {@link DiscordBotExample#recorder}
     */
    @NotNull
    public static VoiceRecorder getRecorder()
    {
        return recorder;
    }
}
