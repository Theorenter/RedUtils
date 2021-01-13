package org.concordiacraft.redutils.main.utils;

import org.bukkit.plugin.Plugin;
import org.fusesource.jansi.Ansi;

import java.util.logging.Level;

/**
 * @author Theorenter
 * Universal logger for plugins of the RedProject family.
 */
public class RedLog {
    private final Plugin plugin;

    public RedLog(Plugin plugin) {
        this.plugin = plugin;
    }

    public void showPluginTitle() {
        plugin.getLogger().log(Level.INFO, "");
        plugin.getLogger().log(Level.INFO, "===[ " + ASCIIRed + plugin.getName() + ASCIIWhite + " ]===");
        plugin.getLogger().log(Level.INFO, "");
    }

    /**
     * Information message output.
     * @param message the contents of the message.
     */
    public void info(String message) { plugin.getLogger().log(Level.INFO, message); }

    /**
     * Warning message output.
     * @param message the contents of the message.
     */
    public void warning(String message) { plugin.getLogger().log(Level.WARNING, ASCIIYellow + message + ASCIIReset); }

    /**
     * Error message output.
     * @param message the contents of the message.
     */
    public void error(String message) { plugin.getLogger().log(Level.SEVERE, ASCIIRed + message); }

    /**
     * Warning message output.
     * @param message the contents of the message.
     * @param e error exception
     */
    public void warning(String message, Exception e) { plugin.getLogger().log(Level.WARNING, ASCIIYellow + message, e); }

    /**
     * Error message output.
     * @param message the contents of the message.
     * @param e error exception
     */
    public void error(String message, Exception e) { plugin.getLogger().log(Level.SEVERE, ASCIIRed + message, e); }

    public void debug(Boolean isDebugMode, String message) {
        if (isDebugMode)
            plugin.getLogger().log(Level.INFO,"["+ ASCIICyan +"DEBUG"+ ASCIIWhite +"] " + message);
    }
    public void debug(Boolean isDebugMode, String message, Exception e) {
        if (isDebugMode)
            plugin.getLogger().log(Level.INFO,"["+ ASCIICyan +"DEBUG"+ ASCIIWhite +"] " + message, e);
    }

    // ASCII colors
    private final static String ASCIIBlack = Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLACK).bold().toString();
    private final static String ASCIIBlue = Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLUE).boldOff().toString();
    private final static String ASCIICyan = Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.CYAN).boldOff().toString();
    private final static String ASCIIGreen = Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.GREEN).boldOff().toString();
    private final static String ASCIIMagenta = Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.MAGENTA).boldOff().toString();
    private final static String ASCIIRed = Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.RED).boldOff().toString();
    private final static String ASCIIWhite = Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.WHITE).boldOff().toString();
    private final static String ASCIIYellow = Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.YELLOW).boldOff().toString();
    private final static String ASCIIReset = Ansi.ansi().a(Ansi.Attribute.RESET).toString();

    public static String getASCIIBlack() { return ASCIIBlack; }
    public static String getASCIIBlue() { return ASCIIBlue; }
    public static String getASCIICyan() { return ASCIICyan; }
    public static String getASCIIGreen() { return ASCIIGreen; }
    public static String getASCIIMagenta() { return ASCIIMagenta; }
    public static String getASCIIRed() { return ASCIIRed; }
    public static String getASCIIWhite() { return ASCIIWhite; }
    public static String getASCIIYellow() { return ASCIIYellow; }
    public static String getASCIIReset() { return ASCIIReset; }
}
