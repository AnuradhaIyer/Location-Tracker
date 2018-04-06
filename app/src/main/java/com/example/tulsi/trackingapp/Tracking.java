package com.example.tulsi.trackingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tracking extends AppCompatActivity {

    private Button Track;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);
        Track=(Button)findViewById(R.id.button_start_tracking);
    }

    public void Tracking(View view){


        Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(intent);
    }
}
