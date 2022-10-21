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
package dev.blocky.library.jda.interfaces.app.slash;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * A simple slash-command interface, which you can use to easily program some slash-commands with auto-complete.
 *
 * @author BlockyDotJar
 * @version v1.0.3
 * @since v1.1.4
 */
public interface IAutoCompletable
{
    /**
     * A simple slash-command interface, which you can use to easily program some slash-commands with auto-complete.
     * <br>This contains an <a href="https://github.com/BlockyDotJar/JDA-Commons/blob/main/src/test/java/dev/blocky/discord/ApplicationCommandManager.java">ApplicationCommandManager</a>.
     *
     * @param event Indicates that a slash-command with auto-complete was used in a {@link MessageChannel}.
     */
    void onCommandAutoComplete(@NotNull CommandAutoCompleteInteractionEvent event);
}

