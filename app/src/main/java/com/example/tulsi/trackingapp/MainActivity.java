package com.example.tulsi.trackingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Button mSignInButton;
    private Button mSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSignInButton = findViewById(R.id.button_sign_in);
        mSignUpButton = findViewById(R.id.button_sign_up);

    }
    public void Signin(View view)
    {
        Intent intent=new Intent(getApplicationContext(),SignInActivity.class);
        startActivity(intent);

    }

    public void Signup(View view)
    {
        Intent intent=new Intent(getApplicationContext(),SignUp.class);
        startActivity(intent);

    }
}



