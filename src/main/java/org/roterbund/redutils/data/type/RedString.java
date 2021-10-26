package org.roterbund.redutils.data.type;

import org.roterbund.redutils.data.RedDataType;

public class RedString implements RedDataType {
    private String value;

    public String write(){
        return value;
    }

    public String read() {
        return null;
    }
}
