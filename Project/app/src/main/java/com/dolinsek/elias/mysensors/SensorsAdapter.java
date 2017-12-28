package com.dolinsek.elias.mysensors;

import android.content.Intent;
import android.hardware.Sensor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by elias on 27.12.2017.
 */

public class SensorsAdapter extends RecyclerView.Adapter<SensorsAdapter.SensorListViewHolder>{

    public static final String SENSOR_TAG = "sensor";
    private List<Sensor> sensors;

    public SensorsAdapter(List<Sensor> sensors){
        this.sensors = sensors;
    }

    @Override
    public SensorListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemViewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sensor, parent, false);
        return new SensorListViewHolder(itemViewHolder);
    }

    @Override
    public void onBindViewHolder(final SensorListViewHolder holder, final int position) {
        //Display infos
        holder.getTvSensorName().append(": " + sensors.get(position).getName());
        holder.getTvSensorFactory().append(": " + sensors.get(position).getVendor());
        holder.getTvSensorVersion().append(": " + sensors.get(position).getVersion());
        holder.getTvSensorCategory().append(": " + sensors.get(position).getStringType());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Start DetailsActivity
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                //Put selected sensor into extras
                intent.putExtra(SENSOR_TAG, position);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sensors.size();
    }

    public class SensorListViewHolder extends RecyclerView.ViewHolder{

        private TextView tvSensorName, tvSensorFactory, tvSensorVersion, tvSensorCategory;

        public SensorListViewHolder(View view) {
            super(view);

            tvSensorName = (TextView) view.findViewById(R.id.tv_sensor_name);
            tvSensorFactory = (TextView) view.findViewById(R.id.tv_sensor_manufacture);
            tvSensorVersion = (TextView) view.findViewById(R.id.tv_sensor_version);
            tvSensorCategory = (TextView) view.findViewById(R.id.tv_sensor_category);
        }

        public TextView getTvSensorName() {
            return tvSensorName;
        }

        public TextView getTvSensorFactory() {
            return tvSensorFactory;
        }

        public TextView getTvSensorVersion() {
            return tvSensorVersion;
        }

        public TextView getTvSensorCategory() {
            return tvSensorCategory;
        }
    }
}
