package org.concordiacraft.redutils.data.object;

import org.bukkit.Chunk;
import org.concordiacraft.redutils.data.RedData;
import org.concordiacraft.redutils.data.RedTypeChunk;

import java.io.File;

public class RedChunk extends RedData {
    RedTypeChunk typeChunk;

    public RedChunk(Chunk chunk){
        typeChunk = new RedTypeChunk(chunk.getWorld().getName(), chunk.getX(), chunk.getZ());
    }

    @Override
    protected File getFile() {
        return new File(this.typeChunk.write());
    }
}
