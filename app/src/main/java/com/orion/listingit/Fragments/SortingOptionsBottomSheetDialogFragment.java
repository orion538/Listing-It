package com.orion.listingit.Fragments;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orion.listingit.Adapters.SortingOptionsAdapter;
import com.orion.listingit.Interfaces.SortingOptionsRecyclerViewClickListener;
import com.orion.listingit.R;

public class SortingOptionsBottomSheetDialogFragment
        extends BottomSheetDialogFragment {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private SortingOptionsAdapter mAdapter;

    private SortingOptionsRecyclerViewClickListener mListener;

    public SortingOptionsBottomSheetDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sorting_options, container, false);
        mRecyclerView = view.findViewById(R.id.sorting_options_list);

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new SortingOptionsAdapter(mListener);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    /**
     * @param listener
     */
    public void setSortingOptionsRecyclerViewClickListener(SortingOptionsRecyclerViewClickListener listener) {
        mListener = listener;
    }

}
