package org.roterbund.redutils.requests;

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
