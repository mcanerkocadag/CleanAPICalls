package com.tsurkis.networkcallsautomation.screens.main;

import android.util.Log;

import com.tsurkis.networkcallsautomation.network.NetworkManager;
import com.tsurkis.networkcallsautomation.network.NetworkResponseListener;
import com.tsurkis.networkcallsautomation.network.apiobjects.Books;
import com.tsurkis.networkcallsautomation.network.apiobjects.MyPojo;
import com.tsurkis.networkcallsautomation.network.apiobjects.User;

import java.lang.ref.WeakReference;

/**
 * Created by M.Caner.
 */
class Presenter implements ViewContract.IPresenter {
    private WeakReference<ViewContract.IView> view;

    Presenter(ViewContract.IView view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void onRandomImageButtonPressed() {
        if (view.get() != null && view != null) {
            view.get().showProgressBar();
        }
//        NetworkManager.getInstance().requestRandomDogImage(new NetworkResponseListener<BreedRandomImage>() {
//            @Override
//            public void onResponseReceived(BreedRandomImage s) {
//                if (view.get() != null && view != null && s != null) {
//                    view.get().hideProgressBar();
//                    view.get().displayImage(s.getRandomImageUrl());
//                } else {
//                    view.get().hideProgressBar();
//                }
//            }
//
//            @Override
//            public void onError() {
//                view.get().hideProgressBar();
//            }
//        });

        NetworkManager.getService().getUsers(new NetworkResponseListener<MyPojo>() {
            @Override
            public void onResponseReceived(MyPojo s) {
                if (view.get() != null && view != null && s != null) {
                    view.get().hideProgressBar();
                    view.get().displayImage("" + s.getData()[0].getAvatar());
                } else {
                    view.get().hideProgressBar();
                }
            }

            @Override
            public void onError() {
                view.get().hideProgressBar();
            }
        });
    }

    @Override
    public void userDetailButtonPressed() {

        NetworkManager.getService().getBooks(new NetworkResponseListener<Books>() {
            @Override
            public void onResponseReceived(Books books) {
                Log.i("result", "onResponseReceived: " + books.getData().size());
                view.get().showList(books);
            }

            @Override
            public void onError() {
                Log.i("result", "onError");
            }
        });

//        NetworkManager.getInstance().getUser(new NetworkResponseListener<UserDetail>() {
//            @Override
//            public void onResponseReceived(UserDetail response) {
//                if (response == null)
//                    return;
//
//                Log.i("Result", "onResponseReceived: " + response.getData().toString());
//            }
//
//            @Override
//            public void onError() {
//
//                Log.i("Result", "onError: ");
//            }
//        }, 23);
    }

    @Override
    public void createUser(User user) {

        NetworkManager.getService().createUser(new NetworkResponseListener<User>() {
            @Override
            public void onResponseReceived(User user) {
                Log.i("Result", "createUser | onResponseReceived: Token: " + user.getToken());
            }

            @Override
            public void onError() {
                Log.i("Result", "createUser | onError: ");
            }
        }, user);
    }
}
