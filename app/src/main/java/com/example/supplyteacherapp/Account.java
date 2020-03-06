package com.example.supplyteacherapp;

public abstract class Account {
    protected String accountName, postcode, addressLine1, addressLine2, town, county, phone, emailAddress;

    protected Account(String accountName, String postcode, String addressLine1, String addressLine2, String town, String county, String phone, String emailAddress)
    {
        this.accountName = accountName;
        this.postcode = postcode;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.town = town;
        this.county = county;
        this.phone = phone;
        this.emailAddress = emailAddress;
    }

    public Account() {
    }

    public Account(String accountName, String postcode) {
        this.accountName = accountName;
        this.postcode = postcode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}

