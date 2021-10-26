package org.roterbund.redutils.utils;

import org.jetbrains.annotations.NotNull;
import org.roterbund.redutils.main.RedPlugin;

import java.util.logging.Level;

/**
 * @author Theorenter
 * Universal logger for plugins of the RedProject family
 */
@SuppressWarnings("unused")
public final class RedLogger {
    private final RedPlugin plugin;

    public RedLogger(@NotNull final RedPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Information message output
     * @param message the contents of the message
     */
    public void info(String message) { plugin.getLogger().log(Level.INFO, message); }

    /**
     * Warning message output
     * @param message the contents of the message
     */
    public void warn(String message) { plugin.getLogger().log(Level.WARNING, D_YELLOW + message + RESET); }

    /**
     * Error message output
     * @param message the contents of the message
     */
    public void error(String message) { plugin.getLogger().log(Level.SEVERE, D_RED + message + RESET); }

    /**
     * Warning message output
     * @param message the contents of the message
     * @param e error exception
     */
    public void warn(String message, Throwable e) { plugin.getLogger().log(Level.WARNING, D_YELLOW + message + RESET, e); }

    public void warn(Throwable e) {
        plugin.getLogger().log(Level.WARNING, "", e);
    }

    /**
     * Error message output
     * @param message the contents of the message
     * @param e error exception
     */
    public void error(String message, Throwable e) { plugin.getLogger().log(Level.SEVERE, D_RED + message + RESET, e); }

    public void error(Throwable e) {
        plugin.getLogger().log(Level.SEVERE, "", e);
    }

    /**
     * Debug message output
     * @param message the contents of the message
     */
    public void debug(String message) {
        if (plugin.isDebug())
            plugin.getLogger().log(Level.INFO,"[" + B_CYAN + "DEBUG" + RESET + "] " + message);
    }
    /**
     * Debug message output
     * @param message the contents of the message
     * @param e error exception
     */
    public void debug(String message, Throwable e) {
        if (plugin.isDebug())
            plugin.getLogger().log(Level.INFO,"[" + B_CYAN + "DEBUG" + RESET + "] " + message, e);
    }

    /**
     * Output of a message that is stylized as a debug, but does not perform verification at the same time
     * @param message the contents of the message
     */
    public void debugStyled(String message) {
        plugin.getLogger().log(Level.INFO,"[" + B_CYAN + "DEBUG" + RESET + "] " + message);
    }
    /**
     * Output of a message that is stylized as a debug, but does not perform verification at the same time
     * @param message the contents of the message
     * @param e error exception
     */
    public void debugStyled(String message, Throwable e) {
        plugin.getLogger().log(Level.INFO,"[" + B_CYAN + "DEBUG" + RESET + "] " + message, e);
    }

    // ASCII colors
    public final static String D_BLACK = "\u001B[30m";
    public final static String D_RED = "\u001B[31m";
    public final static String D_GREEN = "\u001B[32m";
    public final static String D_YELLOW = "\u001B[33m";
    public final static String D_BLUE = "\u001B[35m";
    public final static String D_MAGENTA = "\u001B[0;35m";
    public final static String D_CYAN = "\u001B[36m";
    public final static String D_WHITE = "\u001B[37m";
    public final static String B_BLACK = "\u001B[1;30m";
    public final static String B_RED = "\u001B[1;31m";
    public final static String B_GREEN = "\u001B[1;32m";
    public final static String B_YELLOW = "\u001B[1;33m";
    public final static String B_BLUE = "\u001B[1;34m";
    public final static String B_MAGENTA = "\u001B[1;35m";
    public final static String B_CYAN = "\u001B[1;36m";
    public final static String B_WHITE = "\u001B[1;37m";
    public final static String RESET = "\u001B[0m";
}
