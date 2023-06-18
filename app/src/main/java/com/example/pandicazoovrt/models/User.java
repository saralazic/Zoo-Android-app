package com.example.pandicazoovrt.models;

import java.lang.reflect.Array;

public class User {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    private int [] events;


    public User(
        String username,
        String password,
        String email,
        String firstName,
        String lastName,
        String phone,
        String address,
        int [] events
    ) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.events = events;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int[] getEvents() {
        return events;
    }

    public void setEvents(int[] events) {
        this.events = events;
    }
}
