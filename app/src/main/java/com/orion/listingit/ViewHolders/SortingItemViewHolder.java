package com.orion.listingit.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.orion.listingit.Interfaces.SortingOptionsRecyclerViewClickListener;
import com.orion.listingit.R;

public class SortingItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public Button mSortingItem;
    private SortingOptionsRecyclerViewClickListener mListener;

    public SortingItemViewHolder(View itemView, SortingOptionsRecyclerViewClickListener listener) {
        super(itemView);

        mListener = listener;
        mSortingItem = itemView.findViewById(R.id.sorting_option_item);
        mSortingItem.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mListener.onClick(view, getAdapterPosition());
    }
}
