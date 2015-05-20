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


public class Routes extends ActionBarActivity {

    public int dbFull = 0;
    RoutesRepo repo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repo = new RoutesRepo(this);

        //if (dbFull == 0){
            addingDataDB();
            //dbFull ++;
        //}

        setContentView(R.layout.activity_routes);
        initializingTextLayout();
        addingDataTextLayout();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_routes, menu);
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

    public void goToDetails(View view){
        Intent ex = new Intent(this,Details.class);
        startActivity(ex);
    }

    public void initializingTextLayout(){
        //adding in table the description menu
        TableLayout tableview = (TableLayout) findViewById(R.id.tableRoutes);
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

        for (int j = 0; j < 2; j++) {
            TextView Values = new TextView(this);
            Values.setPadding(15, 0, 15, 0);
            Values.setGravity(Gravity.CENTER);
            Values.setTextSize(25.0f);
            Values.setTextColor(Color.parseColor("#FFFFFF"));
            Values.setTypeface(null, Typeface.BOLD);

            if (j == 0){
                Values.setText("Punto partida");
            }
            else if(j == 1){
                Values.setText("Punto llegada");
            }

            row.addView(Values);
        }
        tableview.addView(row);
    }

    public void addingDataTextLayout(){

        final TableLayout tableview = (TableLayout) findViewById(R.id.tableRoutes);
        tableview.setPadding(15, 3, 15, 3);

        for (int i = 0; i < 7; i++) {
            database temp_data = repo.getRouteById(i);

            TableRow row = new TableRow(this);

            TableLayout.LayoutParams lp = new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            row.setPadding(15, 3, 15, 3);

            row.setBackgroundColor(Color.parseColor("#0000FF"));

            TextView Header = new TextView(this);

            Header.setGravity(Gravity.CENTER);
            Header.setText(temp_data.routeName);
            Header.setTextSize(30.0f);
            Header.setPadding(15, 0, 15, 0);
            Header.setTextColor(Color.parseColor("#FFFFFF"));
            Header.setTypeface(null, Typeface.BOLD);

            row.addView(Header);

            for (int j = 0; j < 2; j++) {
                TextView Values = new TextView(this);
                Values.setPadding(15, 0, 15, 0);
                Values.setGravity(Gravity.CENTER);
                Values.setTextSize(30.0f);
                Values.setTextColor(Color.parseColor("#FFFFFF"));
                Values.setTypeface(null, Typeface.BOLD);

                if (j == 0){
                    Values.setText(temp_data.init);
                }
                else if(j == 1){
                    Values.setText(temp_data.finalR);
                }

                row.addView(Values);

                final View row1=tableview.getChildAt(i);
                row1.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v){
                        // TODO Auto-generated method stub
                        int row_id=tableview.indexOfChild(row1);
                        Intent ex = new Intent(Routes.this,Details.class);
                        ex.putExtra("EXTRA_SESSION_ID", row_id);
                        startActivity(ex);
                    }
                });
            }
            tableview.addView(row);


        }

        tableview.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent details = new Intent(Routes.this, Details.class);
                //i.putExtra("Product_Name",tableview.getText().toString());
                startActivity(details);
            }
        });
    }

    public void goToMaps(View view){
        Intent ex = new Intent(this,MapsActivity.class);
        //EditText text2 = new EditText(findViewById("R.id.text1"));

        //String xx = text2.getText().toString();
        startActivity(ex);
    }

    public void addingDataDB(){

        int id_db = 0;

        database db = new database();
        db.routeID= 0;
        db.routeName="T31";
        db.init="Chiminangos";
        db.finalR="Universidades";
        db.sentido="0";
        id_db= repo.insert(db);

        db.routeID= 1;
        db.routeName="T40";
        db.init="Andres Sanin";
        db.finalR="Centro";
        db.sentido="0";
        id_db= repo.insert(db);

        db.routeID= 2;
        db.routeName="T57A";
        db.init="Nuevo Latir";
        db.finalR="Unidad Deportiva";
        db.sentido="0";
        id_db= repo.insert(db);

        db.routeID= 3;
        db.routeName="T47B";
        db.init="Andres Sanin";
        db.finalR="Unidad Deportiva";
        db.sentido="0";
        id_db= repo.insert(db);

        db.routeID= 4;
        db.routeName="T47A";
        db.init="Andres Sanin";
        db.finalR="Capri";
        db.sentido="0";
        id_db= repo.insert(db);

        db.routeID= 5;
        db.routeName="T50";
        db.init="Nuevo Latir";
        db.finalR="Centro";
        db.sentido="0";
        id_db= repo.insert(db);

        db.routeID= 6;
        db.routeName="T42";
        db.init="Andres Sanin";
        db.finalR="Centro";
        db.sentido="0";
        id_db= repo.insert(db);
    }


}
