package com.example.supplyteacherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;


public class TeacherRegisterDetails extends AppCompatActivity {

    String username, name, address, phone, email;
    EditText name_field, address_field, phone_field, email_field;
    Database database = new Database(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_register_details);

        name_field = findViewById(R.id.name_field);
        address_field = findViewById(R.id.address_field);
        phone_field = findViewById(R.id.phoneNumber_field);
//        email_field = findViewById(R.id.email_field);

    }

    public void registerTeacherDetailsOnClick(View view)
    {
        username = FirebaseAuth.getInstance().getCurrentUser().getUid();

        name = name_field.getText().toString();
        address = address_field.getText().toString();
        phone= phone_field.getText().toString();
//        email= email_field.getText().toString();

        startActivity(new Intent(this, TeacherHome.class));
        database.addTeacherDetails(username, name, address, phone);
    }


}
