package org.roterbund.redutils.gui;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.roterbund.redutils.main.RedUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * The manager responsible for the user interface system
 */
@SuppressWarnings("unused")
public final class GUIManager {

    final RedUtils redUtils;

    /**
     * @param redUtils The RedUtils plugin
     */
    public GUIManager(@NotNull final RedUtils redUtils) {
        this.redUtils = redUtils;
    }

    private final Map<Player, PlayerGUIUtility> playerGUIUtilityMap = new HashMap<>();

    /**
     * @param owner The owner of the user interface (who opened the menu)
     * @return The playerGUIUtility
     */
    public PlayerGUIUtility getPlayerGUIUtility(final Player owner) {
        PlayerGUIUtility playerGUIUtility;

        if (playerGUIUtilityMap.containsKey(owner)) {
            return playerGUIUtilityMap.get(owner);
        } else {
            playerGUIUtility = new PlayerGUIUtility(owner);
            playerGUIUtilityMap.put(owner, playerGUIUtility);

            return playerGUIUtility;
        }
    }
}
