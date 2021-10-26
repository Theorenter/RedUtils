package org.roterbund.redutils.files.localization;

import org.bukkit.entity.Player;

/**
 * Interface RedLocalization is responsible for the
 * implementation of localization in the plugins of the RedPlugin family
 */
@SuppressWarnings("unused")
public interface RedLocalization {

    /**
     * @param key The path to the string
     * @return The raw requested string
     */
    String getRawString(String key);

    /**
     * @param key The path to the string
     * @param placeholders The content of placeholders
     * @return The raw requested string
     */
    String getRawString(String key, String... placeholders);

    /**
     * @param recipient The player to whom the string will be returned
     * @param key The path to the string
     * @return The raw requested string
     */
    String getRawString(Player recipient, String key);

    /**
     * @param recipient The player to whom the string will be returned
     * @param key The path to the string
     * @param placeholders The content of placeholders
     * @return The raw requested string
     */
    String getRawString(Player recipient, String key, String... placeholders);

    /**
     * @param key The path to the string
     * @return The requested string
     */
    String getString(String key);

    /**
     * @param key The path to the string
     * @param placeholders The content of placeholders
     * @return The requested string
     */
    String getString(String key, String... placeholders);

    /**
     * @param recipient The player to whom the string will be returned
     * @param key The path to the string
     * @return The requested string
     */
    String getString(Player recipient, String key);

    /**
     * @param recipient The player to whom the string will be returned
     * @param key The path to the string
     * @param placeholders The content of placeholders
     * @return The requested string
     */
    String getString(Player recipient, String key, String... placeholders);
}
