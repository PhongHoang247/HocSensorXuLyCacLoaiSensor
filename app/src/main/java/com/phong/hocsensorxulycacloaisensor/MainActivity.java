package com.phong.hocsensorxulycacloaisensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Xử lý Sensor nhiệt độ
    public void xuLySensorTemperature(View view) {
        Intent intent = new Intent(MainActivity.this,SensorTemperatureActivity.class);
        startActivity(intent);
    }

    //Xử lý Sensor gia tốc
    public void xuLySensorAccelerometer(View view) {
        Intent intent = new Intent(MainActivity.this,SensorAccelerometerActivity.class);
        startActivity(intent);
    }

    //Xử lý Sensor ánh sáng
    public void xuLySensorLight(View view) {
        Intent intent = new Intent(MainActivity.this,SensorLightActivity.class);
        startActivity(intent);
    }
}
