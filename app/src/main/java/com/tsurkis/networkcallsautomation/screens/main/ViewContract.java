package com.tsurkis.networkcallsautomation.screens.main;

import com.tsurkis.networkcallsautomation.network.apiobjects.Books;
import com.tsurkis.networkcallsautomation.network.apiobjects.User;

/**
 * Created by M.Caner.
 */
interface ViewContract {
    interface IPresenter {
        void onRandomImageButtonPressed();

        void userDetailButtonPressed();

        void createUser(User user);
    }

    interface IView {
        void showProgressBar();

        void hideProgressBar();

        void displayImage(String imageUrl);

        void showList(Books books);
    }
}
