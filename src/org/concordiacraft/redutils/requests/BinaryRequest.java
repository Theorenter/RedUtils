package org.concordiacraft.redutils.requests;

/**
 * @author Theorenter
 * A request where the recipient can specify one of two possible values.
 */
public abstract class BinaryRequest extends Request {

    /**
     * What should happen if player accept request.
     */
    abstract void acceptRequest();

    /**
     * What should happen if player decline request.
     */
    abstract void declineRequest();

    /**
     * Request constructor
     * @param requestSender is who sends the request.
     * @param requestReceiver is who get the request.
     * @param content lines to be displayed to the request receiver.
     */
    public BinaryRequest(Requestable requestSender, Requestable requestReceiver, String... content) {
        super(requestSender, requestReceiver, content);
    }
}
