package com.example.supplyteacherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class School_SearchTeacher extends AppCompatActivity {
    TeacherDB teacherDb = new TeacherDB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school__search_teacher);
    }

    public void onclickBtn(View view)
    {



        teacherDb.getTeacherObjsBySubject("mathematics", new OnGetTeacherDataListener() {
            @Override
            public void onSuccessTeacherID(ArrayList<String> teacherIDs) {

            }

            @Override
            public void onSuccessTeacherObj(ArrayList<TeacherAccount> teacherAccount) {
                for (TeacherAccount t : teacherAccount)
                {
                    System.out.println(t.getAccountName());
                }
            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure() {

            }
        });

        teacherDb.getTeacherObjsByYearsOfExperience(5454, new OnGetTeacherDataListener() {
            @Override
            public void onSuccessTeacherID(ArrayList<String> teacherIDs) {

            }

            @Override
            public void onSuccessTeacherObj(ArrayList<TeacherAccount> teacherAccount) {
                System.out.println(teacherAccount.size());
            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure() {

            }
        });
        teacherDb.getTeacherObjsByDrivingLicense(true, new OnGetTeacherDataListener() {
            @Override
            public void onSuccessTeacherID(ArrayList<String> teacherIDs) {

            }

            @Override
            public void onSuccessTeacherObj(ArrayList<TeacherAccount> teacherAccount) {
                System.out.println(teacherAccount.size() + " have Driving License");
            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure() {

            }
        });

    }

}
