package org.concordiacraft.redutils.requests;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

/**
 * @author Theorenter
 * A request where the recipient can specify one of two possible values.
 */
public abstract class BinaryRequest implements Request {

    // fields
    protected final Player requestSender;
    protected final Player requestReceiver;
    protected final RequestType type;

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
     * @param requestSender is who sends the request.
     * @param requestReceiver is who get the request.
     */
    public BinaryRequest(Player requestSender, Player requestReceiver, RequestType type) {
        this.requestSender = requestSender;
        this.requestReceiver = requestReceiver;
        this.type = type;

        //requestReceiver.setRequest(this);
        //requestSender.setRequest(this);
    }

    @Override
    public Player getRequestSender() { return requestSender; }

    @Override
    public Player getRequestReceiver() { return requestReceiver; }

    @Override
    public RequestType getRequestType() { return type; }
}
