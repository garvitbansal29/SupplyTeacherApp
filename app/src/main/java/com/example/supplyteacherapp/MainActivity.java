package com.example.supplyteacherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void schoolButtonClick(View view)
    {
        startActivity(new Intent(this, SchoolSignin.class));


    }
    public void teacherButtonClick(View view)
    {
        startActivity(new Intent(this, TeacherSignin.class));

    }
}
