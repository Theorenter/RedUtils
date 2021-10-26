package org.roterbund.redutils.files.localization;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.roterbund.redutils.files.RedConfiguration;
import org.roterbund.redutils.utils.RedLogger;
import org.roterbund.redutils.utils.managers.TextFormatManager;

import java.io.*;
import java.nio.file.Files;

/**
 * Localization config for the RedPlugins
 */
public class SingleLocalization extends RedConfiguration implements RedLocalization {

    /**
     * @param plugin The plugin that localization refers to
     * @param path The path to the localization file
     */
    public SingleLocalization(@NotNull final Plugin plugin, @NotNull final String path) {
        super(plugin, path);

        // What to do if a new localization was created through the configuration:
        if (this.customConfig == null) {
            String enUsLocPath = "settings" + "/" + "localization" + "/" + "en_us.yml";

            InputStream is = plugin.getResource(enUsLocPath);
            this.file = new File(plugin.getDataFolder(), path);

            try {
                if (is != null)
                    Files.copy(is, this.file.toPath());
            } catch (IOException e) {
                plugin.getLogger().severe(RedLogger.D_RED + "Cannot create \"" + path + "\" file!" + RedLogger.RESET);
            }

            this.customConfig = YamlConfiguration.loadConfiguration(file);

            plugin.getLogger().info("A custom language file was created based on the \"en_us\" localization");
        }

        plugin.getLogger().info(" — " + this.getRawString("language") +
                " (" + this.file.getName() + ") localization by " +
                this.getRawString("author") + " was enabled");
    }
    /**
     * @param key The path to the string
     * @return The raw requested string
     */
    @NotNull
    public String getRawString(@NotNull final String key) {
        String str = this.customConfig.getString(key);
        if (str != null)
            return str;
        else {
            plugin.getLogger().warning(RedLogger.D_YELLOW + "The line under key \"" + key + "\" was not found." + RedLogger.D_WHITE);
            return "The line under ID \"" + key + "\" was not found.";
        }
    }

    /**
     * @param key The path to the string
     * @param placeholders The content of placeholders
     * @return The raw requested string
     */
    @NotNull
    public String getRawString(@NotNull final String key, final String... placeholders) {
        return String.format(this.getRawString(key), (Object) placeholders);
    }

    /**
     * <b>NOTE: work only with client-oriented localization!</b>
     * <P>when called from SingleLocalization class, it will return just a localization string, without referring to the recipient's language
     * @param recipient The player to whom the string will be returned
     * @param key The path to the string
     * @return The raw requested string
     */
    public String getRawString(@NotNull final Player recipient, @NotNull final String key) {
        return getRawString(key);
    }

    /**
     * <b>NOTE: work only with client-oriented localization!</b>
     * <P>when called from SingleLocalization class, it will return just a localization string, without referring to the recipient's language
     * @param recipient The player to whom the string will be returned
     * @param key The path to the string
     * @return The raw requested string
     */
    public String getRawString(Player recipient, String key, String... placeholders) {
        return String.format(this.getRawString(key), (Object) placeholders);
    }

    /**
     * @param key The path to the string
     * @return The requested string
     */
    public String getString(String key) {
        return TextFormatManager.format(this.getRawString(key));
    }

    /**
     * @param key The path to the string
     * @param placeholders The content of placeholders
     * @return The requested string
     */
    public String getString(String key, String... placeholders) {
        return String.format(this.getString(key), (Object) placeholders);
    }

    /**
     * <b>NOTE: work only with client-oriented localization!</b>
     * <P>when called from SingleLocalization class, it will return just a localization string, without referring to the recipient's language
     * @param recipient The player to whom the string will be returned
     * @param key The path to the string
     * @return The requested string
     */
    public String getString(Player recipient, String key) {
        return getString(key);
    }

    /**
     * <b>NOTE: work only with client-oriented localization!</b>
     * <P>when called from SingleLocalization class, it will return just a localization string, without referring to the recipient's language
     * @param recipient The player to whom the string will be returned
     * @param key The path to the string
     * @param placeholders The content of placeholders
     * @return The requested string
     */
    public String getString(Player recipient, String key, String... placeholders) {
        return getString(key, placeholders);
    }
}
