package com.example.myapplication;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Sensors extends AppCompatActivity implements SensorEventListener{

    private SensorManager mSensorManager;
    private Sensor accelerometer;
    private SensorEventListener listenerAccelerometer;
    float x,y,z,newX,newY,newZ;
    long lastTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        final TextView txtView = (TextView)findViewById(R.id.SensorText);
        //txtView.setVisibility(View.GONE);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        final List<android.hardware.Sensor> mList=mSensorManager.getSensorList(android.hardware.Sensor.TYPE_ALL);

        for (int i = 1; i < mList.size(); i++) {
            txtView.setVisibility(View.VISIBLE);
            txtView.append("\n\n" + mList.get(i).getName() + "\n");
        }

        SensorEventListener lightSensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                int sensor_tipi = event.sensor.getType();
                String sensor_s_tipi = event.sensor.getStringType();
                float[] sensor_verileri = event.values;
                float f = sensor_verileri[0];

                if(f>50){
                    txtView.setTextColor(Color.WHITE);
                    txtView.setBackgroundColor(Color.BLACK);
                }
                else{
                    txtView.setTextColor(Color.BLACK);
                    txtView.setBackgroundColor(Color.WHITE);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        mSensorManager.registerListener(lightSensorListener,mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),mSensorManager.SENSOR_DELAY_NORMAL);


        accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(accelerometer!=null)
        {
            listenerAccelerometer=new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    x=newX;
                    y=newY;
                    z=newZ;

                    newX=event.values[0];
                    newY=event.values[1];
                    newZ=event.values[2];

                    if((x+y+z)-(newX+newY+newZ)!=0){
                        lastTime=event.timestamp;
                    }
                    else{
                        if((event.timestamp-lastTime)/10 > 499999999) {
                            Toast.makeText(Sensors.this, "Closing...", Toast.LENGTH_SHORT).show();
                            mSensorManager.unregisterListener(this);
                            finishAffinity();
                        }
                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {
                }
            };
            mSensorManager.registerListener(listenerAccelerometer,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
