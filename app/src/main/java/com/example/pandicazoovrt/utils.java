package com.example.pandicazoovrt;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class utils {

    public static void initAll(){
        initUser();
    }

    public static String ALL_USERS = "USERS";
    public static String LOGGED_USER = "LOGGED_USER";

    public static void initUser(){
        List<User> userList = new ArrayList<>();

        userList.add(new User(
             "sara",
             "sara123",
             "sara@gmail.com",
             "Sara",
             "Lazic",
             "067/7159-923",
             "Voje Veljkovica 22"
        ));

        userList.add(new User(
            "mina",
            "mina123",
            "mina@gmail.com",
            "Mina",
            "Lazic",
            "064/0914-217",
            "Vardarska 12"
        ));

        List<User> listFromStorage = getAllUsers();
        if(listFromStorage.isEmpty())
            utils.saveListOfObjectsToLocalStorage(ALL_USERS, userList);
    }


    public static User getLoggedInUser(){
        return utils.getOneObjectFromLocalStorage(LOGGED_USER, new TypeToken<List<User>>(){}.getType());

    }
    public static List<User> getAllUsers(){
        return utils.getListOfObjectsFromLocalStorage(ALL_USERS, new TypeToken<List<User>>(){}.getType());
    }

    public static <T> List<T> getListOfObjectsFromLocalStorage(String key, Type type) {
        SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences();
        String json = sharedPreferences.getString(key, "");

        if (json.equals("")) return  new ArrayList<>();

        Gson gson = new Gson();
        List<T> objects = gson.fromJson(json, type);
        return objects;
    }

    public static <T> void saveListOfObjectsToLocalStorage(String key, List<T> objects) {
        Gson gson = new Gson();
        String json = gson.toJson(objects);

        SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, json);
        editor.apply();
    }

    public static <T> T getOneObjectFromLocalStorage(String key, Type type) {
        SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences();

        String json = sharedPreferences.getString(key, "");

        if (json.equals("")) return null;

        Gson gson = new Gson();
        T object = gson.fromJson(json, type);
        return object;
    }

    public static <T> void saveOneObjectToLocalStorage(String key, T object) {
        Gson gson = new Gson();
        String json = gson.toJson(object);

        SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, json);
        editor.apply();
    }


}
