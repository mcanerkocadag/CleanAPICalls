package com.tsurkis.networkcallsautomation.network.apiservices.generalnetworkcall;

import com.tsurkis.networkcallsautomation.network.FakeAPI;
import com.tsurkis.networkcallsautomation.network.NetworkResponseListener;
import com.tsurkis.networkcallsautomation.network.apiobjects.Books;
import com.tsurkis.networkcallsautomation.network.apiobjects.MyPojo;
import com.tsurkis.networkcallsautomation.network.apiobjects.User;
import com.tsurkis.networkcallsautomation.network.apiobjects.UserDetail;

/**
 * Created by M.Caner.
 */
public class ApiService {

    private FakeAPI api;

    public ApiService(FakeAPI api) {
        this.api = api;
    }

    public void getUsers(NetworkResponseListener<MyPojo> listener) {

        api.getUsers().enqueue(new NetworkResponse<>(listener));
    }

    public void getUser(NetworkResponseListener<UserDetail> listener, int id) {

        api.getUser(id).enqueue(new NetworkResponse<>(listener));
    }

    public void getBooks(NetworkResponseListener<Books> listener) {

        api.getBooks().enqueue(new NetworkResponse<>(listener));
    }

    public void createUser(NetworkResponseListener<User> listener, User user) {
        api.createUser(user).enqueue(new NetworkResponse<>(listener));
    }
}
