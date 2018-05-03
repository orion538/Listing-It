package com.orion.listingit.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.orion.listingit.Adapters.ItemsAdapter;
import com.orion.listingit.DummyData.ItemsData;
import com.orion.listingit.Enums.ItemSortingOptions;
import com.orion.listingit.Fragments.SortingOptionsBottomSheetDialogFragment;
import com.orion.listingit.Helpers.SwipeAndDragHelper;
import com.orion.listingit.Interfaces.SortingOptionsRecyclerViewClickListener;
import com.orion.listingit.Models.Item;
import com.orion.listingit.R;

import java.util.List;

public class ListDetailActivity
        extends AppCompatActivity
        implements SortingOptionsRecyclerViewClickListener {

    private static final String SORTING_FRAGMENT_TAG = "SortingFragmentTag";

    private SortingOptionsBottomSheetDialogFragment mSortingFragment;

    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);

        mSortingFragment = new SortingOptionsBottomSheetDialogFragment();

        RecyclerView mRecyclerView = findViewById(R.id.list);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        ItemsAdapter mAdapter = new ItemsAdapter();
        SwipeAndDragHelper mSwipeAndDragHelper = new SwipeAndDragHelper(mAdapter);
        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(mSwipeAndDragHelper);
        mAdapter.setTouchHelper(mItemTouchHelper);
        mRecyclerView.setAdapter(mAdapter);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);

        ItemsData itemsData = new ItemsData();
        List<Item> itemsList = itemsData.getItemsList();
        mAdapter.setItemsList(itemsList);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mToast = Toast.makeText(this, "pressed a button",
                Toast.LENGTH_LONG);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_sort) {
            return openSortingOptionsDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean openSortingOptionsDialog() {
        mSortingFragment.show(getSupportFragmentManager(), SORTING_FRAGMENT_TAG);
        return true;
    }

    @Override
    public void onClick(View view, int position) {
        switch (position) {
            case ItemSortingOptions.Alphabet:
                mToast.setText("Pressed Alphabet");
                break;
            case ItemSortingOptions.Created:
                mToast.setText("Pressed Created");
                break;
            case ItemSortingOptions.Manual:
                mToast.setText("Pressed Manual");
                break;
        }
        mToast.show();
        SortingOptionsBottomSheetDialogFragment fragment = (SortingOptionsBottomSheetDialogFragment) getSupportFragmentManager().findFragmentByTag(SORTING_FRAGMENT_TAG);
        fragment.dismiss();
    }
}
