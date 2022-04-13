package dev.blocky.library.jda.entities.impl;

import javax.annotation.Nonnull;
import java.util.HashMap;

/**
 * Implements all the Data from other implementations.
 *
 * @author BlockyDotJar
 * @version v1.0.0
 * @since v1.0.0-alpha.3
 */
public class DataImpl {
    private final static HashMap<Long, Long> map = new HashMap<>();

    /**
     * /**
     * The {@link HashMap Hash Map} Instance from the
     * {@link dev.blocky.library.jda.entities.impl.DataImpl Data Implementation} class
     *
     * @return {@link DataImpl#map}
     */
    @Nonnull
    public static HashMap<Long, Long> getMap() {
        return map;
    }
}
