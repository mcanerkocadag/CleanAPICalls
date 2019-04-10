package com.tsurkis.networkcallsautomation.screens.main;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;


import com.bumptech.glide.Glide;
import com.tsurkis.networkcallsautomation.R;
import com.tsurkis.networkcallsautomation.genericAdapter.OnRecyclerObjectClickListener;
import com.tsurkis.networkcallsautomation.network.apiobjects.Book;
import com.tsurkis.networkcallsautomation.network.apiobjects.Books;
import com.tsurkis.networkcallsautomation.network.apiobjects.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewContract.IView, OnRecyclerObjectClickListener<Book> {
    private ViewContract.IPresenter presenter;

    private ImageView dogImageView;
    private Button downloadImageButton;
    private Button userDetailButton;
    private EditText edtUserName, edtPassword;
    private Button createUserBtn;
    private ProgressBar imageLoadingProgressBar;

    private RecyclerView recyclerView;
    private BooksAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this);

        dogImageView = find(R.id.random_dog_image_view);
        downloadImageButton = find(R.id.random_image_submit_button);
        imageLoadingProgressBar = find(R.id.image_loading_progress_bar);
        userDetailButton = find(R.id.user_detail_button);
        createUserBtn = find(R.id.create_user_button);
        edtUserName = find(R.id.edt_user_name);
        edtPassword = find(R.id.edt_password);

        recyclerView = find(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager

        BooksAdapter adapter = new BooksAdapter(getApplicationContext());
        adapter.setListener(this);
        adapter.setItems(new ArrayList<Book>());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        downloadImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presenter != null) {
                    presenter.onRandomImageButtonPressed();
                }
            }
        });

        userDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (presenter != null) {
                    presenter.userDetailButtonPressed();
                }
            }
        });

        createUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (presenter != null) {
                    User user = new User();
                    user.setEmail("mcaner.");
                    user.setPassword("dsad");
                    presenter.createUser(user);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    private <ViewType extends View> ViewType find(@IdRes int viewId) {
        return (ViewType) findViewById(viewId);
    }

    @Override
    public void showProgressBar() {
        downloadImageButton.setClickable(false);
        downloadImageButton.setText("Downloading...");
        imageLoadingProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        downloadImageButton.setClickable(true);
        downloadImageButton.setText("Download");
        imageLoadingProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void displayImage(String imageUrl) {
        Glide.with(this).asBitmap().load(imageUrl).into(dogImageView);
    }

    @Override
    public void showList(Books books) {

        BooksAdapter adapter = new BooksAdapter(getApplicationContext());
        adapter.setListener(this);
        adapter.setItems(books.getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }

    @Override
    public void onItemClicked(Book item) {

    }
}
