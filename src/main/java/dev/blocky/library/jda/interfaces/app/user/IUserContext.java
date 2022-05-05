/**
 * Copyright 2022 Dominic (aka. BlockyDotJar)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * <a href="http://www.apache.org/licenses/LICENSE-2.0">http://www.apache.org/licenses/LICENSE-2.0</a>
 * </p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.blocky.library.jda.interfaces.app.user;

import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * A simple User Context Menu Interface, which you can use to easily program some user context menus.
 *
 * @author BlockyDotJar
 * @version v1.0.0
 * @since v1.0.0
 */
public interface IUserContext {

    /**
     * An interface, which you can use to easily program some user context menus.
     *
     * <br>
     * <p>
     * This contains a
     * <a href="https://github.com/BlockyDotJar/JDA-Commons/blob/main/src/main/java/dev/blocky/library/testzone/ApplicationCommandManager.java">Application Command Manager</a>.
     *
     * @param event Indicates that a message context command was used
     */
    void onUserContext(@NotNull UserContextInteractionEvent event);
}
