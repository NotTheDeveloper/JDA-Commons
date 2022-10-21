/**
 * Copyright 2022 Dominic R. (aka. BlockyDotJar), Emil (aka. TheDesignCraftYT) and nurkaapii
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
module jdacommons {
    requires java.desktop;

    requires net.dv8tion.jda;
    requires org.slf4j;

    requires com.google.errorprone.annotations;
    requires org.jetbrains.annotations;

    exports dev.blocky.library.jda.annotations;

    exports dev.blocky.library.jda.entities.channel;
    exports dev.blocky.library.jda.entities.voice;
    exports dev.blocky.library.jda.entities.member;

    exports dev.blocky.library.jda.enums;

    exports dev.blocky.library.jda.interfaces;
    exports dev.blocky.library.jda.interfaces.app.message;
    exports dev.blocky.library.jda.interfaces.app.slash;
    exports dev.blocky.library.jda.interfaces.app.user;

    exports dev.blocky.library.jda.manager;
}
