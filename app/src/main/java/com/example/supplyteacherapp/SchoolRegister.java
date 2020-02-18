package com.example.supplyteacherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SchoolRegister extends AppCompatActivity {

    String email, password;
    EditText emailEditTxt, passwordEditTxt;
    Button registerBtn;

    Database database = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_register);


        emailEditTxt = (EditText) findViewById(R.id.email_field);
        passwordEditTxt = (EditText) findViewById(R.id.password_field);
        registerBtn = (Button) findViewById(R.id.teacher_register_btn);

    }

    public void registerSchoolOnClick(View view)
    {
        email = emailEditTxt.getText().toString();
        password = passwordEditTxt.getText().toString();
        database.registerNewUser(email, password);
        startActivity(new Intent(this, SchoolRegisterDetail.class));

    }


}
