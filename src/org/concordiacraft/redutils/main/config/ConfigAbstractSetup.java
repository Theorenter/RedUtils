package org.concordiacraft.redutils.main.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.concordiacraft.redutils.main.RedPlugin;

import java.io.File;
import java.io.IOException;

/**
 * @author Theorenter
 * Creating an abstract configuration for plugins of the RedProject family.
 */
public abstract class ConfigAbstractSetup {

    private final RedPlugin plugin;

    // CustomConfig fields
    protected static File customFile;
    protected static FileConfiguration customConfig;

    // Name of .yml that we will work with
    protected static String fullFileName;

    /**
     * Custom config's constructor.
     * @param plugin plugin for which the configuration file will be created.
     * @param fullFileName full name (including path) where will the file be located.
     */
     protected ConfigAbstractSetup(RedPlugin plugin, String fullFileName) {

        this.plugin = plugin;

        // File Creation
        ConfigAbstractSetup.fullFileName = fullFileName;

        customFile = new File(plugin.getDataFolder(),  fullFileName);
        if (!customFile.exists()) {
            plugin.getRedLogger().warning(fullFileName + " was not found. Create new ones.");
            customFile.getParentFile().mkdirs();
            plugin.saveResource(fullFileName, false);
        }

        // File configuration
        customConfig = YamlConfiguration.loadConfiguration(customFile);
    }

    public void saveCustomConfig() {
        try {
            customConfig.save(customFile);
            plugin.getRedLogger().info(fullFileName + " has been saved successfully!");
        } catch (IOException e) {
            plugin.getRedLogger().error("Could not save the " + fullFileName, e);
        }
    }

    public void reloadCustomConfig() {
        customConfig = YamlConfiguration.loadConfiguration(customFile);
    }

    // Config Getter
    public FileConfiguration getCustomConfig() {
        return customConfig;
    }
}