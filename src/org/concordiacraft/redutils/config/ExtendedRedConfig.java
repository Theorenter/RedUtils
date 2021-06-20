package org.concordiacraft.redutils.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.concordiacraft.redutils.main.RedPlugin;

import java.io.File;
import java.io.IOException;

/**
 * @author Theorenter
 * Creating an abstract configuration for plugins of the RedProject family.
 */
public abstract class ExtendedRedConfig {

    private static RedPlugin plugin;

    // CustomConfig fields
    protected File customFile;
    protected FileConfiguration customConfig;

    // Name of .yml that we will work with
    protected String fullFileName;

    /**
     * Custom config's constructor.
     * @param plugin plugin for which the configuration file will be created.
     * @param fullFileName full name (including path) where will the file be located.
     */
     protected ExtendedRedConfig(RedPlugin plugin, String fullFileName) {

         ExtendedRedConfig.plugin = plugin;

        // File Creation
        this.fullFileName = fullFileName;

        customFile = new File(plugin.getDataFolder(),  fullFileName);
        if (!customFile.exists()) {
            plugin.log().warning(fullFileName + " was not found. Create new ones.");
            plugin.saveResource(fullFileName, false);
        }

        // File configuration
        customConfig = YamlConfiguration.loadConfiguration(customFile);
    }

    public void saveConfig() {
        try {
            this.customConfig.save(customFile);
            plugin.log().info(fullFileName + " has been saved successfully!");
        } catch (IOException e) {
            plugin.log().error("Could not save the " + fullFileName, e);
        }
    }

    public void reloadConfig() {
        customConfig = YamlConfiguration.loadConfiguration(customFile);
    }
}