package com.orion.listingit.contentproviders;

import android.arch.persistence.room.Room;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.orion.listingit.appdatabases.AppDatabase;
import com.orion.listingit.databaseaccessobjects.SimpleGroceryListItemDao;

public class SimpleGroceryListContentProvider extends ContentProvider {

    public static final String AUTHORITY = "com.orion.listingit.contentproviders.SimpleGroceryListContentProvider"; //specific for our our app, will be specified in manifest.
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    // Defines a handle to the Room database
    private AppDatabase appDatabase;

    // Defines a Data Access Object to perform the database operations
    private SimpleGroceryListItemDao simpleGroceryListItemDao;

    // Defines the database name
    private static final String DBNAME = "mydb";

    @Override
    public boolean onCreate() {

        // Creates a new database object.
        appDatabase = Room.databaseBuilder(getContext(), AppDatabase.class, DBNAME).build();

        // Gets a Data Access Object to perform the database operations
        simpleGroceryListItemDao = appDatabase.simpleGroceryListItemDao();

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
