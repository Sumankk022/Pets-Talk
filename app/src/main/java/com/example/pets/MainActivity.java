package com.example.pets;

//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button btn,submit;
    TextView registerbtn;
    TextInputLayout username,password;

    FirebaseDatabase database;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.submitbtn);
        registerbtn = findViewById(R.id.registerbtn);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.submitbtn);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationPage.class);
                startActivity(intent);
            }
        });
        }

    private Boolean validateusername(){
        String val = username.getEditText().getText().toString();

        if(val.isEmpty()){
            username.setError("Should not be empty");
            return false;
        }
        else{
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validatepassword(){
        String val = password.getEditText().getText().toString();
        if(val.isEmpty()){
            password.setError("Should not be empty");
            return false;
        }
        else{
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    public  void loginUser(View view){
        if(!validateusername() | !validatepassword()){
            return;
        }
        else {
//            Toast.makeText(MainActivity.this,"Logged in Successfullu",Toast.LENGTH_SHORT);
           isUser();
        }
    }

    public void isUser() {

        String userEnteredusername = username.getEditText().getText().toString();
        String userEnteredPassword = password.getEditText().getText().toString();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        Query checkUser = reference.orderByChild("username").equalTo(userEnteredusername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                if(datasnapshot.exists()){
                    username.setError(null);
                    username.setErrorEnabled(false);

                    String passwordFromDB = datasnapshot.child(userEnteredusername).child("password").getValue(String.class);
                    if(passwordFromDB.equals(userEnteredPassword)){

                        username.setError(null);
                        username.setErrorEnabled(false);

                        String breedFromDB = datasnapshot.child(userEnteredusername).child("breed").getValue(String.class);
                        String ownernameFromDB = datasnapshot.child(userEnteredusername).child("ownername").getValue(String.class);
                        String petnameFromDB = datasnapshot.child(userEnteredusername).child("petname").getValue(String.class);
                        String usernameFromDB = datasnapshot.child(userEnteredusername).child("username").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext(),UserProfile.class);
                        intent.putExtra("petname",petnameFromDB);
                        intent.putExtra("ownername",ownernameFromDB);
                        intent.putExtra("breed",breedFromDB);
                        intent.putExtra("username",usernameFromDB);
                        intent.putExtra("password",passwordFromDB);

                        startActivity(intent);

                    }
                    else {
                        password.setError("Wrong Password");
                        password.requestFocus();
                    }

                }
                else {
                    username.setError("No such user exists");
                    username.requestFocus();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    }