package org.roterbund.redutils.utils.managers;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Manager for sender notifications
 */
public final class NotificationManager {

    private final Plugin plugin;

    /**
     * Creates notification manager for the plugin
     *
     * @param plugin The plugin to which the configuration refers
     */
    public NotificationManager(@NotNull final Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Sends a message and plays an error sound for the player
     *
     * @param player The recipient of the error notification
     * @param message The error message that will be displayed in the chat
     */
    public void sendPlayerError(@NotNull final Player player, @NotNull final String message) {
        player.sendRawMessage(message);
        player.playSound(player.getLocation(),
                Objects.requireNonNull(plugin.getConfig().getString("notifications.error-sound.name")),
                Float.parseFloat(Objects.requireNonNull(plugin.getConfig().getString("notifications.error-sound.pitch"))),
                Float.parseFloat(Objects.requireNonNull(plugin.getConfig().getString("notifications.error-sound.volume")))
        );
    }

    /**
     * Sends a base component and plays an error sound for the player
     *
     * @param player The recipient of the error notification
     * @param baseComponent The content of the notification that will be displayed in the chat
     */
    @SuppressWarnings("unused")
    public void sendPlayerError(@NotNull final Player player, @NotNull final BaseComponent baseComponent) {
        player.spigot().sendMessage(baseComponent);
        player.playSound(player.getLocation(),
                Objects.requireNonNull(plugin.getConfig().getString("notifications.error-sound.name")),
                Float.parseFloat(Objects.requireNonNull(plugin.getConfig().getString("notifications.error-sound.pitch"))),
                Float.parseFloat(Objects.requireNonNull(plugin.getConfig().getString("notifications.error-sound.volume")))
        );
    }
}
