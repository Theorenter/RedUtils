
package org.concordiacraft.redutils.requests;

import java.util.ArrayList;
import java.util.List;

public final class RequestManager {

//    // Fields
//        // All requests
//    private static List<Request> serverRequest = new ArrayList<>();
//
//    /**
//     * List of all RedPlugin requests.
//     *
//     * @return List of all requests.
//     */
//    public static List<Request> getServerRequest() {
//        return serverRequest;
//    }
//
//    /**
//     * Adds the request to the list of all RedPlugin requests.
//     *
//     * @param request request.
//     */
//    public static void addServerRequest(Request request) {
//        serverRequest.add(request);
//    }
//
//    /**
//     * @param requestable an entity that can receive and send a request.
//     * @return true if the entity currently has an active request, and false if not.
//     */
//    public static boolean hasAnyRequest(Requestable requestable) {
//        for (Request r : serverRequest) {
//            if ((r.getRequestReceiver().equals(requestable)) || r.getRequestSender().equals(requestable))
//                return true;
//        } return false;
//    }
//
//    /**
//     * @param requestReceiver an entity that can receive a request.
//     * @return true if the entity request receiver currently has an active request, and false if not.
//   */
//    public static boolean hasPendingRequest(Requestable requestReceiver) {
//        for (Request r : serverRequest) {
//            if (r.getRequestReceiver().equals(requestReceiver))
//                return true;
//        } return false;
//    }
//    /**
//     * @param requestSender an entity that can send a request.
//     * @return true if the entity request sender currently has an active request, and false if not.
//     */
//    public static boolean hasSentRequest(Requestable requestSender) {
//        for (Request r : serverRequest) {
//            if (r.getRequestSender().equals(requestSender))
//                return true;
//        } return false;
//    }
//
//    /**
//     *
//     * @param request request to remove from the list.
//     * @return true if request was successfully deleted and false if not.
//     */
//    public static boolean removeFromRequestList(Request request) {
//        return serverRequest.remove(request);
//    }
}