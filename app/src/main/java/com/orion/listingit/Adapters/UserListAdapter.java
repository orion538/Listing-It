package com.orion.listingit.Adapters;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.orion.listingit.Interfaces.ActionCompletionContract;
import com.orion.listingit.Models.Item;
import com.orion.listingit.R;
import com.orion.listingit.ViewHolders.ItemViewHolder;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements
        ActionCompletionContract {
    private static final int ITEM_TYPE = 1;
    private List<Item> itemsList;
    private ItemTouchHelper touchHelper;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case ITEM_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.text_row_item, parent, false);
                return new ItemViewHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.text_row_item, parent, false);
                return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == ITEM_TYPE) {
            ((ItemViewHolder) holder).mName.setText(itemsList.get(position).getName());
            ((ItemViewHolder) holder).mHandle.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                        touchHelper.startDrag(holder);
                    }
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return itemsList == null ? 0 : itemsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return ITEM_TYPE;
    }

    public void setUserList(List<Item> itemsList) {
        this.itemsList = itemsList;
        notifyDataSetChanged();
    }

    @Override
    public void onViewMoved(int oldPosition, int newPosition) {
        Item targetUser = itemsList.get(oldPosition);
        Item user = new Item(targetUser);
        itemsList.remove(oldPosition);
        itemsList.add(newPosition, user);
        notifyItemMoved(oldPosition, newPosition);
    }

    @Override
    public void onViewSwiped(int position) {
        itemsList.remove(position);
        notifyItemRemoved(position);
    }

    public void setTouchHelper(ItemTouchHelper touchHelper) {

        this.touchHelper = touchHelper;
    }
}