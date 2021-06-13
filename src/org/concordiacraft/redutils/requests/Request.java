package org.concordiacraft.redutils.requests;

import org.bukkit.entity.Player;

/**
 * @author Theorenter
 * Request as a request, what else can I say?
 */
public interface Request {
    /**
     * @return entity who send request.
     */
    Player getRequestSender();
    /**
     * @return entity who receive request.
     */
    Player getRequestReceiver();
    /**
     * @return entity who receive request.
     */
    RequestType getRequestType();
}
