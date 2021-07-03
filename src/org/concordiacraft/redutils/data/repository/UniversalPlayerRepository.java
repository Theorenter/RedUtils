package org.concordiacraft.redutils.data.repository;

import org.concordiacraft.redutils.data.RedData;
import org.concordiacraft.redutils.data.object.UniversalPlayer;
import org.concordiacraft.redutils.main.RedUtils;

import java.util.HashMap;
import java.util.UUID;

public class UniversalPlayerRepository {
    private UniversalPlayerRepository instance;

    public UniversalPlayerRepository getInstance() {
        return instance;
    }
    private boolean debug,isOnline;
    public UniversalPlayerRepository(boolean debug,boolean isOnline){
        if (debug); // Че нибудь будем прокидывать в логгер
        if (isOnline); // New BukkitRunnable everyTime
    }
    private static HashMap<UUID, UniversalPlayer> universalPlayers = new HashMap<>();


    /*
                        UniversalPlayer get(Player)
                        UniversalPlayer get(UUID)
                        UniversalPlayer add(Player)
                        UniversalPlayer update(UniversalPlayer)
                        ArrayList<UniversalPlayer> getAll()
     */
    //public static HashMap<UUID, UniversalPlayer> getUniversalPlayers() {
    //    return universalPlayers;
    //}
}
