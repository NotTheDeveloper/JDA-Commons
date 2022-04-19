package dev.blocky.library.testzone.commands.app.slash;

import dev.blocky.library.jda.interfaces.app.slash.ISlashCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.OffsetDateTime;

/**
 * This is a simple ping slash command
 *
 * @author BlockyDotJar
 * @version v2.0.0
 * @since v1.0.0
 */
public class PingSlashCommand implements ISlashCommand {

    @Override
    public void onSlashCommand(@NotNull SlashCommandInteractionEvent event) {
        long restPing = event.getJDA().getRestPing().complete();
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTimestamp(OffsetDateTime.now());
        builder.setFooter(event.getMember().getUser().getAsTag());
        builder.setTitle("Ping? Pong! 🏓");
        builder.addField("Discord API Gateway Ping:",
                "```yml\n" + event.getJDA().getGatewayPing() + "ms ```\n", true);
        builder.addField("Discord API REST Ping:", "```yml\n" + restPing + "ms ```", true);

        if (event.getJDA().getGatewayPing() >= 200) {
            builder.setColor(Color.RED);
        } else if (event.getJDA().getGatewayPing() >= 100 && event.getJDA().getGatewayPing() <= 199) {
            builder.setColor(Color.YELLOW);
        } else if (event.getJDA().getGatewayPing() <= 99) {
            builder.setColor(Color.GREEN);
        }

        event.replyEmbeds(builder.build()).queue();
    }
}
