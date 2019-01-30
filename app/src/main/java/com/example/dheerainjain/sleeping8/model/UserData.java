package com.example.dheerainjain.sleeping8.model;

import java.util.ArrayList;

public class UserData {

    ArrayList<String> artistIds;
    String userType,_id,fullName,emailAddress;
    String userId,password,createdAt,updatedAt;
    Integer contactNumber;
    int __v;

    public ArrayList<String> getArtistIds() {
        return artistIds;
    }

    public String getUserType() {
        return userType;
    }

    public String get_id() {
        return _id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public int get__v() {
        return __v;
    }
}
