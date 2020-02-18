package com.example.supplyteacherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SchoolSignin extends AppCompatActivity {

    Database database = new Database(this);

    String email, password;
    EditText emailEditTxt, passwordEditTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_signin);

        emailEditTxt = findViewById(R.id.email_field);
        passwordEditTxt = findViewById(R.id.password_field);
    }

    public void schoolRegisterTextClick (View view)
    {
        startActivity(new Intent(this, SchoolRegister.class));
    }

    public void signInBtnClick(View view)
    {
        email = emailEditTxt.getText().toString();
        password  = passwordEditTxt.getText().toString();
        database.signinUser(email, password, SchoolHome.class);
//        startActivity(new Intent(this, SchoolHome.class));

    }
}
