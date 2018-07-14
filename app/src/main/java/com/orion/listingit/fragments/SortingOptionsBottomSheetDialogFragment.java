package com.orion.listingit.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orion.listingit.adapters.SortingOptionsAdapter;
import com.orion.listingit.interfaces.SortingOptionsRecyclerViewClickListener;
import com.orion.listingit.R;

public class SortingOptionsBottomSheetDialogFragment
        extends BottomSheetDialogFragment {

    private SortingOptionsRecyclerViewClickListener mListener;

    public SortingOptionsBottomSheetDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof SortingOptionsRecyclerViewClickListener) {
            mListener = (SortingOptionsRecyclerViewClickListener) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sorting_options, container, false);
        RecyclerView mRecyclerView = view.findViewById(R.id.sorting_options_list);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        SortingOptionsAdapter mAdapter = new SortingOptionsAdapter(mListener);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

}
