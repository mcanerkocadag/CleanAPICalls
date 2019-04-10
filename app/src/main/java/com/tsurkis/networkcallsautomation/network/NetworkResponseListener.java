package com.tsurkis.networkcallsautomation.network;

/**
 * Created by M.Caner.
 */
public interface NetworkResponseListener<Response> {

    void onResponseReceived(Response response);

    void onError();
}
