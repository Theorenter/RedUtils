package org.concordiacraft.redutils.main;

import org.bukkit.plugin.Plugin;
import org.concordiacraft.redutils.util.RedLog;

/**
 * @author Theorenter
 * Universal interface for plugins of the redproject family.
 */
public interface RedPlugin extends Plugin {
    /**
     * Display the debug status of the plugin.
     * @return status of whether the plugin is in debug mode.
     */
    boolean isDebug();

    /**
     * Sets whether the plugin is in debug mode or not
     */
    void setDebug(boolean debugStatus);

    /**
     * Universal logger for RedProject plugins.
     * @return RedLogger.
     */
    RedLog log();
}
