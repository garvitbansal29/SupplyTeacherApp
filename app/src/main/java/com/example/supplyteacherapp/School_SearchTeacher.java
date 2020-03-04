package com.example.supplyteacherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.maps.errors.ApiException;

import java.io.IOException;
import java.util.ArrayList;

public class School_SearchTeacher extends AppCompatActivity {
    TeacherDB teacherDb = new TeacherDB();
    DistanceCalculator distance = new DistanceCalculator();

    EditText subjectInput;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school__search_teacher);

        subjectInput = (EditText) findViewById(R.id.subjectSearch);
        listView = (ListView) findViewById(R.id.myList);
    }

    public void onclickBtn(View view)
    {

        String search = subjectInput.getText().toString();


        teacherDb.getTeacherObjsBySubject(search, new OnGetTeacherDataListener() {
            @Override
            public void onSuccessTeacherID(ArrayList<String> teacherIDs) {

            }

            @Override
            public void onSuccessTeacherObj(ArrayList<TeacherAccount> teacherAccount) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(School_SearchTeacher.this, android.R.layout.simple_expandable_list_item_1, teacherAccount);
                //arrayAdapter.addAll(teacherAccount);
                ArrayList<String> names = new ArrayList<>();
                for (TeacherAccount t : teacherAccount)
                {
                    System.out.println(t.getAccountName());
                    names.add(t.getAccountName() + ", " + t.getTown() + ". " + t.getPostcode());

                }

                arrayAdapter.addAll(names);
                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override       //change the color of the background on selected search result
                    public void onItemClick(AdapterView<?> adpterView, View view, int position, long id) {

                        for (int i = 0; i < listView.getChildCount(); i++) {
                            if(position == i ){
                                listView.getChildAt(i).setBackgroundColor(Color.RED);

                            }else{
                                listView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                            }
                        }
                    }
                });
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


    public void button2Click(View view) {
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

    }
}


