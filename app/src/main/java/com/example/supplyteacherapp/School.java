package com.example.supplyteacherapp;

public class School extends Account {

    String schoolName;

    public School(String accountName, String schoolName, String postcode, String addressLine1, String addressLine2, String town, String county, String phone, String emailAddress) {
        super(accountName, postcode, addressLine1, addressLine2, town, county, phone, emailAddress);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolNameName(String schoolName) {
        this.schoolName = schoolName;
    }

}
