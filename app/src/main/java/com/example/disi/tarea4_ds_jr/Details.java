package com.example.disi.tarea4_ds_jr;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class Details extends ActionBarActivity {

    StationRepo repoStation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        repoStation = new StationRepo(this);
        addingDBStationRoutes();

        initializingTextLayout();
        addingDataTextLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initializingTextLayout(){
        //adding in table the description menu
        TableLayout tableview = (TableLayout) findViewById(R.id.tableStations);
        TableRow row = new TableRow(this);

        TableLayout.LayoutParams lp = new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(lp);

        row.setPadding(15, 3, 15, 3);

        row.setBackgroundColor(Color.parseColor("#000055"));

        TextView Header = new TextView(this);

        Header.setGravity(Gravity.CENTER);
        Header.setText("Rutas troncales");
        Header.setTextSize(25.0f);
        Header.setPadding(15, 0, 15, 0);
        Header.setTextColor(Color.parseColor("#FFFFFF"));
        Header.setTypeface(null, Typeface.BOLD);

        row.addView(Header);

        for (int j = 0; j < 1; j++) {
            TextView Values = new TextView(this);
            Values.setPadding(15, 0, 15, 0);
            Values.setGravity(Gravity.CENTER);
            Values.setTextSize(25.0f);
            Values.setTextColor(Color.parseColor("#FFFFFF"));
            Values.setTypeface(null, Typeface.BOLD);

            if (j == 0){
                Values.setText("Estaciones paradas");
            }

            row.addView(Values);
        }
        tableview.addView(row);
    }

    public void addingDataTextLayout(){
/* hacer la búsqueda según el filtro id*/
        TableLayout tableview = (TableLayout) findViewById(R.id.tableStations);
        tableview.setPadding(15, 3, 15, 3);

        int route_id = 0;
        int value = getIntent().getIntExtra("EXTRA_SESSION_ID",route_id);


        for (int i = 0; i < 7; i++) {
            //StationDB temp_data = repoStation.getStationById(i);

            TableRow row = new TableRow(this);

            TableLayout.LayoutParams lp = new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            row.setPadding(15, 3, 15, 3);

            row.setBackgroundColor(Color.parseColor("#0000FF"));

            TextView Header = new TextView(this);

            Header.setGravity(Gravity.CENTER);
            Header.setText("Route");
            //Header.setText(temp_data.route);
            Header.setTextSize(30.0f);
            Header.setPadding(15, 0, 15, 0);
            Header.setTextColor(Color.parseColor("#FFFFFF"));
            Header.setTypeface(null, Typeface.BOLD);

            row.addView(Header);

                TextView Values = new TextView(this);
                Values.setPadding(15, 0, 15, 0);
                Values.setGravity(Gravity.CENTER);
                Values.setTextSize(30.0f);
                Values.setTextColor(Color.parseColor("#FFFFFF"));
                Values.setTypeface(null, Typeface.BOLD);

                    Values.setText("station");
                    //Values.setText(temp_data.station);

                row.addView(Values);

            tableview.addView(row);
        }
    }

    public void goToMaps(View view){
        Intent ex = new Intent(this,MapsActivity.class);
        //EditText text2 = new EditText(findViewById("R.id.text1"));

        //String xx = text2.getText().toString();
        startActivity(ex);
    }

    public void addingDBStationRoutes(){
        int id_db = 0;

        StationDB db = new StationDB();
        db.id_table = 0;
        db.route = "T40";
        db.station = "7 de Agosto";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 1;
        db.route = "T47A";
        db.station = "7 de Agosto";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 2;
        db.route = "T47B";
        db.station = "7 de Agosto";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 3;
        db.route = "T50";
        db.station = "Amanecer";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 4;
        db.route = "T57A";
        db.station = "Amanecer";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 5;
        db.route = "T40";
        db.station = "Andres Sanin";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 6;
        db.route = "T47A";
        db.station = "Andres Sanin";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 7;
        db.route = "T47B";
        db.station = "Andres Sanin";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 8;
        db.route = "T40";
        db.station = "Atanasio Girardot";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 9;
        db.route = "T42";
        db.station = "Atanasio Girardot";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 10;
        db.route = "T47A";
        db.station = "Atanasio Girardot";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 11;
        db.route = "T47B";
        db.station = "Atanasio Girardot";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 12;
        db.route = "T40";
        db.station = "Belalcazar";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 13;
        db.route = "T42";
        db.station = "Belalcazar";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 14;
        db.route = "T47A";
        db.station = "Belalcazar";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 15;
        db.route = "T47B";
        db.station = "Belalcazar";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 16;
        db.route = "T31";
        db.station = "Buitrera";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 17;
        db.route = "T31";
        db.station = "Caldas";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 18;
        db.route = "T47A";
        db.station = "Caldas";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 19;
        db.route = "T57A";
        db.station = "Canaveralejo";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 20;
        db.route = "T31";
        db.station = "Capri";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 21;
        db.route = "T47A";
        db.station = "Capri";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 22;
        db.route = "T31";
        db.station = "Centro";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 23;
        db.route = "T40";
        db.station = "Centro";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 24;
        db.route = "T42";
        db.station = "Centro";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 25;
        db.route = "T50";
        db.station = "Centro";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 26;
        db.route = "T40";
        db.station = "Chapinero";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 27;
        db.route = "T42";
        db.station = "Chapinero";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 28;
        db.route = "T47A";
        db.station = "Chapinero";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 29;
        db.route = "T47B";
        db.station = "Chapinero";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 30;
        db.route = "T31";
        db.station = "Chiminangos";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 31;
        db.route = "T50";
        db.station = "Cien Palos";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 32;
        db.route = "T57A";
        db.station = "Cien Palos";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 33;
        db.route = "T50";
        db.station = "Conquistadores";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 34;
        db.route = "T57A";
        db.station = "Conquistadores";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 35;
        db.route = "T31";
        db.station = "Ermita";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 36;
        db.route = "T40";
        db.station = "Ermita";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 37;
        db.route = "T42";
        db.station = "Ermita";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 38;
        db.route = "T50";
        db.station = "Ermita";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 39;
        db.route = "T31";
        db.station = "Estadio";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 40;
        db.route = "T47A";
        db.station = "Estadio";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 41;
        db.route = "T47B";
        db.station = "Estadio";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 42;
        db.route = "T57A";
        db.station = "Estadio";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 43;
        db.route = "T31";
        db.station = "Fatima";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 44;
        db.route = "T31";
        db.station = "Flora Industrial";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 45;
        db.route = "T42";
        db.station = "Floresta";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 46;
        db.route = "T47A";
        db.station = "Floresta";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 47;
        db.route = "T47B";
        db.station = "Floresta";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 48;
        db.route = "T31";
        db.station = "Fray Damian";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 49;
        db.route = "T40";
        db.station = "Fray Damian";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 50;
        db.route = "T42";
        db.station = "Fray Damian";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 51;
        db.route = "T50";
        db.station = "Fray Damian";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 52;
        db.route = "T31";
        db.station = "Lido";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 53;
        db.route = "T47A";
        db.station = "Lido";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 54;
        db.route = "T47B";
        db.station = "Lido";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 55;
        db.route = "T57A";
        db.station = "Lido";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 56;
        db.route = "T31";
        db.station = "Manzana del Saber";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 57;
        db.route = "T47A";
        db.station = "Manzana del Saber";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 58;
        db.route = "T47B";
        db.station = "Manzana del Saber";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 59;
        db.route = "T57A";
        db.station = "Manzana del Saber";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 60;
        db.route = "T31";
        db.station = "Manzanares";
        id_db = repoStation.insert(db);


        db = new StationDB();
        db.id_table = 61;
        db.route = "T31";
        db.station = "Melendez";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 62;
        db.route = "T40";
        db.station = "Nueva Floresta";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 63;
        db.route = "T50";
        db.station = "Nuevo Latir";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 64;
        db.route = "T57A";
        db.station = "Nuevo Latir";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 65;
        db.route = "T31";
        db.station = "Pampalinda";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 66;
        db.route = "T47A";
        db.station = "Pampalinda";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 67;
        db.route = "T40";
        db.station = "Petecuy";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 68;
        db.route = "T42";
        db.station = "Petecuy";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 69;
        db.route = "T50";
        db.station = "Petecuy";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 70;
        db.route = "T31";
        db.station = "Plaza de Toros";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 71;
        db.route = "T31";
        db.station = "Popular";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 72;
        db.route = "T57A";
        db.station = "Primitivo";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 73;
        db.route = "T50";
        db.station = "Primitivo";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 74;
        db.route = "T31";
        db.station = "Refugio";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 75;
        db.route = "T47A";
        db.station = "Refugio";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 76;
        db.route = "T31";
        db.station = "Salomia";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 77;
        db.route = "T31";
        db.station = "San Bosco";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 78;
        db.route = "T47A";
        db.station = "San Bosco";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 79;
        db.route = "T47B";
        db.station = "San Bosco";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 80;
        db.route = "T57A";
        db.station = "San Bosco";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 81;
        db.route = "T40";
        db.station = "San Pascual";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 82;
        db.route = "T47A";
        db.station = "San Pascual";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 83;
        db.route = "T47B";
        db.station = "San Pascual";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 84;
        db.route = "T57A";
        db.station = "San Pascual";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 85;
        db.route = "T40";
        db.station = "San Pedro";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 86;
        db.route = "T42";
        db.station = "San Pedro";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 87;
        db.route = "T50";
        db.station = "San Pedro";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 88;
        db.route = "T31";
        db.station = "Santa Librada";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 89;
        db.route = "T47A";
        db.station = "Santa Librada";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 90;
        db.route = "T47B";
        db.station = "Santa Librada";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 91;
        db.route = "T57A";
        db.station = "Santa Librada";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 92;
        db.route = "T50";
        db.station = "Santa Monica";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 93;
        db.route = "T57A";
        db.station = "Santa Monica";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 94;
        db.route = "T40";
        db.station = "Sucre";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 95;
        db.route = "T31";
        db.station = "Tequendama";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 96;
        db.route = "T47A";
        db.station = "Tequendama";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 97;
        db.route = "T47B";
        db.station = "Tequendama";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 98;
        db.route = "T57A";
        db.station = "Tequendama";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 99;
        db.route = "T31";
        db.station = "Torre de Cali";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 100;
        db.route = "T40";
        db.station = "Trebol";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 101;
        db.route = "T47B";
        db.station = "Trebol";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 102;
        db.route = "T50";
        db.station = "Trebol";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 103;
        db.route = "T57A";
        db.station = "Troncal Unida";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 104;
        db.route = "T31";
        db.station = "Unidad Deportiva";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 105;
        db.route = "T47A";
        db.station = "Unidad Deportiva";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 106;
        db.route = "T47B";
        db.station = "Unidad Deportiva";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 107;
        db.route = "T31";
        db.station = "Univalle";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 108;
        db.route = "T31";
        db.station = "Universidades";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 109;
        db.route = "T42";
        db.station = "Versalles";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 110;
        db.route = "T40";
        db.station = "Villa Colombia";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 111;
        db.route = "T42";
        db.station = "Villa Colombia";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 112;
        db.route = "T47A";
        db.station = "Villa Colombia";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 113;
        db.route = "T47B";
        db.station = "Villa Colombia";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 114;
        db.route = "T57A";
        db.station = "Villa Nueva";
        id_db = repoStation.insert(db);

        db = new StationDB();
        db.id_table = 115;
        db.route = "T50";
        db.station = "Villa Nueva";
        id_db = repoStation.insert(db);

    }
}
