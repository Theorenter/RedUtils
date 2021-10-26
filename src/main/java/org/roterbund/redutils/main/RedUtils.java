package org.roterbund.redutils.main;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.roterbund.redutils.files.RedConfiguration;
import org.roterbund.redutils.files.localization.RedLocalization;
import org.roterbund.redutils.utils.RedLogger;
import org.roterbund.redutils.utils.managers.NotificationManager;


/**
 * RedUtils main class
 */
public final class RedUtils extends JavaPlugin implements RedPlugin {

    private static RedUtils instance;
    private RedUtilsAPI api;

    /**
     * Instructions when enabling the plugin
     */
    @Override
    public void onEnable() {
        instance = this;

        // Api
        api = new RedUtilsAPI();
        getLogger().info("The RedUtilsAPI was loaded successfully");

        getLogger().info(getDescription().getName() + " v" + getDescription().getVersion() + " was enabled successfully");
    }

    @Override
    public void onDisable() {
    }

    /**
     * <b>NOTE:</b> It should not be used anywhere in the RedUtils plugin<p>
     * Used for getting the API by other plugins
     *
     * @return The instance of the RedUtils plugin
     */
    @SuppressWarnings("unused")
    @NotNull
    public static RedUtils instance() {
        return instance;
    }

    /**
     * @return The RedUtils API
     */
    @SuppressWarnings("unused")
    @NotNull
    public RedUtilsAPI API() {
        return api;
    }

    @Override
    public RedLogger getRLogger() {
        return null;
    }

    @Override
    public RedConfiguration getRConfig() {
        return null;
    }

    @Override
    public boolean isDebug() {
        return false;
    }

    @Override
    public RedLocalization getLocalization() {
        return null;
    }

    @Override
    public NotificationManager getNotificationManager() { return null; }
}
