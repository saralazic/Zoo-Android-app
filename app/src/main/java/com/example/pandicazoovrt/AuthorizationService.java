package com.example.pandicazoovrt;

import android.content.Context;
import android.util.Log;

import java.util.List;

public class AuthorizationService {

    public AuthorizationService() {}

    public boolean login(String username, String password) {

        List<User> allUsers = utils.getAllUsers();

        if (allUsers == null || allUsers.isEmpty()) return false;


        User userOptional = null;
        for(int i=0; i<allUsers.size(); i++){
            if( username.equals(allUsers.get(i).getUsername()) && password.equals(allUsers.get(i).getPassword())){
                userOptional = allUsers.get(i);
            }
        }

        if (userOptional != null) {
            // Login successful
            Log.d("AuthorizationService", "Login successful");
            utils.saveOneObjectToLocalStorage(utils.LOGGED_USER, userOptional);
            return true;
        } else {
            // Login failed
            Log.d("AuthorizationService", "Login failed");
            return false;
        }
    }


    public boolean register(User user) {

        List<User> allUsers = utils.getAllUsers();


        User userOptional = null;
        for(int i=0; i<allUsers.size(); i++){
            if( user.getUsername().equals(allUsers.get(i).getUsername()) ){
                userOptional = allUsers.get(i);
            }
        }

        if (userOptional != null) {
            // Register failed
            Log.d("AuthorizationService", "User already exists!");
            return false;
        }

        // Register successful
        Log.d("AuthorizationService", "Registration successfull");
        allUsers.add(user);
        utils.saveListOfObjectsToLocalStorage(utils.ALL_USERS, allUsers);
        utils.saveOneObjectToLocalStorage(utils.LOGGED_USER, user);
        return true;

    }

}
