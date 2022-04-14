package dev.blocky.library.jda.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This is an Annotation which tells the developers that a method/class should
 * be removed in the future.
 *
 * @author BlockyDotJar
 * @version v1.0.0
 * @since v1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR})
public @interface ForRemoval {

    /**
     * @return The version in which the deprecated method/class should be removed.
     */
    String deadline();
}