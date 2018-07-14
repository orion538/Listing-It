package com.orion.listingit.adapters;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orion.listingit.enums.ItemSortingOptions;
import com.orion.listingit.interfaces.SortingOptionsRecyclerViewClickListener;
import com.orion.listingit.R;
import com.orion.listingit.viewholders.SortingItemViewHolder;

public class SortingOptionsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private SortingOptionsRecyclerViewClickListener mListener;

    public SortingOptionsAdapter(SortingOptionsRecyclerViewClickListener listener) {
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_sorting_option_button, parent, false);
        return new SortingItemViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (position) {
            case ItemSortingOptions.Alphabet:
                ((SortingItemViewHolder) holder).mSortingItem.setText(R.string.sorting_item_alphabet);
                ((SortingItemViewHolder) holder).mSortingItem.setCompoundDrawablesWithIntrinsicBounds( 0, 0, R.drawable.ic_check_blue_24dp, 0);;
                break;
            case ItemSortingOptions.Created:
                ((SortingItemViewHolder) holder).mSortingItem.setText(R.string.sorting_item_created);
                break;
            case ItemSortingOptions.Manual:
                ((SortingItemViewHolder) holder).mSortingItem.setText(R.string.sorting_item_manual);
                break;
        }
        ((SortingItemViewHolder) holder).mSortingItem.setTypeface(null, Typeface.NORMAL);
    }

    @Override
    public int getItemCount() {
        return ItemSortingOptions.All;
    }
}
