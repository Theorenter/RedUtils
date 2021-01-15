package org.concordiacraft.redutils.main;

import org.bukkit.plugin.java.JavaPlugin;
import org.concordiacraft.redutils.main.utils.RedLog;

public class RedUtils extends JavaPlugin implements RedPlugin {

    // Fields
    private static RedLog rLog;

    @Override
    public void onEnable() {
        // Creating a new log
        rLog = new RedLog(this);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean isDebug() {
        // TODO написать адекватное тело метода, которое извлекало бы значение из конфига.
        return true;
    }

    @Override
    public RedLog getRedLogger() {
        return rLog;
    }
    public static RedPlugin getPlugin() {
        return RedUtils.getPlugin(RedUtils.class);
    }

}
