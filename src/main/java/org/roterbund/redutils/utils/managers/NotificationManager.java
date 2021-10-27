package org.roterbund.redutils.utils.managers;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Manager for sender notifications
 */
@SuppressWarnings("unused")
public final class NotificationManager {

    private String errorSoundName = "block.note_block.didgeridoo";
    private float errorSoundPitch = 1.0f;
    private float errorSoundVolume = 1.0f;

    /**
     * Creates notification manager
     */
    public NotificationManager() {
    }

    /**
     * Sets which sound will be played to the user if he encounters an error
     *
     * @param name The sound name
     * @param pitch The sound pitch
     * @param volume The sound volume
     */
    public void setErrorSound(@NotNull final String name, final float pitch, final float volume) {
        errorSoundName = name;
        errorSoundPitch = pitch;
        errorSoundVolume = volume;
    }

    /**
     * Sends a message and plays an error sound for the player
     *
     * @param player The recipient of the error notification
     * @param message The error message that will be displayed in the chat
     */
    public void sendPlayerError(@NotNull final Player player, @NotNull final String message) {
        player.sendRawMessage(message);
        player.playSound(player.getLocation(), errorSoundName, errorSoundPitch, errorSoundVolume);
    }

    /**
     * Sends a base component and plays an error sound for the player
     *
     * @param player The recipient of the error notification
     * @param baseComponent The content of the notification that will be displayed in the chat
     */
    public void sendPlayerError(@NotNull final Player player, @NotNull final BaseComponent baseComponent) {
        player.spigot().sendMessage(baseComponent);
        player.playSound(player.getLocation(), errorSoundName, errorSoundPitch, errorSoundVolume);
    }
}
