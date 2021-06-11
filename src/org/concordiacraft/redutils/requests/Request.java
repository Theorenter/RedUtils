package org.concordiacraft.redutils.requests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Theorenter
 * Request as a request, what else can I say?
 */
abstract public class Request {
    // fields
    private final Requestable requestSender;
    private final Requestable requestReceiver;
    private final List<String> content;

    /**
     * Request constructor
     * @param requestSender is who sends the request.
     * @param requestReceiver is who get the request.
     * @param content lines to be displayed to the request receiver.
     */
    public Request(Requestable requestSender, Requestable requestReceiver, String... content) {
        this.requestSender = requestSender;
        this.requestReceiver = requestReceiver;
        this.content = new ArrayList(Arrays.asList(content));

        RequestManager.addServerRequest(this);
    }
    // Getters

    /**
     * @return entity who send request.
     */
    public Requestable getRequestSender() { return requestSender; }
    /**
     * @return entity who receive request.
     */
    public Requestable getRequestReceiver() { return requestReceiver; }
    /**
     * @return list of the string content.
     */
    public List<String> getContent() { return content; }
}
