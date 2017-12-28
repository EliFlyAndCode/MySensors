package com.dolinsek.elias.mysensors;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SensorsActivity extends AppCompatActivity {

    private RecyclerView rvSensors;
    private SensorsAdapter sensorsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        rvSensors = (RecyclerView) findViewById(R.id.rv_sensors);
        rvSensors.setHasFixedSize(false);

        //Get all available Sensors
        SensorManager sensorManager = getSystemService(SensorManager.class);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        //Creates Adapter and displays Items
        sensorsAdapter = new SensorsAdapter(sensors);
        rvSensors.setAdapter(sensorsAdapter);
        rvSensors.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}
