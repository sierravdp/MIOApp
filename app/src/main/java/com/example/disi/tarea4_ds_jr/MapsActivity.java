package com.example.disi.tarea4_ds_jr;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    StationsRepo repoStation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        repoStation = new StationsRepo(this);
        addingDBStations();

        setUpMapIfNeeded();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        //mMap.addMarker(new MarkerOptions().position(new LatLng(3.44523464188041,-76.4870411406343)).title("Marker"));

        for (int j = 0; j < 5; j++) {
            //Stations temp_data = repoStation.getStationById(j);
            mMap.addMarker(new MarkerOptions().position(new LatLng(3.44523464188041,-76.4870411406343)).title("Marker"));
        }
    }


    public void addingDBStations(){
        int id_db = 0;

        Stations db = new Stations();
        db.id_table = 0;
        db.station = "7 de Agosto";
        db.latitude = 3.44523464188041;
        db.longitude = -76.4870411406343;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 1;
        db.station = "Amanecer";
        db.latitude = 3.42149723638614;
        db.longitude = -76.49082236025571;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 2;
        db.station = "Andres Sanin";
        db.latitude = 3.443676;
        db.longitude = -76.482895;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 3;
        db.station = "Atanasio Girardot";
        db.latitude = 3.44476595957726;
        db.longitude = -76.50830906902679;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 4;
        db.station = "Belalcazar";
        db.latitude = 3.44409815874867;
        db.longitude = -76.5207278165045;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 5;
        db.station = "Buitrera";
        db.latitude = 3.37262876258088;
        db.longitude = -76.54024624286779;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 6;
        db.station = "Caldas";
        db.latitude = 3.39401659279584;
        db.longitude = -76.5459972419974;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 7;
        db.station = "Canaveralejo";
        db.latitude = 3.41492829303904;
        db.longitude = -76.54837045263621;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 8;
        db.station = "Capri";
        db.latitude = 3.38795695349308;
        db.longitude = -76.5449883163955;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 9;
        db.station = "Centro";
        db.latitude = 3.44836264398911;
        db.longitude = -76.5301188719535;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 10;
        db.station = "Chapinero";
        db.latitude = 3.44423939404206;
        db.longitude = -76.5022544886063;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 11;
        db.station = "Chiminangos";
        db.latitude = 3.48143405288254;
        db.longitude = -76.4982579940595;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 12;
        db.station = "Cien Palos";
        db.latitude = 3.43979914576278;
        db.longitude = -76.52280156467729;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 13;
        db.station = "Conquistadores";
        db.latitude = 3.42705826159966;
        db.longitude = -76.50527434923011;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 14;
        db.station = "Ermita";
        db.latitude = 3.45333507350132;
        db.longitude = -76.53162400177921;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 15;
        db.station = "Estadio";
        db.latitude = 3.431802795938561;
        db.longitude = -76.5431741642292;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 16;
        db.station = "Fatima";
        db.latitude = 3.46285094798705;
        db.longitude = -76.51740387904771;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 17;
        db.station = "Flora Industrial";
        db.latitude = 3.47823457936227;
        db.longitude = -76.5022346527039;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 18;
        db.station = "Floresta";
        db.latitude = 3.44521141377815;
        db.longitude = -76.5146061101468;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 19;
        db.station = "Fray Damian";
        db.latitude = 3.4435703997969;
        db.longitude = -76.52885848603231;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 20;
        db.station = "Lido";
        db.latitude = 3.41871945631514;
        db.longitude = -76.548374742654;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 21;
        db.station = "Manzana del Saber";
        db.latitude = 3.43489067250909;
        db.longitude = -76.54099583876049;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 22;
        db.station = "Manzanares";
        db.latitude = 3.46618818350395;
        db.longitude = -76.5133312020867;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 23;
        db.station = "Melendez";
        db.latitude = 3.37709434798511;
        db.longitude = -76.5428460692729;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 24;
        db.station = "Nueva Floresta";
        db.latitude = 3.44521141377815;
        db.longitude = -76.5146061101468;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 25;
        db.station = "Nuevo Latir";
        db.latitude = 3.41839981529759;
        db.longitude = -76.48677604983369;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 26;
        db.station = "Pampalinda";
        db.latitude = 3.40377726014038;
        db.longitude = -76.5468542348675;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 27;
        db.station = "Petecuy";
        db.latitude = 3.44898657047256;
        db.longitude = -76.52796712272369;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 28;
        db.station = "Plaza de Toros";
        db.latitude = 3.40958233506524;
        db.longitude = -76.5474894108108;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 29;
        db.station = "Popular";
        db.latitude = 3.46950131877958;
        db.longitude = -76.51081381344569;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 30;
        db.station = "Primitivo";
        db.latitude = 3.43799354301463;
        db.longitude = -76.5185793986675;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 31;
        db.station = "Refugio";
        db.latitude = 3.39861277628475;
        db.longitude = -76.54650977859809;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 32;
        db.station = "Salomia";
        db.latitude = 3.47372798499137;
        db.longitude = -76.5067104642302;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 33;
        db.station = "San Bosco";
        db.latitude = 3.44222168983151;
        db.longitude = -76.5325616246673;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 34;
        db.station = "San Pascual";
        db.latitude = 3.44260549824147;
        db.longitude = -76.527396508869;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 35;
        db.station = "San Pedro";
        db.latitude = 3.45434310944934;
        db.longitude = -76.5301501351538;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 36;
        db.station = "Santa Librada";
        db.latitude = 3.43975464363334;
        db.longitude = -76.537058966723;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 37;
        db.station = "Santa Monica";
        db.latitude = 3.43456927203524;
        db.longitude = -76.51391209829779;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 38;
        db.station = "Sucre";
        db.latitude = 3.443472550432289;
        db.longitude = -76.526306577727;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 39;
        db.station = "Tequendama";
        db.latitude = 3.4233818555796;
        db.longitude = -76.5470481478424;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 40;
        db.station = "Torre de Cali";
        db.latitude = 3.45678873806534;
        db.longitude = -76.5302392220113;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 41;
        db.station = "Trebol";
        db.latitude = 3.44348135196042;
        db.longitude = -76.49603170797231;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 42;
        db.station = "Troncal Unida";
        db.latitude = 3.42476413603906;
        db.longitude = -76.4945829472987;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 43;
        db.station = "Unidad Deportiva";
        db.latitude = 3.41492829303904;
        db.longitude = -76.54837045263621;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 44;
        db.station = "Univalle";
        db.latitude = 3.37077428856125;
        db.longitude = -76.5367578041884;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 45;
        db.station = "Universidades";
        db.latitude = 3.36695700838631;
        db.longitude = -76.52916622926629;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 46;
        db.station = "Versalles";
        db.latitude = 3.46120677962967;
        db.longitude = -76.52703055257329;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 47;
        db.station = "Villa Colombia";
        db.latitude = 3.443804374789599;
        db.longitude = -76.49887564301871;
        id_db = repoStation.insert(db);

        db = new Stations();
        db.id_table = 48;
        db.station = "Villa Nueva";
        db.latitude = 3.443804374789599;
        db.longitude = -76.49887564301871;
        id_db = repoStation.insert(db);

    }

}
