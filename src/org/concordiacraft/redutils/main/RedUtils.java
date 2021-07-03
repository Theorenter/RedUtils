package org.concordiacraft.redutils.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.concordiacraft.redutils.config.ConfigDefault;
import org.concordiacraft.redutils.config.ConfigLocalization;
import org.concordiacraft.redutils.data.object.UniversalPlayer;
import org.concordiacraft.redutils.listeners.PlayerJoinListener;
import org.concordiacraft.redutils.util.RedLog;

import java.io.File;

public class RedUtils extends JavaPlugin implements RedPlugin {

    // Fields
    private static boolean debug = false;
    private static RedLog rLog;


    // Config fields
    private static ConfigDefault config;
    private static ConfigLocalization localization;

    @Override
    public void onEnable() {

        // Creating a new log
        rLog = new RedLog(this);
        rLog.showPluginTitle();

        // Configuration load
        config = new ConfigDefault(this, "settings" + File.separator + "config.yml");
        localization = new ConfigLocalization(this, "settings" + File.separator + "localization" + File.separator + "default.yml");
        rLog.info("The plugin configuration was loaded");
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener<UniversalPlayer>(), this);


        // Commands
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean isDebug() {
        return debug;
    }

    @Override
    public void setDebug(boolean debugStatus) {
        debug = debugStatus;
    }

    public RedLog log() {
        return rLog;
    }

    public static RedPlugin getPlugin() {
        return RedUtils.getPlugin(RedUtils.class);
    }

    public static ConfigDefault getConfigDefault() {
        return config;
    }

    public static ConfigLocalization getLocalization() {
        return localization;
    }
}
