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
package dev.blocky.library.jda.impl;

import org.jetbrains.annotations.NotNull;
import java.util.HashMap;

/**
 * Implements some data.
 *
 * @author BlockyDotJar
 * @version v1.1.0
 * @since v1.0.0-alpha.3
 */
public class DataImpl
{
    private static final HashMap<Long, Long> map = new HashMap<>();

    /**
     * Constructs a <b>new</b> {@link DataImpl Data implementation}.
     * <br> This is a private constructor, because it should not be accessed for other classes.
     */
    private DataImpl()
    {
    }

    /**
     * The {@link DataImpl#map hash map} instance from the {@link DataImpl data implementation} class.
     *
     * @return {@link DataImpl#map DataImpl#map}
     */
    @NotNull
    public static HashMap<Long, Long> getHashMap()
    {
        return map;
    }
}
