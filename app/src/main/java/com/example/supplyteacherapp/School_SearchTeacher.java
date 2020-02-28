package com.example.supplyteacherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.maps.errors.ApiException;

import java.io.IOException;
import java.util.ArrayList;

public class School_SearchTeacher extends AppCompatActivity {
    TeacherDB teacherDb = new TeacherDB();
    DistanceCalculator distance = new DistanceCalculator();

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

        teacherDb.getAllTeachers(new OnGetTeacherDataListener() {
            @Override
            public void onSuccessTeacherID(ArrayList<String> teacherIDs) {

            }

            @Override
            public void onSuccessTeacherObj(ArrayList<TeacherAccount> teacherAccount) {
                System.out.println("There are this many  teachers ___ " + teacherAccount.size());

            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure() {

            }
        });

    }


    public void button2Click(View view)
    {
        try {
            double dist = distance.getDrivingDist("sk7 3nb", "sk7 2jt");
            System.out.println(dist);
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        teacherDb.getTeacherInRadius("sk7 3nb", 1, new OnGetTeacherDataListener() {
            @Override
            public void onSuccessTeacherID(ArrayList<String> teacherIDs) {

            }

            @Override
            public void onSuccessTeacherObj(ArrayList<TeacherAccount> teacherAccount) {

                System.out.println("this is how many teachers are in area right now " + teacherAccount.size());

            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure() {

            }
        });
//

    }

}
