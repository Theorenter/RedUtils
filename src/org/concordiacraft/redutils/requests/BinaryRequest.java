package org.concordiacraft.redutils.requests;

/**
 * @author Theorenter
 * A request where the recipient can specify one of two possible values.
 */
public abstract class BinaryRequest implements Request {

    // fields
    protected final Requestable requestSender;
    protected final Requestable requestReceiver;

    /**
     * What should happen if player accept request.
     */
    public abstract void onAccept();

    /**
     * What should happen if player decline request.
     */
    public abstract void onDecline();

    /**
     * Show request for request's receiver.
     */
    public abstract void showRequest();

    /**
     * Request constructor.
     * @param requestSender which sends the request
     * @param requestReceiver which get the request
     */
    public BinaryRequest(Requestable requestSender, Requestable requestReceiver, RequestType type) {
        this.requestSender = requestSender;
        this.requestReceiver = requestReceiver;
    }

    @Override
    public Requestable getRequestSender() { return requestSender; }

    @Override
    public Requestable getRequestReceiver() { return requestReceiver; }

    @Override
    public int getID() {
        return requestReceiver.getRequests().indexOf(this);
    }
}
