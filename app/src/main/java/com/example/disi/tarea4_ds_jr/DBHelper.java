package com.example.disi.tarea4_ds_jr;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by disi on 10/05/2015.
 */


public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;

    // Database Name
    private static final String DATABASE_NAME = "crud.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here
        String CREATE_TABLE_ROUTE = "CREATE TABLE " + database.TABLE  + "("
                + database.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + database.KEY_NAME  + " TEXT,"
                + database.KEY_INIT + " TEXT, "
                + database.KEY_END + " TEXT, "
                + database.KEY_DIRECTION + " TEXT )";

        db.execSQL(CREATE_TABLE_ROUTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + database.TABLE);

        // Create tables again
        onCreate(db);
    }

}