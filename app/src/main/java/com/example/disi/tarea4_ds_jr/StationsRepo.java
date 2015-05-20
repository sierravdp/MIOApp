package com.example.disi.tarea4_ds_jr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by disi on 19/05/2015.
 */
public class StationsRepo {
    private StationsHelper dbHelper;

    public StationsRepo(Context context) {
        dbHelper = new StationsHelper(context);
    }

    public int insert(Stations station) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Stations.K_ID, station.id_table);
        values.put(Stations.ID_STATION,station.station);
        values.put(Stations.LATITUDE,station.latitude);
        values.put(Stations.LONGITUDE,station.longitude);

        // Inserting Row
        long stat_Id = db.insert(Stations.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) stat_Id;
    }

    public void delete(String stat_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Stations.TABLE, Stations.K_ID + "= ?", new String[] { String.valueOf(stat_Id) });
        db.close(); // Closing database connection
    }

    public void update(Stations station) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Stations.K_ID, station.id_table);
        values.put(Stations.ID_STATION,station.station);
        values.put(Stations.LATITUDE,station.latitude);
        values.put(Stations.LONGITUDE,station.longitude);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Stations.TABLE, values, Stations.K_ID+ "= ?", new String[] { String.valueOf(station.station) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>> getStationList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Stations.K_ID + "," +
                Stations.ID_STATION + "," +
                Stations.LATITUDE + "," +
                Stations.LONGITUDE + "," +
                " FROM " + Stations.TABLE;

        ArrayList<HashMap<String, String>> StationList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> listOfStation = new HashMap<String, String>();
                listOfStation.put("id", cursor.getString(cursor.getColumnIndex(Stations.K_ID)));
                listOfStation.put("station", cursor.getString(cursor.getColumnIndex(Stations.ID_STATION)));
                listOfStation.put("latitude", cursor.getString(cursor.getColumnIndex(Stations.LATITUDE)));
                listOfStation.put("longitude", cursor.getString(cursor.getColumnIndex(Stations.LONGITUDE)));
                StationList.add(listOfStation);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return StationList;

    }

    public Stations getStationById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Stations.K_ID + "," +
                Stations.ID_STATION + "," +
                Stations.LATITUDE + "," +
                Stations.LONGITUDE + "," +
                " FROM " + Stations.TABLE
                + " WHERE " +
                Stations.K_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Stations station = new Stations();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                station.id_table =cursor.getInt(cursor.getColumnIndex(Stations.K_ID));
                station.station =cursor.getString(cursor.getColumnIndex(Stations.ID_STATION));
                station.latitude =cursor.getDouble(cursor.getColumnIndex(Stations.LATITUDE));
                station.longitude =cursor.getDouble(cursor.getColumnIndex(Stations.LONGITUDE));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return station;
    }
}
