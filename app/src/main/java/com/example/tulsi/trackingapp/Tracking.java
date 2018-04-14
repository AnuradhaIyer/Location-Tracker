package com.example.tulsi.trackingapp;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.mock.MockPackageManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Tracking extends AppCompatActivity {

    private Button btnShowLocation,btnshowMap;
    FirebaseDatabase database;
    DatabaseReference myRef;

    private static final  int REQUEST_CODE_PERMISSION =2;
    String mPermission = android.Manifest.permission.ACCESS_FINE_LOCATION;
    GPSTracker gps;
    TextView location;
    String value =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);

        try{
            if (ActivityCompat.checkSelfPermission(this,mPermission)!= MockPackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{mPermission},REQUEST_CODE_PERMISSION);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        btnShowLocation=(Button)findViewById(R.id.button);
        btnshowMap=(Button)findViewById(R.id.button2);
        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gps = new GPSTracker(Tracking.this);
                location=(TextView)findViewById(R.id.Location);
                if (gps.canGetLocation()){
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    database = FirebaseDatabase.getInstance();
                    location.setText(latitude+""+longitude);
                    myRef = database.getReference("Location");
                    myRef.setValue(latitude+","+longitude);
                }else{
                    gps.showSettingsAlert();
                }
            }

        });
    }

    public void Map(View view){


        Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(intent);
    }
}
