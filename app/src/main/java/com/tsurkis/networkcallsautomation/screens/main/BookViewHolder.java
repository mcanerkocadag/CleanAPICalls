package com.tsurkis.networkcallsautomation.screens.main;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tsurkis.networkcallsautomation.R;
import com.tsurkis.networkcallsautomation.genericAdapter.BaseViewHolder;
import com.tsurkis.networkcallsautomation.genericAdapter.OnRecyclerObjectClickListener;
import com.tsurkis.networkcallsautomation.network.apiobjects.Book;

public class BookViewHolder extends BaseViewHolder<Book, OnRecyclerObjectClickListener<Book>> {

    private TextView name;
    private ImageView avatar;

    public BookViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tv_name);
        avatar = itemView.findViewById(R.id.iv_avatar);
    }

    @Override
    public void onBind(final Book item, @Nullable final OnRecyclerObjectClickListener<Book> listener) {

        name.setText(item.getName());
        Glide.with(itemView.getContext())
                .load(R.drawable.button_drawable)
                .into(avatar);

        if (listener != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClicked(item);
                }
            });
        }
    }
}
