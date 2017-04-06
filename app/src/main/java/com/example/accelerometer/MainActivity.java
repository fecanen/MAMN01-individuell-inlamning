package com.example.accelerometer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Choose one activity");
    }

    public void readAccelerometer(View view) {
        Intent intent = new Intent(this, ReadAccelerometer.class); //loads the ReadAccelerometer class
        startActivity(intent); //start this action
    }

    public void compass(View view) {
        Intent intent = new Intent(this, Compass.class); //loads the ReadAccelerometer class
        startActivity(intent); //start this action
    }
}
