package com.example.accelerometer;

/**With contributions from https://developer.android.com/reference/android/hardware/SensorManager.html
 * */

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReadAccelerometer extends AppCompatActivity implements SensorEventListener{
    private SensorManager sm;
    private Sensor mAccelerometer;

    private TextView viewX;
    private TextView viewY;
    private TextView viewZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Accelerometer");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_accelerometer); //set layout

        sm = (SensorManager)getSystemService(SENSOR_SERVICE); //access device sensors
        mAccelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        viewX = (TextView) findViewById(R.id.textViewX); //fetch html elements
        viewY = (TextView) findViewById(R.id.textViewY);
        viewZ = (TextView) findViewById(R.id.textViewZ);

        viewX.setText("X: ");
        viewY.setText("Y: ");
        viewZ.setText("Z: ");
    }

    protected void onResume() {
        super.onResume();
        sm.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    /**When sensor discovers a change, it will update the text view objects in the view*/
    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor mySensor = event.sensor;

        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            viewX.setText("X: " + x);
            viewY.setText("Y: " + y);
            viewZ.setText("Z: " + z);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
