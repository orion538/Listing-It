package com.orion.listingit.appdatabases;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.orion.listingit.databaseaccessobjects.SimpleGroceryListItemDao;
import com.orion.listingit.entities.SimpleGroceryListItem;

@Database(entities = {SimpleGroceryListItem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract SimpleGroceryListItemDao simpleGroceryListItemDao();

}
