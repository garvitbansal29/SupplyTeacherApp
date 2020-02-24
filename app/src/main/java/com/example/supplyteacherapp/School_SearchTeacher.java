package com.example.supplyteacherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class School_SearchTeacher extends AppCompatActivity {
    Database database = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school__search_teacher);
    }

    public void onclickBtn(View view)
    {
        database.getTeachersBySubjects("Science");
    }
}
