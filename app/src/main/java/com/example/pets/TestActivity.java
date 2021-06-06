package com.example.pets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        text = findViewById(R.id.textview);
        showuserdetails();
    }

    private void showuserdetails() {

        Intent intent = getIntent();
        String usernameFromDB = intent.getStringExtra("username");

        text.setText(usernameFromDB);
    }
}