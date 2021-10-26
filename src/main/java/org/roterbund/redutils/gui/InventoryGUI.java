package org.roterbund.redutils.gui;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public abstract class InventoryGUI implements InventoryHolder {

    protected Inventory inventory;

    protected PlayerGUIUtility playerGUIUtility;

    public InventoryGUI(PlayerGUIUtility playerGUIUtility) {
        this.playerGUIUtility = playerGUIUtility;
    }

    public abstract String getGUIName();

    public abstract int getRows();

    public abstract void handleGUI(@NotNull final InventoryClickEvent e);

    public abstract void setGUIItems();

    public void show() {
        inventory = Bukkit.createInventory(this, getRows() * 9, getGUIName());

        this.setGUIItems();

        playerGUIUtility.getOwner().openInventory(inventory);
    }

    @Override @NotNull
    public Inventory getInventory() {
        return inventory;
    }
}
