package com.example.supplyteacherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;


public class TeacherRegisterDetails extends AppCompatActivity {
    String email = "";
    String username, teacherName, postcode,addressLine1, addressLine2, town, county, phone,  subjects;
    boolean drivingLicense, DBS;
    int yearsOfExperience;
    EditText teacherName_field, postcode_field, addressLine1_field, addressLine2_field, town_field, county_field, phone_field, yearsOfExperience_field, subjects_field;
    CheckBox drivingLicense_checkBox, dbs_checkBox;

    Database database = new Database(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_register_details);

        teacherName_field = findViewById(R.id.name_field);
        postcode_field = findViewById(R.id.postcode_field);
        addressLine1_field = findViewById(R.id.addressLine1_field);
        addressLine2_field = findViewById(R.id.addressLine2_field);
        town_field = findViewById(R.id.town_field);
        county_field = findViewById(R.id.county_field);
        phone_field = findViewById(R.id.phoneNumber_field);
        drivingLicense_checkBox = findViewById(R.id.drivingLicense_checkBox);
        dbs_checkBox = findViewById(R.id.DBS_checkBox);
        yearsOfExperience_field = findViewById(R.id.yearsOfExperience_field);
        subjects_field = findViewById(R.id.subjects_field);

    }

    public void registerTeacherDetailsOnClick(View view)
    {

        username = FirebaseAuth.getInstance().getCurrentUser().getUid();

        teacherName = teacherName_field.getText().toString();
        postcode = postcode_field.getText().toString();
        addressLine1 = addressLine1_field.getText().toString();
        addressLine2 = addressLine2_field.getText().toString();
        town = town_field.getText().toString();
        county = county_field.getText().toString();
        phone = phone_field.getText().toString();
        drivingLicense = drivingLicense_checkBox.isChecked();
        DBS = dbs_checkBox.isChecked();
        String stringYearsOfExperience = yearsOfExperience_field.getText().toString();
        yearsOfExperience = Integer.valueOf(stringYearsOfExperience);
        subjects = subjects_field.getText().toString();

        TeacherAccount teacherAccount = new TeacherAccount(teacherName, postcode, addressLine1, addressLine2, town, county, phone, email, drivingLicense, yearsOfExperience, DBS);
        database.addTeacherDetails(teacherAccount, username);

        startActivity(new Intent(this, TeacherHome.class));

    }

    public void addSubjectList(EditText subjectsListField)
    {


    }



}
