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
package dev.blocky.discord;

import dev.blocky.discord.commands.HelloWorldCommand;
import dev.blocky.discord.commands.TextInVoiceCommand;
import dev.blocky.library.jda.interfaces.ICommand;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.events.session.ShutdownEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.internal.utils.Checks;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/**
 * This is a class, which manages default {@link Message} commands.
 *
 * @author BlockyDotJar
 * @version v2.1.5
 * @since v1.0.0-alpha.3
 */
public class CommandManager extends ListenerAdapter
{
    private static final Logger logger = JDALogger.getLog(CommandManager.class);
    private static ConcurrentHashMap<String, ICommand> commands;

    /**
     * Constructs a <b>new</b> {@link CommandManager}.
     */
    CommandManager()
    {
        commands = new ConcurrentHashMap<>();

        /*
         * Here you can import your commands
         */

        commands.put("hello-world", new HelloWorldCommand());

        commands.put("text-in-voice", new TextInVoiceCommand());
    }

    /**
     * Checks if {@link ICommand} equals <b>null</b>.
     *
     * @param command The string of the command.
     * @param event A {@link MessageReceivedEvent}, which should used for the commands.
     * @param args An array of strings.
     *
     * @return <b>true</b> - If {@link ICommand} is not equal to <b>null</b>.
     *         <br><b>false</b> - If {@link ICommand} equals <b>null</b>.
     */
    boolean onMessage(@NotNull String command, @NotNull MessageReceivedEvent event, @NotNull String[] args)
    {
        Checks.noWhitespace(command, "command");

        final ICommand cmd = commands.get(command.toLowerCase());

        if (cmd != null)
        {
            cmd.onCommand(event, args);
        }
        return cmd != null;
    }

    @Override
    public void onReady(@NotNull ReadyEvent event)
    {
        // If the bot is ready to use, this message will be logged in the console.
        logger.info("{} successfully connected to the Discord network and finally logged in.",
                event.getJDA().getSelfUser().getAsTag());
    }

    @Override
    public void onShutdown(@NotNull ShutdownEvent event)
    {
        // If the bot is getting a shutdown, this message will be logged in the console.
        logger.info("{} successfully disconnected from the Discord network and finally logged out.",
                event.getJDA().getSelfUser().getAsTag());
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event)
    {
        final String message = event.getMessage().getContentDisplay();

        if (!message.startsWith("!"))
        {
            return;
        }

        if (!event.isFromType(ChannelType.TEXT) && !event.isFromType(ChannelType.VOICE))
        {
            return;
        }

        // This will split the message into an array of strings, using " " as a delimiter.
        // The first element of the array will be the command.
        // The rest of the elements will be the arguments.
        final String[] args = message.substring(1).split(" ");
        // This will get the first element of the array.
        // This will be the command.
        final String[] split = event.getMessage().getContentRaw()
                .replaceFirst("(?i)" + Pattern.quote("!"), "")
                .split("\\s+");

        // If the command is not found or ICommand equals *null*, this message will be logged in the console.
        if (args.length > 0 && !onMessage(args[0], event, split))
        {
            logger.info("Command " + Arrays.toString(args) + " was not found.");
        }
    }
}

