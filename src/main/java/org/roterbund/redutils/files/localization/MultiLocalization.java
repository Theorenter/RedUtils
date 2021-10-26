package org.roterbund.redutils.files.localization;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.roterbund.redutils.utils.RedLogger;
import org.roterbund.redutils.utils.managers.TextFormatManager;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.CodeSource;
import java.util.HashMap;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * A class for supporting multiple localizations of the plugin
 */

public class MultiLocalization implements RedLocalization {

    private final HashMap<String, SingleLocalization> localizations;
    private final String defaultLocalization;

    /**
     * @param plugin The plugin that localizations refers to
     * @param path The path to the directory of the localizations
     */
    public MultiLocalization(@NotNull final Plugin plugin, @NotNull final String path, @NotNull final String defaultLocalization) {
        this.defaultLocalization = defaultLocalization;
        this.localizations = new HashMap<>();

        // Get all localization files from jar
        CodeSource src = plugin.getClass().getProtectionDomain().getCodeSource();
        URL jar = src.getLocation();
        try {
            ZipInputStream zip = new ZipInputStream(jar.openStream());
            while (true) {
                ZipEntry e = zip.getNextEntry();
                if (e == null)
                    break;
                String fileFullName = e.getName();
                if ((fileFullName.startsWith(path)) && fileFullName.endsWith(".yml")) {
                    if (!new File(plugin.getDataFolder() + File.separator + e.getName()).exists())
                        plugin.saveResource(e.getName(), false);
                }
            }

            // Install localizations from plugin dataFolder
            File localizationsDir = new File(plugin.getDataFolder(), path);
            for (File f : Objects.requireNonNull(localizationsDir.listFiles())) {
                String locPath = path + File.separator + f.getName();

                SingleLocalization redLoc = new SingleLocalization(plugin, locPath);
                String locName = redLoc.getFile().getName().substring(0, redLoc.getFile().getName().lastIndexOf("."));

                this.localizations.put(locName, redLoc);
            }

            // Check if default localization is custom
            if (!this.localizations.containsKey(defaultLocalization)) {
                new SingleLocalization(plugin, path + defaultLocalization + ".yml");
            }
        } catch (IOException e) {
            plugin.getLogger().severe(RedLogger.D_RED + "The client-oriented localization could not be initialized!" + RedLogger.RESET);
            plugin.getLogger().severe(e.toString());
            this.localizations.put("en_us", new SingleLocalization(plugin, path + "en_us.yml"));
        }
    }

    /**
     * @param key The path to the string
     * @return The raw requested string
     */
    public String getRawString(@NotNull String key) {
        return this.localizations.get(defaultLocalization).getRawString(key);
    }

    /**
     * @param key The path to the string
     * @param placeholders The content of placeholders
     * @return The raw requested string
     */
    public String getRawString(@NotNull String key, String... placeholders) {
        return String.format(getRawString(key), (Object) placeholders);
    }

    /**
     * @param recipient The player to whom the string will be returned
     * @param key The path to the string
     * @return The raw requested string
     */
    public String getRawString(@NotNull Player recipient, @NotNull String key) {
        if (localizations.containsKey(recipient.getLocale()))
            return localizations.get(recipient.getLocale()).getRawString(key);
        else return localizations.get(defaultLocalization).getRawString(key);
    }

    /**
     * @param recipient The player to whom the string will be returned
     * @param key The path to the string
     * @param placeholders The content of placeholders
     * @return The raw requested string
     */
    public String getRawString(@NotNull Player recipient, @NotNull String key, String... placeholders) {
        return String.format(getRawString(recipient, key), (Object) placeholders);
    }

    /**
     * @param key The path to the string
     * @return The requested string
     */
    public String getString(@NotNull String key) {
        return (localizations.get(defaultLocalization).getString(key));
    }

    /**
     * @param key The path to the string
     * @param placeholders The content of placeholders
     * @return The requested string
     */
    public String getString(@NotNull String key, String... placeholders) {
        return String.format(localizations.get(defaultLocalization).getString(key), (Object) placeholders);
    }

    /**
     * @param recipient The player to whom the string will be returned
     * @param key The path to the string
     * @return The requested string
     */
    public String getString(@NotNull Player recipient, @NotNull String key) {
        return TextFormatManager.format(getRawString(recipient, key));
    }

    /**
     * @param recipient The player to whom the string will be returned
     * @param key The path to the string
     * @param placeholders The content of placeholders
     * @return The requested string
     */
    public String getString(@NotNull Player recipient, @NotNull String key, String... placeholders) {
        return TextFormatManager.format(getRawString(recipient, key, placeholders));
    }
}
