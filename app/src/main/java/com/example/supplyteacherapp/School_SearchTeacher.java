package com.example.supplyteacherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class School_SearchTeacher extends AppCompatActivity {
    TeacherDB teacherDb = new TeacherDB();
    Database database = new Database(this);
    DistanceCalculator distance = new DistanceCalculator();

    EditText subjectInput, minimumExpInput, maxDistanceInput, schoolPostCodeInput;
    CheckBox drivingLicenseInput, DBSInput;
    ListView listView;
    ArrayList<TeacherAccount> gloablTeacherBySubject = new ArrayList<>();

    String subjectText;
    String minExp ="0";
    int minExpInt =0;
    String maxDist ="0";
    int maxDistInt =0;
    String schoolPostcode ;
    boolean drivingLicenseReq;
    boolean dbsReq;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school__search_teacher);

        subjectInput =  findViewById(R.id.subjectSearch);
        minimumExpInput = findViewById(R.id.yearsOfExpText);
        maxDistanceInput = findViewById(R.id.maxDistText);
        schoolPostCodeInput = findViewById(R.id.schoolPostCodeText);
        drivingLicenseInput = findViewById(R.id.drivingLicenseCheckBox);
        DBSInput = findViewById(R.id.dbsReqCheckBox);

        listView = (ListView) findViewById(R.id.myList);


    }

    public void onclickBtn(View view)
    {

         subjectText = subjectInput.getText().toString();
         minExp = minimumExpInput.getText().toString();
         minExpInt = Integer.parseInt(minExp);
         maxDist = maxDistanceInput.getText().toString();
         maxDistInt = Integer.parseInt(maxDist);
         schoolPostcode = schoolPostCodeInput.getText().toString();
         drivingLicenseReq = drivingLicenseInput.isChecked();
         dbsReq = DBSInput.isChecked();

        OnGetTeacherDataListener onGet = new OnGetTeacherDataListener() {


            @Override
            public void onSuccessTeacherID(ArrayList<String> teacherIDs) {

            }

            @Override
            public void onSuccessTeacherObj(ArrayList<TeacherAccount> teacherAccount) {
                System.out.println(teacherAccount.size());
                for (TeacherAccount t : teacherAccount)
                {
                    System.out.println(t.getAccountName());
                }
                gloablTeacherBySubject = teacherAccount;
                displayListView();


            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure() {

            }
        };

        teacherDb.getAllReleventTeachers(subjectText, minExpInt, drivingLicenseReq, dbsReq, schoolPostcode, maxDistInt, onGet);
    }

    public void displayListView()
    {
        TeacherListAdapter adapter = new TeacherListAdapter(School_SearchTeacher.this, R.layout.adapter_view_layout, gloablTeacherBySubject);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override       //change the color of the background on selected search result
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                TeacherAccount t = adapter.getItem(position);
                System.out.println(t.getAccountName());
            }
        });

    }






}


