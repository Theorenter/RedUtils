package org.concordiacraft.redutils.requests;

import org.bukkit.entity.Player;

/**
 * @author Theorenter
 * Request as a request, what else can I say?
 */
public interface Request {

    /**
     * @return entity which sends request
     */
    Requestable getRequestSender();

    /**
     * @return entity which receives request
     */
    Requestable getRequestReceiver();

    /**
     * @return numeric identifier of the request
     */
    int getID();
}
