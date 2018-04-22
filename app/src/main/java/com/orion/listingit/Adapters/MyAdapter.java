package com.orion.listingit.Adapters;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.orion.listingit.Interfaces.IItemTouchHelperAdapter;
import com.orion.listingit.Interfaces.OnStartDragListener;
import com.orion.listingit.R;

import java.util.Collections;
import java.util.List;

public class MyAdapter
        extends RecyclerView.Adapter<MyAdapter.ViewHolder>
        implements IItemTouchHelperAdapter {
    private OnStartDragListener mDragStartListener;
    private List<String> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public FrameLayout mFrameLayout;
        public TextView mTextView;
        public ImageView mImageView;
        public ViewHolder(FrameLayout v, ImageView i, TextView t) {
            super(v);
            mFrameLayout = v;
            mTextView = t;
            mImageView = i;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(OnStartDragListener dragStartListener,
                     List<String> myDataset) {
        mDragStartListener = dragStartListener;
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        FrameLayout v = (FrameLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);
        TextView text = v.findViewById(R.id.text);
        ImageView handle = v.findViewById(R.id.handle);
        ViewHolder vh = new ViewHolder(v, handle, text);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position));

        holder.mImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mDragStartListener.onStartDrag(holder);
                }
                return false;
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mDataset, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mDataset, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        mDataset.remove(position);
        notifyItemRemoved(position);
    }
}
