package org.roterbund.redutils.main;

import org.bukkit.plugin.Plugin;
import org.roterbund.redutils.files.RedConfiguration;
import org.roterbund.redutils.files.localization.RedLocalization;
import org.roterbund.redutils.utils.RedLogger;
import org.roterbund.redutils.utils.managers.NotificationManager;

@SuppressWarnings("unused")
public interface RedPlugin extends Plugin {

    /**
     * @return True if the plugin is enabled in debug mode and false if not
     */
    boolean isDebug();

    /**
     * @return A localization of the plugin
     */
    RedLocalization getLocalization();

    /**
     * @return A RedConfiguration
     */
    RedConfiguration getRConfig();

    /**
     * @return A plugin logger
     */
    RedLogger getRLogger();

    /**
     * @return The notification manager of the plugin
     */
    NotificationManager getNotificationManager();

}
