package com.example.tulsi.trackingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
    }

    public void onShareLocClick(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }


    public void onProfileClick(View view) {
        Intent intent=new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
}



