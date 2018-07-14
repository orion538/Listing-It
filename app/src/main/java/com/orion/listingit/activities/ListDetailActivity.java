package com.orion.listingit.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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

import com.orion.listingit.adapters.ItemsAdapter;
import com.orion.listingit.dummydata.ItemsData;
import com.orion.listingit.enums.ItemSortingOptions;
import com.orion.listingit.fragments.NewListItemDialogFragment;
import com.orion.listingit.fragments.SortingOptionsBottomSheetDialogFragment;
import com.orion.listingit.helpers.SwipeAndDragHelper;
import com.orion.listingit.interfaces.SortingOptionsRecyclerViewClickListener;
import com.orion.listingit.models.Item;
import com.orion.listingit.R;

import java.util.List;

public class ListDetailActivity
        extends AppCompatActivity
        implements SortingOptionsRecyclerViewClickListener {

    private static final String SORTING_FRAGMENT_TAG = "SortingFragmentTag";
    private static final String NEW_LIST_TITLE_DIALOG_FRAGMENT_TAG = "NewListTitleDialogFragment";

    private SortingOptionsBottomSheetDialogFragment mSortingFragment;
    private NewListItemDialogFragment mNewListTitleDialogFrament;

    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);

        mSortingFragment = new SortingOptionsBottomSheetDialogFragment();
        mNewListTitleDialogFrament = new NewListItemDialogFragment();

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
                mNewListTitleDialogFrament.show(getSupportFragmentManager(), NEW_LIST_TITLE_DIALOG_FRAGMENT_TAG);
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

    private boolean openSortingOptionsDialog() {
        mSortingFragment.show(getSupportFragmentManager(), SORTING_FRAGMENT_TAG);
        return true;
    }
}
