package org.concordiacraft.redutils.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.concordiacraft.redutils.data.RedData;
import org.concordiacraft.redutils.data.object.UniversalPlayer;

public class PlayerJoinListener<E> implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
      //  E universalPlayer = RedData.getUniversalPlayers().add(e.getPlayer());
    }
}
