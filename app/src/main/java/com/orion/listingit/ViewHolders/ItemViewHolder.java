package com.orion.listingit.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.orion.listingit.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public TextView mName;
    public ImageView mHandle;

    public ItemViewHolder(View itemView) {
        super(itemView);

        mName = itemView.findViewById(R.id.text);
        mHandle = itemView.findViewById(R.id.handle);
    }

}
