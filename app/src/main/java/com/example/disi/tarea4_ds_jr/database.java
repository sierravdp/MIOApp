package com.example.disi.tarea4_ds_jr;

/**
 * Created by disi on 10/05/2015.
 */
public class database {

    public static final String TABLE = "database";

    // Labels Table Columns names
    public static final String KEY_ID = "routeID";
    public static final String KEY_NAME = "routeName";
    public static final String KEY_INIT = "init";
    public static final String KEY_END = "finalR";
    public static final String KEY_DIRECTION = "sentido";

    // property help us to keep data
    public int routeID;
    public String routeName;
    public String init;
    public String finalR;
    public String sentido;
}
