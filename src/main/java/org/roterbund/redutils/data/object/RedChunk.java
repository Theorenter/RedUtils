package org.roterbund.redutils.data.object;

import org.bukkit.Chunk;
import org.roterbund.redutils.data.RedData;
import org.roterbund.redutils.data.RedTypeChunk;

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
