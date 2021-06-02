package org.concordiacraft.redutils.utils;

import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;

public final class RedDataConverter {
    public static Map<?, ?> getMapFromSection(ConfigurationSection confSection) {
        Map<Object, Object> map = new HashMap<>();
        for (Object key : confSection.getKeys(false)) {
            map.put(key, confSection.get(key.toString()));
        }
        return map;
    }
}
