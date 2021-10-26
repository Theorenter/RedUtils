package org.roterbund.redutils.gui;

import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class PlayerGUIUtility {

    private Player owner;

    PlayerGUIUtility(final Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(final Player owner) {
        this.owner = owner;
    }
}
