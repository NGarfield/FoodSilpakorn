package com.example.foodsilpakorn.room_db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.foodsilpakorn.model.Restaurants;


@Database(entities = {Restaurants.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "restaurants.db";

    public abstract RestaurantsDao restaurantsDao();

    private static AppDatabase mInstance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room
                    .databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            DB_NAME
                    )
                    .build();
        }
        return mInstance;
    }
}
