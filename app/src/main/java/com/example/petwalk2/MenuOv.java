package com.example.petwalk2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuOv extends AppCompatActivity {
    Button btn1,btn2;
    SensorManager misensorManager;
    Sensor misensor;
    SensorEventListener milistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ov);

        btn1 =(Button) findViewById(R.id.btnMapa);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(MenuOv.this, MapsB.class);
                MenuOv.this.startActivity(m);
            }
        });

        btn2 = (Button) findViewById(R.id.btnGPS);
        ActivityCompat.requestPermissions(MenuOv.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GPSt g = new GPSt(getApplicationContext());
                Location l = g.getLocation();
                if(l != null){
                    double lat = l.getLatitude();
                    double lon = l.getLongitude();
                    Toast.makeText(getApplicationContext(),"LAT : "+lat+" \n LON : "+lon,Toast.LENGTH_LONG).show();

                }
            }
        });

        misensorManager =(SensorManager)getSystemService(SENSOR_SERVICE);
        misensor= misensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if(misensor == null)
            finish();
        milistener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.values[0]< misensor.getMaximumRange()){
                    getWindow().getDecorView().setBackgroundColor(Color.BLACK);
                }
                else{
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        comenzar();
    }
    public void comenzar(){
        misensorManager.unregisterListener(milistener, misensor);
    }
    public void detener(){
        misensorManager.unregisterListener(milistener);
    }

    @Override
    protected void onPause() {
        detener();
        super.onPause();
    }

    @Override
    protected void onResume() {
        comenzar();
        super.onResume();
    }
}