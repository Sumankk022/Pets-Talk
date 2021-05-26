package com.example.pets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class UserProfile extends AppCompatActivity {

    TextView username,mainpetname,mainusername,petname,ownername,email,password,logoutbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        username = findViewById(R.id.username);
        mainpetname = findViewById(R.id.mainpetname);
        mainusername = findViewById(R.id.mainusername);
        petname = findViewById(R.id.petname);
        ownername = findViewById(R.id.ownername);
        email = findViewById(R.id.ownermail);
        password = findViewById(R.id.password);
        logoutbtn = findViewById(R.id.logoutbtn);

        showAllUserData();
    }

    private void showAllUserData() {

        Intent intent = getIntent();
        String usernameFromDB = intent.getStringExtra("username");
        String petnameFromDB = intent.getStringExtra("petname");
        String ownernameFromDB = intent.getStringExtra("ownername");
        String emailFromDB = intent.getStringExtra("email");
        String passwordFromDB = intent.getStringExtra("password");


        username.setText(usernameFromDB);
        mainusername.setText(usernameFromDB);
        mainpetname.setText(petnameFromDB);
        petname.setText(petnameFromDB);
        ownername.setText(ownernameFromDB);
        email.setText(emailFromDB);
        password.setText(passwordFromDB);


    }

    public void backtologinpage(View v){
        Intent intent = new Intent(UserProfile.this, MainActivity.class);
        startActivity(intent);
    }

}