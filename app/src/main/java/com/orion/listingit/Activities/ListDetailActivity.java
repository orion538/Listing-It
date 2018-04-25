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
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.orion.listingit.Adapters.UserListAdapter;
import com.orion.listingit.DummyData.ItemsData;
import com.orion.listingit.Fragments.SortingOptionsBottomSheetDialogFragment;
import com.orion.listingit.Helpers.SwipeAndDragHelper;
import com.orion.listingit.Models.Item;
import com.orion.listingit.R;

import java.util.List;

public class ListDetailActivity
        extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);

        RecyclerView itemRecyclerView = findViewById(R.id.list);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        UserListAdapter adapter = new UserListAdapter();
        SwipeAndDragHelper swipeAndDragHelper = new SwipeAndDragHelper(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(swipeAndDragHelper);
        adapter.setTouchHelper(touchHelper);
        itemRecyclerView.setAdapter(adapter);
        touchHelper.attachToRecyclerView(itemRecyclerView);

        ItemsData itemsData = new ItemsData();
        List<Item> itemsList = itemsData.getItemsList();
        adapter.setUserList(itemsList);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(itemRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        itemRecyclerView.addItemDecoration(dividerItemDecoration);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        SortingOptionsBottomSheetDialogFragment bottomSheetFragment = new SortingOptionsBottomSheetDialogFragment();
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
        return true;
    }
}
