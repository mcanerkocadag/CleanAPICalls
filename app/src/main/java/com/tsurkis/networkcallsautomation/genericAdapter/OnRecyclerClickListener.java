package com.tsurkis.networkcallsautomation.genericAdapter;

public interface OnRecyclerClickListener extends BaseRecyclerListener {
    /**
     * RecyclerView item has been clicked
     *
     * @param id item id
     */
    void onItemClicked(long id);
}
