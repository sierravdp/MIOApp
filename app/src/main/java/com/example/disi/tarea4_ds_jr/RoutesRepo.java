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
public class RoutesRepo {
    private DBHelper dbHelper;

    public RoutesRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(database routes) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(database.KEY_ID, routes.routeID);
        values.put(database.KEY_NAME, routes.routeName);
        values.put(database.KEY_INIT,routes.init);
        values.put(database.KEY_END, routes.finalR);
        values.put(database.KEY_DIRECTION, routes.sentido);

        // Inserting Row
        long route_Id = db.insert(database.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) route_Id;
    }

    public void delete(String route_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(database.TABLE, database.KEY_ID + "= ?", new String[] { String.valueOf(route_Id) });
        db.close(); // Closing database connection
    }

    public void update(database routes) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(database.KEY_ID, routes.routeID);
        values.put(database.KEY_NAME, routes.routeName);
        values.put(database.KEY_INIT,routes.init);
        values.put(database.KEY_END, routes.finalR);
        values.put(database.KEY_DIRECTION, routes.sentido);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(database.TABLE, values, database.KEY_ID + "= ?", new String[] { String.valueOf(routes.routeName) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>> getRoutesList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                database.KEY_ID + "," +
                database.KEY_NAME + "," +
                database.KEY_INIT + "," +
                database.KEY_END + "," +
                database.KEY_DIRECTION +
                " FROM " + database.TABLE;

        ArrayList<HashMap<String, String>> studentList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> listOfRoutes = new HashMap<String, String>();
                listOfRoutes.put("id", cursor.getString(cursor.getColumnIndex(database.KEY_ID)));
                listOfRoutes.put("name", cursor.getString(cursor.getColumnIndex(database.KEY_NAME)));
                listOfRoutes.put("init", cursor.getString(cursor.getColumnIndex(database.KEY_INIT)));
                listOfRoutes.put("end", cursor.getString(cursor.getColumnIndex(database.KEY_END)));
                listOfRoutes.put("direction", cursor.getString(cursor.getColumnIndex(database.KEY_DIRECTION)));
                studentList.add(listOfRoutes);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return studentList;

    }

    public database getRouteById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                database.KEY_ID + "," +
                database.KEY_NAME + "," +
                database.KEY_INIT + "," +
                database.KEY_END + "," +
                database.KEY_DIRECTION +
                " FROM " + database.TABLE
                + " WHERE " +
                database.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        database routes = new database();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                routes.routeID =cursor.getInt(cursor.getColumnIndex(database.KEY_ID));
                routes.routeName =cursor.getString(cursor.getColumnIndex(database.KEY_NAME));
                routes.init =cursor.getString(cursor.getColumnIndex(database.KEY_INIT));
                routes.finalR =cursor.getString(cursor.getColumnIndex(database.KEY_END));
                routes.sentido =cursor.getString(cursor.getColumnIndex(database.KEY_DIRECTION));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return routes;
    }
}