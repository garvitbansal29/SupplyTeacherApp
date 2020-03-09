package com.example.supplyteacherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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

        ArrayList<TeacherAccount> newTeach = new ArrayList<>();
        OnGetTeacherDataListener oneget = new OnGetTeacherDataListener() {


            @Override
            public void onSuccessTeacherID(ArrayList<String> teacherIDs) {

            }

            @Override
            public void onSuccessTeacherObj(ArrayList<TeacherAccount> teacherAccount) {
                System.out.println("TESTING_________________");
                System.out.println(teacherAccount.size());
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
        };

        teacherDb.getTeacherInRadius("sk7 2jt", 5, oneget);
        teacherDb.getTeacherObjsBySubject("Mathematics", oneget);

        System.out.println("PEASE BE WORKING  "+ newTeach.size());


//        teacherDb.getTeacherObjsBySubject(subjectText, new OnGetTeacherDataListener() {
//            @Override
//            public void onSuccessTeacherID(ArrayList<String> teacherIDs) {
//
//            }
//
//            @Override
//            public void onSuccessTeacherObj(ArrayList<TeacherAccount> teacherAccount) {
//
//                gloablTeacherBySubject = teacherAccount;
//                displayListView();
//
//
//            }
//
//            @Override
//            public void onStart() {
//
//            }
//
//            @Override
//            public void onFailure() {
//
//            }
//        });



    }

//    public void displayListView()
//    {
//        TeacherListAdapter adapter = new TeacherListAdapter(School_SearchTeacher.this, R.layout.adapter_view_layout, gloablTeacherBySubject);
//        listView.setAdapter(adapter);
//
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override       //change the color of the background on selected search result
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//
//                TeacherAccount t = adapter.getItem(position);
//                System.out.println(t.getAccountName());
//
//            }
//        });
//
//    }






}


