package dev.blocky.library.jda.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This is an Annotation which tells the developers that a
 * method/class/constructor/package is not documented yet.
 *
 * @author BlockyDotJar
 * @version v1.0.0
 * @since v1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PACKAGE, ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR})
public @interface Undocumented {
}
