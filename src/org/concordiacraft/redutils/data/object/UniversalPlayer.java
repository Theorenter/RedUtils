package org.concordiacraft.redutils.data.object;

import org.bukkit.entity.Player;
import org.concordiacraft.redutils.data.RedData;
import org.concordiacraft.redutils.requests.Request;
import org.concordiacraft.redutils.requests.Requestable;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * UniversalPlayer or UPlayer is a universal player
 * class that uses the RedPlugin family of plugins.
 *
 * <p>To access UniversalPlayer when working with an
 * object of the Player class, we simply find it
 * through a special static method. Therefore, the
 * UniversalPlayer collection is stored in the RedData
 * HashMap to find UniversalPlayer by default Spigot Player.</p>
 */

public abstract class UniversalPlayer implements Requestable {

    private final Player player;

    private ArrayList<Request> requests = new ArrayList<>();

    public UniversalPlayer(Player player) {
        this.player = player;
        RedData.addUPlayer(this);
    }

    /**
     * The implementation of the UniversalPlayer
     * class must store as a player field.
     *
     * @return default Spigot Player.
     */
    public Player getP() {
        return this.player;
    }

    public boolean hasRequest() {
        return !requests.isEmpty();
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public void clearRequests() {
        this.requests.clear();
    }
}
