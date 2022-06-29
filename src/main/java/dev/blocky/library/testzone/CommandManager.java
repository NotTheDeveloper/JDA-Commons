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
package dev.blocky.library.testzone;

import dev.blocky.library.jda.interfaces.ICommand;
import dev.blocky.library.testzone.commands.HelloWorldCommand;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.ShutdownEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/**
 * This is a class, which manages default {@link net.dv8tion.jda.api.entities.Message message} commands.
 *
 * @author BlockyDotJar
 * @version v2.1.1
 * @since v1.0.0-alpha.3
 */
public class CommandManager extends ListenerAdapter
{
    private final Logger logger = JDALogger.getLog(CommandManager.class);
    private static ConcurrentHashMap<String, ICommand> commands;

    /**
     * Constructs a <b>new</b> {@link CommandManager Command Manager}.
     */
    public CommandManager()
    {
        commands = new ConcurrentHashMap<>();

        /*
         * Here you can import your commands
         */

        commands.put("hello-world", new HelloWorldCommand());
    }

    /**
     * Checks if {@link ICommand the command interface} equals null.
     *
     * @param command The string of the command
     * @param event   The {@link MessageReceivedEvent message received event}, which should used for the commands
     * @param args    The array of strings
     * @return
     * <b>true -</b> If {@link ICommand the command interface} does not equal to null
     * <br> <b>false -</b> If {@link ICommand the command interface} equals to null
     */
    public boolean onMessage(@Nullable String command, @NotNull MessageReceivedEvent event, @NotNull String[] args)
    {
        ICommand cmd = commands.get(command.toLowerCase());
        if (cmd != null)
        {
            cmd.onCommand(event, args);
        }
        return cmd != null;
    }

    @Override
    public void onReady(@NotNull ReadyEvent event)
    {
        logger.info("{} successfully connected to the discord network and finally logged in.",
                event.getJDA().getSelfUser().getAsTag());
    }

    @Override
    public void onShutdown(@NotNull ShutdownEvent event)
    {
        logger.info("{} successfully disconnected from the discord network and finally logged out.",
                event.getJDA().getSelfUser().getAsTag());
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event)
    {
        String message = event.getMessage().getContentDisplay();

        if (event.isFromType(ChannelType.TEXT))
        {
            if (message.startsWith("!"))
            {
                String[] args = message.substring(1).split(" ");
                String[] split =
                        event.getMessage().getContentRaw()
                        .replaceFirst("(?i)" + Pattern.quote("!"), "")
                        .split("\\s+");

                if (args.length > 0)
                {
                    if (!this.onMessage(args[0], event, split))
                    {
                        logger.info("Command " + Arrays.toString(args) + " was not found.");
                    }
                }
            }
        }
    }
}

