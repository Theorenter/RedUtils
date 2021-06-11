package org.concordiacraft.redutils.config;

import org.concordiacraft.redutils.main.RedPlugin;
import org.concordiacraft.redutils.main.RedUtils;

/**
 * @author Theorenter
 * Configuration of the RedUtils plugin
 */
public final class ConfigDefault extends ExtendedRedConfig {

    // plugin
    private final boolean debug;

    // fields effects-sounds
    // error-sound
    private final String errorSoundName;
    private final int errorSoundPitch;
    private final int errorSoundVolume;

    public ConfigDefault(RedPlugin plugin, String fullFileName) {
        super(plugin, fullFileName);

        // main
        this.debug = customConfig.getBoolean("main.debug");
        RedUtils.getPlugin().setDebug(debug);

        // effects-sounds
        this.errorSoundName = customConfig.getString("effects-sounds.error-sound.name");
        this.errorSoundPitch = customConfig.getInt("effects-sounds.error-sound.pitch");
        this.errorSoundVolume = customConfig.getInt("effects-sounds.error-sound.volume");

        customConfig = null;
    }
    public boolean isDebug() { return debug; }

    public String getErrorSoundName() { return errorSoundName; }

    public int getErrorSoundPitch() { return errorSoundPitch; }

    public int getErrorSoundVolume() { return errorSoundVolume; }
}
