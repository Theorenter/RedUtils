package org.concordiacraft.redutils.main;

import org.bukkit.plugin.java.JavaPlugin;
import org.concordiacraft.redutils.main.utils.RedLog;

public class RedUtils extends JavaPlugin {

    // fields
    private static RedLog rLog;

    @Override
    public void onEnable() {
        // creating a new log object
        rLog = new RedLog(this);
    }

    @Override
    public void onDisable() {

    }
    public static RedUtils getPlugin() {
        return RedUtils.getPlugin(RedUtils.class);
    }
    public static RedLog getLog() { return rLog; }
}
