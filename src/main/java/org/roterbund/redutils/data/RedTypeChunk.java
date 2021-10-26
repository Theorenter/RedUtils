package org.roterbund.redutils.data;

public class RedTypeChunk implements RedDataType {
    private String worldName;
    int X,Z;
    public RedTypeChunk(String worldName, int X, int Z){
        this.worldName = worldName;
        this.X = X;
        this.Z = Z;
    }
    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getZ() {
        return Z;
    }

    public void setZ(int z) {
        Z = z;
    }

    @Override
    public String write() {
        return this.worldName+"_"+this.X+"_"+this.Z;
    }

    @Override
    public String read() {
        return null;
    }
}
