package com.tsurkis.networkcallsautomation.network;

import com.tsurkis.networkcallsautomation.network.apiservices.generalnetworkcall.ApiService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by M.Caner.
 */
public class NetworkManager {
    public static String BASE_URL = "https://reqres.in/";
    private static NetworkManager instance = null;
    private static ApiService apiService = null;
    private final FakeAPI api;

    private NetworkManager() {
        Retrofit retrofitCore =
                new Retrofit
                        .Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(new OkHttpClient())
                        .build();

        api = retrofitCore.create(FakeAPI.class);

        apiService = new ApiService(api);
    }

    private static NetworkManager getInstance() {
        if (instance == null) {
            instance = new NetworkManager();
            return instance;
        }
        return instance;
    }

    private ApiService getServiceInstance() {

        if (apiService == null) {
            apiService = new ApiService(api);
            return apiService;
        }

        return apiService;
    }

    public static ApiService getService() {

        return getInstance().getServiceInstance();
    }
}
