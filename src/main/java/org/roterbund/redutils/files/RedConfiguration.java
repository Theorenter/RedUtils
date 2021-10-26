package org.roterbund.redutils.files;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.roterbund.redutils.utils.RedLogger;

import java.io.File;
import java.io.IOException;

/**
 * RedConfiguration is a class that includes
 * default methods for working with configuration classes
 */
@SuppressWarnings("unused")
public class RedConfiguration {

    // fields
    protected final Plugin plugin;

    protected File file;
    protected FileConfiguration customConfig;

    /**
     * Creates a configuration based on the file
     */
    public RedConfiguration(@NotNull final Plugin plugin, @NotNull final String path) {
        this.plugin = plugin;
        file = new File(plugin.getDataFolder(), path);
        if (!file.exists()) {
            try {
                plugin.saveResource(path, false);
            } catch (IllegalArgumentException e) {
                customConfig = null;
                plugin.getLogger().warning(RedLogger.D_YELLOW + "File on path \"" + path + "\" was not found!" + RedLogger.RESET);
                return;
            }
        }

        // File configuration
        customConfig = YamlConfiguration.loadConfiguration(file);
    }

    /**
     * Save the configuration
     */
    public void save() {
        try {
            customConfig.save(file);
        } catch (IOException e) {
            plugin.getLogger().severe("Could not save the " + file.getPath());
        }
    }

    /**
     * Reload the customConfig field of the configuration
     */
    public void reloadConfigurationContent() {
        customConfig = YamlConfiguration.loadConfiguration(file);
    }

    /**
     * @return The file of the Red Configuration
     */
    public File getFile() {
        return file;
    }

    /**
     * @return The file configuration from the class
     */
    public FileConfiguration getConfiguration() {
        return customConfig;
    }
}
