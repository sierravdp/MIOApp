package com.example.disi.tarea4_ds_jr;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by disi on 19/05/2015.
 */

public class StationsHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 4;

    // Database Name
    private static final String DATABASE_NAME = "stations.db";

    public StationsHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        String CREATE_TABLE_STATIONS = "CREATE TABLE " + Stations.TABLE  + "("
                + Stations.K_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Stations.ID_STATION  + " TEXT,"
                + Stations.LATITUDE  + "DOUBLE,"
                + Stations.LONGITUDE  + "DOUBLE )";

        db.execSQL(CREATE_TABLE_STATIONS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Stations.TABLE);

        // Create tables again
        onCreate(db);

    }
}
