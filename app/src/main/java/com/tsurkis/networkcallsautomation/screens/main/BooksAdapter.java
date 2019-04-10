package com.tsurkis.networkcallsautomation.screens.main;

import android.content.Context;
import android.view.ViewGroup;
import com.tsurkis.networkcallsautomation.R;
import com.tsurkis.networkcallsautomation.genericAdapter.GenericRecyclerAdapter;
import com.tsurkis.networkcallsautomation.genericAdapter.OnRecyclerObjectClickListener;
import com.tsurkis.networkcallsautomation.network.apiobjects.Book;

public class BooksAdapter extends GenericRecyclerAdapter<Book, OnRecyclerObjectClickListener<Book>, BookViewHolder> {

    public BooksAdapter(Context context) {
        super(context);
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BookViewHolder(inflate(R.layout.item_user, parent));
    }
}
