package org.roterbund.redutils.utils.managers;

import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Theorenter
 * This class is responsible for formatting in-game strings
 */

public final class TextFormatManager {

    private static final Pattern hexColor = Pattern.compile("<#[a-fA-F0-9]{6}>");
    private static final Map<String, String> formatMap = new HashMap<>() {{
        put("<reset>", "§r");
        put("<bold>", "§l");
        put("<italic>", "§o");
        put("<underline>", "§n");
        put("<strike>", "§m");
        put("<magic>", "§k");
    }};

    /**
     * Gets a string and returns it in the processed form
     *
     * @param str The string to be processed
     * @return Processed string
     */
    public static String format(@NotNull String str) {
        Matcher matcher = hexColor.matcher(str);

        // Hex color find
        while (matcher.find()) {
            String fullColor = str.substring(matcher.start(), matcher.end());
            String color = str.substring(matcher.start() + 1, matcher.end() - 1);
            str = str.replace(fullColor, ChatColor.of(color).toString());
            matcher = hexColor.matcher(str);
        }
        // Other format find
        for (String formatObject : formatMap.keySet()) {
            while(str.contains(formatObject))
                str = str.replace(formatObject, formatMap.get(formatObject));
        } return str;
    }
}