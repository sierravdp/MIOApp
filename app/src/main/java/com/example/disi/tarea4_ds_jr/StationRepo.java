package com.example.disi.tarea4_ds_jr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by disi on 10/05/2015.
 */
public class StationRepo {
    private DBHelperStation dbHelper;

    public StationRepo(Context context) {
        dbHelper = new DBHelperStation(context);
    }

    public int insert(StationDB station) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(StationDB.K_ID, station.id_table);
        values.put(StationDB.ID_ROUTE, station.route);
        values.put(StationDB.ID_STATION,station.station);

        // Inserting Row
        long stat_Id = db.insert(StationDB.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) stat_Id;
    }

    public void delete(String stat_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(StationDB.TABLE, StationDB.K_ID + "= ?", new String[] { String.valueOf(stat_Id) });
        db.close(); // Closing database connection
    }

    public void update(StationDB station) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(StationDB.K_ID, station.id_table);
        values.put(StationDB.ID_ROUTE, station.route);
        values.put(StationDB.ID_STATION,station.station);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(StationDB.TABLE, values, StationDB.K_ID+ "= ?", new String[] { String.valueOf(station.route) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>> getStationList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                StationDB.K_ID + "," +
                StationDB.ID_ROUTE + "," +
                StationDB.ID_STATION + "," +
                " FROM " + StationDB.TABLE;

        ArrayList<HashMap<String, String>> StationList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> listOfStation = new HashMap<String, String>();
                listOfStation.put("id", cursor.getString(cursor.getColumnIndex(StationDB.K_ID)));
                listOfStation.put("route", cursor.getString(cursor.getColumnIndex(StationDB.ID_ROUTE)));
                listOfStation.put("station", cursor.getString(cursor.getColumnIndex(StationDB.ID_STATION)));
                StationList.add(listOfStation);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return StationList;

    }

    public StationDB getStationById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                StationDB.K_ID + "," +
                StationDB.ID_ROUTE + "," +
                StationDB.ID_STATION + "," +
                " FROM " + StationDB.TABLE
                + " WHERE " +
                StationDB.K_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        StationDB station = new StationDB();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                station.id_table =cursor.getInt(cursor.getColumnIndex(StationDB.K_ID));
                station.route =cursor.getString(cursor.getColumnIndex(StationDB.ID_ROUTE));
                station.station =cursor.getString(cursor.getColumnIndex(StationDB.ID_STATION));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return station;
    }
}
