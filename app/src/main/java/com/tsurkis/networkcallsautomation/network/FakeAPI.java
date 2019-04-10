package com.tsurkis.networkcallsautomation.network;

import com.tsurkis.networkcallsautomation.network.apiobjects.Books;
import com.tsurkis.networkcallsautomation.network.apiobjects.MyPojo;
import com.tsurkis.networkcallsautomation.network.apiobjects.User;
import com.tsurkis.networkcallsautomation.network.apiobjects.UserDetail;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface FakeAPI {

    @GET("api/users?page=2")
    Call<MyPojo> getUsers();

    @GET("api/users/{id}")
    Call<UserDetail> getUser(@Path("id") int userID);

    @GET("/api/unknown")
    Call<Books> getBooks();

    @POST("/api/register")
    Call<User> createUser(@Body User user);
}
