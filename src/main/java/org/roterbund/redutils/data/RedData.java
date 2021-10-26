package org.roterbund.redutils.data;

import org.bukkit.configuration.file.YamlConfiguration;
import org.roterbund.redutils.data.object.UniversalPlayer;

import java.io.File;
import java.lang.reflect.Field;


public abstract class RedData {



    public static void addUPlayer(UniversalPlayer uPlayer) {

    }

    public boolean persist() {
        Field[] fields = this.getClass().getDeclaredFields(); // Gets all fields
        for (Field field : fields) {
            if (!field.getType().isAssignableFrom(RedDataType.class)) {
                continue;
            }
            YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(getFile());
            field.setAccessible(true);
            try {
                yamlFile.set(field.getName(),((RedDataType)field.get(this)).write());

            } catch ( IllegalAccessException e){          //just for sake of debugging
                e.printStackTrace();
            }
        }
        return true;
    }

    protected abstract File getFile();

    public boolean flush() {
        return true;
    }

    public void delete() {

    }

}
