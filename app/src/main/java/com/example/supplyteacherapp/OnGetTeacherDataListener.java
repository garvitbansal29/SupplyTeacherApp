package com.example.supplyteacherapp;

import java.util.ArrayList;

public interface OnGetTeacherDataListener {

    void onSuccessTeacherID(ArrayList<String> teacherIDs);
    void onSuccessTeacherObj(ArrayList<TeacherAccount> teacherAccount);

    void onStart();
    void onFailure();
}
