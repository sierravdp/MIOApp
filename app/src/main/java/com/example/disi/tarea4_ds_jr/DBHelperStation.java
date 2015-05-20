package com.example.disi.tarea4_ds_jr;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by disi on 10/05/2015.
 */
public class DBHelperStation extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;

    // Database Name
    private static final String DATABASE_NAME = "station.db";

    public DBHelperStation(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        String CREATE_TABLE_STATIONROUTE = "CREATE TABLE " + StationDB.TABLE  + "("
                + StationDB.K_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + StationDB.ID_STATION  + " TEXT,"
                + StationDB.ID_ROUTE+ "TEXT )";

        db.execSQL(CREATE_TABLE_STATIONROUTE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + database.TABLE);

        // Create tables again
        onCreate(db);

    }
}
