package com.orion.listingit.databaseaccessobjects;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.orion.listingit.entities.SimpleGroceryListItem;

import java.util.List;

@Dao
public interface SimpleGroceryListItemDao {

    @Query("SELECT * FROM simplegrocerylistitem")
    List<SimpleGroceryListItem> getAll();

}
