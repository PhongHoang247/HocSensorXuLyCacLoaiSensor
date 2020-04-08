package com.phong.hocsensorxulycacloaisensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class SensorTemperatureActivity extends AppCompatActivity
    implements SensorEventListener
{
    TextView txtData;
    //SensorManager dùng để truy suất thiết bị phần cứng:
    SensorManager sensorManager;
    //Kiểm tra một Sensor cụ thể nào đó:
    Sensor sensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_temperature);
        txtData = findViewById(R.id.txtData);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //Lấy sensor ra:
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Đăng ký lắng nghe một cách tự động cái sensor này vào hệ thống phần mềm:
        sensorManager.registerListener(
                this,//màn hình hiện tại đang implements SensorEventListener
                sensor,//đăng ký sensor để lắng nghe thay đổi tự động nhảy vào onSensorChanged
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this,sensor);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //Lấy giá trị trong hàm này: lấy giá trị phụ thuộc vào sensor chúng ta truyền loại nào
        if (sensor == null || sensorEvent.sensor.getType() != Sensor.TYPE_AMBIENT_TEMPERATURE){
            return;
        }
        txtData.setText("Power = " + sensorEvent.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
