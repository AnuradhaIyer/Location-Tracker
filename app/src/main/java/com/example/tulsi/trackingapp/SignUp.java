package com.example.tulsi.trackingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {


    private EditText nameField;
    private EditText emailField;
    private EditText passField;
    private EditText confirmPass;
    private EditText parentEmail;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        nameField=(EditText)findViewById(R.id.field_name);
        emailField=(EditText)findViewById(R.id.field_email);
        passField=(EditText)findViewById(R.id.field_password);
        confirmPass=(EditText)findViewById(R.id.field_password_confirmation);
        parentEmail=(EditText)findViewById(R.id.field_parent_email);
        myRef=FirebaseDatabase.getInstance().getReference().child("Users");
    }

        public void signupButtonClicked(View view){

        final String name=nameField.getText().toString().trim();
        final String email=emailField.getText().toString().trim();
        final String passsword=passField.getText().toString().trim();
        final String confirmpassword=confirmPass.getText().toString().trim();
        String parentemail=parentEmail.getText().toString().trim();

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(passsword) && !TextUtils.isEmpty(confirmpassword) && !TextUtils.isEmpty(parentemail)){


            mAuth.createUserWithEmailAndPassword(email,passsword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful()){
                   String user_id=mAuth.getCurrentUser().getUid();
                   DatabaseReference current_user_db= myRef.child(user_id);
                   current_user_db.child("Name").setValue(name);
                   current_user_db.child("image").setValue("default");
                   Intent mainIntent = new Intent(SignUp.this,SignInActivity.class);
                   mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                   startActivity(mainIntent);
               }
                }
            });
        }


        }
}
