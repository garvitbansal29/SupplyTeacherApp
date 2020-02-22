package com.example.supplyteacherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class SchoolRegisterDetail extends AppCompatActivity {
    String username, schoolName, postcode,addressLine1, addressLine2, town, county, phone, email, subjects;
    boolean drivingLicense, DBS;
    int yearsOfExperience;
    EditText name_Field, school_Field, postcode_field, addressLine1_field, addressLine2_field, town_field, county_field, phone_field;
    //CheckBox drivingLicense_checkBox, dbs_checkBox;

    Database database = new Database(this);
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_register_detail);

        name_Field = findViewById(R.id.name_field);
        school_Field = findViewById(R.id.schoolInput);
        postcode_field = findViewById(R.id.postcode_field);
        addressLine1_field = findViewById(R.id.addressLine1_field);
        addressLine2_field = findViewById(R.id.addressLine2_field);
        town_field = findViewById(R.id.town_field);
        county_field = findViewById(R.id.county_field);
        phone_field = findViewById(R.id.phoneNumber_field);


    }

    public void registerSchoolDetailsOnClick(View view)
    {
        username = FirebaseAuth.getInstance().getCurrentUser().getUid();

        schoolName = school_Field.getText().toString();
        postcode = postcode_field.getText().toString();
        addressLine1 = addressLine1_field.getText().toString();
        addressLine2 = addressLine2_field.getText().toString();
        town = town_field.getText().toString();
        county = county_field.getText().toString();
        phone = phone_field.getText().toString();

        School school = new School(username, schoolName, postcode, addressLine1, addressLine2, town, county, phone, email);
        database.addSchool(school, username);

        startActivity(new Intent(this, SchoolHome.class));
    }
}
