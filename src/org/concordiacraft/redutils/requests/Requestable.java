package org.concordiacraft.redutils.requests;

/**
 * This interface must inherit
 * entities that can respond to requests.
 */

public interface Requestable {
    /**
     * @return true if the entity has an active request now, and false if not.
     */
    boolean hasRequest();
}
