package dev.blocky.library.testzone.commands;

import dev.blocky.library.jda.interfaces.ICommand;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import javax.annotation.Nonnull;

/**
 * This is a simple hello world command
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0-alpha.3
 */
public class HelloWorldCommand implements ICommand {

    @Override
    public void onCommand(@Nonnull MessageReceivedEvent event, @Nonnull String[] args) {
        event.getChannel().sendMessage("Hello World!").queue();
    }
}
