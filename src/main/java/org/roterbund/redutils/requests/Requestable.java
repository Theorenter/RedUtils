package org.roterbund.redutils.requests;

import java.util.ArrayList;

/**
 * This interface must inherit
 * entities that can respond to requests.
 */
public interface Requestable {
    /**
     * @return true if the entity has an active request now, and false if not
    */
    boolean hasRequest();

    /**
     * @return active requests
     */
    ArrayList<Request> getRequests();

    /**
     * Clear current request for requestable
     */
   void clearRequests();
}
