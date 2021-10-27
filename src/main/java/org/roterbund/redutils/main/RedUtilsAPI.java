package org.roterbund.redutils.main;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.roterbund.redutils.commands.CommandManager;
import org.roterbund.redutils.files.RedConfiguration;
import org.roterbund.redutils.files.localization.MultiLocalization;
import org.roterbund.redutils.files.localization.RedLocalization;
import org.roterbund.redutils.files.localization.SingleLocalization;
import org.roterbund.redutils.utils.RedLogger;
import org.roterbund.redutils.utils.managers.NotificationManager;

/**
 * A class through which interaction between other plugins and RedUtils
 */
@SuppressWarnings("unused")
public final class RedUtilsAPI {

    public RedUtilsAPI() {
    }

    /**
     * Creates localization for the plugin
     *
     * @param plugin The plugin for which localization is being created
     * @param path The full path to the file (with the file name and extension), which is the localization
     * @return The localization
     */
    public RedLocalization createLocalization(@NotNull final Plugin plugin, @NotNull final String path) {
        return new SingleLocalization(plugin, path);
    }

    /**
     * Creates a client-oriented localization for the plugin
     *
     * @param plugin The plugin for which localization is being created
     * @param path The full path to the localization files
     * @param defaultLocalization The language code of the standard localization
     * @return The localization
     */
    public RedLocalization createLocalizations(@NotNull final Plugin plugin, @NotNull final String path, @NotNull final String defaultLocalization) {
        return new MultiLocalization(plugin, path, defaultLocalization);
    }

    /**
     * Creates a configuration from a plugin's JAR
     *
     * @param plugin The plugin for configuration localization is being created
     * @param path The path to the configuration file
     * @return The configuration
     */
    public RedConfiguration createRedConfiguration(@NotNull final Plugin plugin, @NotNull String path) {
        return new RedConfiguration(plugin, path);
    }

    /**
     * Creates a RedLogger for the plugin
     *
     * @param plugin The RedProject plugin for which RedLogger is being created
     * @param debug Boolean variable responsible for displaying debug information by the logger
     * @return The RedLogger
     */
    public RedLogger createRedLogger(@NotNull final RedPlugin plugin, boolean debug) {
        return new RedLogger(plugin, debug);
    }

    /**
     * Creates a command management system
     *
     * @param plugin The RedProject plugin for which command manager is being created
     * @return The command manager
     */
    public CommandManager createCommandManager(@NotNull final RedPlugin plugin) {
        return new CommandManager(plugin);
    }

    /**
     * Creates a notification management system
     **/
    public NotificationManager createNotificationManager() {
        return new NotificationManager();
    }
}
