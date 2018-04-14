package com.example.tulsi.trackingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignInActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private EditText emailText,passText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        emailText = (EditText) findViewById(R.id.username);
        passText = (EditText) findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {


                if (firebaseAuth.getCurrentUser() != null) {

                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(intent);

                } /*else if (firebaseAuth.getCurrentUser() == null) {

                    Intent intent = new Intent(getApplicationContext(), SignUp.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);


                }*/
            }

            ;


        };
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mAuth.addAuthStateListener(authStateListener);
    }



    public void loginButton(View view){
        String email= emailText.getText().toString().trim();
        String pass = passText.getText().toString().trim();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass) ){


            Toast.makeText(this,"Enter both values",Toast.LENGTH_LONG).show();
        }
            else
        {
            mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
               if (task.isSuccessful()){

                   // checkUserExists();

                  // Toast.makeText(SignInActivity.this,"Incorrect Username or Password",Toast.LENGTH_LONG).show();
               }
                }
            });
        }

    }


}

