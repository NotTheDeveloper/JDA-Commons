package dev.blocky.library.jda.interfaces.app.slash;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import org.json.JSONObject;

public interface ICommands {

    String performCommand(Member m, Guild guild, JSONObject json);
}
