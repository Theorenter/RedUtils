package org.roterbund.redutils.data.repository;

import org.roterbund.redutils.data.object.UniversalPlayer;

import java.util.HashMap;
import java.util.UUID;

public class UniversalPlayerRepository {
    private UniversalPlayerRepository instance;

    public UniversalPlayerRepository getInstance() {
        return instance;
    }
    private boolean debug,isOnline;
    public UniversalPlayerRepository(boolean debug,boolean isOnline){
        // if (debug); // Что нибудь будем прокидывать в логгер
        // if (isOnline); // New BukkitRunnable everyTime
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
