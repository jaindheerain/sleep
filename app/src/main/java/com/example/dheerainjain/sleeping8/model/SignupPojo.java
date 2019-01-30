package com.example.dheerainjain.sleeping8.model;

public class SignupPojo {

    String fullName,emailAddress,password,userType,contactNumber;

    public SignupPojo() {
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public SignupPojo(String fullName, String emailAddress, String password, String userType, String contactNumber) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.userType = userType;
        this.contactNumber = contactNumber;
    }
}
