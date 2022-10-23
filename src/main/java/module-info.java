/**
 * This is an extension of the Java Discord API from Austin Keener, which adds lots of utility methods and classes.
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
