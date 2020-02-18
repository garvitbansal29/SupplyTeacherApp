package com.example.supplyteacherapp;

public class School {
    private  String  schoolName, address, phone;

    public School(String schoolName, String address, String phone) {
        this.schoolName = schoolName;
        this.address = address;
        this.phone = phone;
    }

    public String getschoolName() {
        return schoolName;
    }

    public void setschoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
