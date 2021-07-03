package org.concordiacraft.redutils.data.type;

import org.concordiacraft.redutils.data.RedDataType;

public class RedString implements RedDataType {
    private String value;

    public String write(){
        return value;
    }

    public String read() {
        return null;
    }
}
