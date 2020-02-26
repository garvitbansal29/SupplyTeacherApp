package com.example.supplyteacherapp;

public class TeacherAccount extends Account {

    boolean drivingLicense;
    int yearsOfExperience;
    boolean dbs;

    public TeacherAccount(String accountName, String postcode, String addressLine1, String addressLine2, String town, String county, String phone, String emailAddress, boolean drivingLicense, int yearsOfExperience,  boolean dbs) {
        super(accountName, postcode, addressLine1, addressLine2, town, county, phone, emailAddress);
        this.drivingLicense = drivingLicense;
        this.yearsOfExperience = yearsOfExperience;
        this.dbs = dbs;
    }

    public TeacherAccount() {
    }

    public boolean isDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(boolean drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }


    public boolean isDbs() {
        return dbs;
    }

    public void setDbs(boolean dbs) {
        this.dbs = dbs;
    }
}
