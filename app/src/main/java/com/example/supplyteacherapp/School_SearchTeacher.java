package com.example.supplyteacherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

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

        String subjectText = subjectInput.getText().toString();


        teacherDb.getTeacherObjsBySubject(subjectText, new OnGetTeacherDataListener() {
            @Override
            public void onSuccessTeacherID(ArrayList<String> teacherIDs) {

            }

            @Override
            public void onSuccessTeacherObj(ArrayList<TeacherAccount> teacherAccount) {

                TeacherListAdapter adapter = new TeacherListAdapter(School_SearchTeacher.this, R.layout.adapter_view_layout, teacherAccount);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        

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


    }



}


