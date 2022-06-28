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
package dev.blocky.library.jda.interfaces.app.message;

import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * A simple message context menu interface, which you can use to easily program some message context menus.
 *
 * @author BlockyDotJar
 * @version v1.1.0
 * @since v1.0.0
 */
public interface IMessageContext
{
    /**
     *  A simple message context menu interface, which you can use to easily program some message context menus.
     * <br> This contains an {@link dev.blocky.library.testzone.ApplicationCommandManager application command manager}.
     *
     * @param event Indicates that a message context command was used
     */
    void onMessageContext(@NotNull MessageContextInteractionEvent event);
}
