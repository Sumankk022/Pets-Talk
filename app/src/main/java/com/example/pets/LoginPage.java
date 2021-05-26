package com.example.pets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class LoginPage extends AppCompatActivity {

    Button btn,submit;
    TextView registerbtn;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        registerbtn = findViewById(R.id.registerbtn);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.submitbtn);

    }

    public void backtoregister(View view){
        Intent intent = new Intent(LoginPage.this,RegistrationPage.class);
        startActivity(intent);
    }
}