package org.store.microservice.config;

import java.util.Objects;

/**
 * Класс для хранения строк/ключей в РЕДИСе
 */
public class KeyHelper {

    private final static String defaultPrefix = "app";

    private static String prefix = null;

    public static void setPrefix(String keyPrefix) {
        prefix = keyPrefix;
    }

    public static String getKey(String key) {
        return getPrefix() + ":" + key;
    }

    public static String getPrefix() {
        return Objects.requireNonNullElse(prefix, defaultPrefix);
    }

}
