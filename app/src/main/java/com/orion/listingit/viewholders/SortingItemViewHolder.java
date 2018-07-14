package com.orion.listingit.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.orion.listingit.interfaces.SortingOptionsRecyclerViewClickListener;
import com.orion.listingit.R;

public class SortingItemViewHolder extends RecyclerView.ViewHolder {

    public Button mSortingItem;

    public SortingItemViewHolder(View itemView, final SortingOptionsRecyclerViewClickListener listener) {
        super(itemView);
        mSortingItem = itemView.findViewById(R.id.sorting_option_item);

        mSortingItem.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onClick(v, getAdapterPosition());
            }
        });
    }
}
