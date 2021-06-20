package org.concordiacraft.redutils.data;

import org.concordiacraft.redutils.data.object.UniversalPlayer;

import java.util.HashMap;
import java.util.UUID;

public abstract class RedData {

    private static HashMap<UUID, UniversalPlayer> universalPlayers = new HashMap<>();

    public static HashMap<UUID, UniversalPlayer> getUniversalPlayers() {
        return universalPlayers;
    }

    public static void addUPlayer(UniversalPlayer uPlayer) {
        universalPlayers.put(uPlayer.getP().getUniqueId(), uPlayer);
    }
}
