package com.example.tulsi.trackingapp;

/**
 * Created by tulsi on 4/6/2018.
 */

public class User {

    private String email;
    private String type;

    public User() {}

    public User(String email, String type) {
        this.email = email;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

}
