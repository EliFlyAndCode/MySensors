package com.dolinsek.elias.mysensors;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    private static final int NO_VALUE = -1;
    private TextView tvDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvDetails = (TextView) findViewById(R.id.tv_details);

        //Get list of all available sensors
        SensorManager sensorManager = getSystemService(SensorManager.class);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        Sensor sensorDetails = null;

        Intent intent = getIntent();
        if(intent.hasExtra(SensorsAdapter.SENSOR_TAG)){
            int sensor = intent.getIntExtra(SensorsAdapter.SENSOR_TAG, NO_VALUE);
            if(sensor == NO_VALUE){
                tvDetails.setText("An error occoured!");
            } else{
                //Get sensor
                sensorDetails = sensors.get(intent.getIntExtra(SensorsAdapter.SENSOR_TAG, NO_VALUE));

                //Display infos
                tvDetails.append("Name: " + sensorDetails.getName());
                tvDetails.append("\nManufacture: " + sensorDetails.getVendor());
                tvDetails.append("\nVersion: " + sensorDetails.getVersion());
                tvDetails.append("\nType: " + sensorDetails.getStringType());
                tvDetails.append("\nGeneric-Type: " + sensorDetails.getType());
                tvDetails.append("\nMax-Events: " + sensorDetails.getFifoMaxEventCount());
                tvDetails.append("\nMax-Delay: " + sensorDetails.getMaxDelay());
                tvDetails.append("\nMin-Delay: " + sensorDetails.getMinDelay());
                tvDetails.append("\nMax-Range: " + sensorDetails.getMaximumRange());
                tvDetails.append("\nPower: " + sensorDetails.getPower());
                tvDetails.append("\nResolution: " + sensorDetails.getResolution());
            }
        }
    }
}
