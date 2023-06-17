package com.example.pandicazoovrt;

import com.example.pandicazoovrt.tickets.TicketsActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class utils {

    public static void initAll(){
        initUser();
        initEvents();
    }

    public static String ALL_USERS = "USERS";
    public static String EVENTS = "EVENTS";
    public static String LOGGED_USER = "LOGGED_USER";

    public static void initUser(){
        List<User> userList = new ArrayList<>();

        int [] eventsSara = new int[]{1, 0, 1, 1, 0};
        userList.add(new User(
             "sara",
             "sara123",
             "sara@gmail.com",
             "Sara",
             "Lazic",
             "067/7159-923",
             "Voje Veljkovica 22",
                eventsSara
        ));

        int [] eventsMina = new int[]{1, 0, 1, 1, 0};
        userList.add(new User(
            "mina",
            "mina123",
            "mina@gmail.com",
            "Mina",
            "Lazic",
            "064/0914-217",
            "Vardarska 12",
                eventsMina
        ));

    //    clearStorage();
        List<User> listFromStorage = getAllUsers();
        if(listFromStorage.isEmpty()){
            utils.saveListOfObjectsToLocalStorage(ALL_USERS, userList);
        }
    }

    public static void initEvents(){

        int [] eventNumbers = new int[]{252, 181, 202 , 108, 281};

        int[] eventsFromStorage = getEvents();
        if(eventsFromStorage.length < 1){
            saveEvents(eventNumbers);
        }
    }


    public static User getLoggedInUser(){
        return utils.getOneObjectFromLocalStorage(LOGGED_USER, new TypeToken<User>(){}.getType());

    }
    public static List<User> getAllUsers(){
        return utils.getListOfObjectsFromLocalStorage(ALL_USERS, new TypeToken<List<User>>(){}.getType());
    }

    public static int[] getEvents(){
        return getIntArrayFromLocalStorage(EVENTS);
    }

    public static void saveEvents(int[] events){
        saveIntArrayToLocalStorage(EVENTS, events);
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

    public static int[] getIntArrayFromLocalStorage(String key) {
        SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences();

        String json = sharedPreferences.getString(key, "");

        if (json.isEmpty()) {
            return new int[0]; // Return an empty array if the key is not found
        }

        // Convert the JSON string back to int[]
        Gson gson = new Gson();
        int[] array = gson.fromJson(json, int[].class);

        return array;
    }

    public static void saveIntArrayToLocalStorage(String key, int[] array) {
        SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences();

        // Convert the array to a JSON string
        Gson gson = new Gson();
        String json = gson.toJson(array);

        // Save the JSON string to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, json);
        editor.apply();
    }



    public static int[] discount(int zoo, int aq, int feed, int full, String promo_code) {
        int overallCount = zoo + aq + feed + full;

        if (!promo_code.equals(PromoCodes.third_free) || overallCount < 3) {
            return new int[]{ zoo, aq, feed, full };
        }

        int toDiscount = (int) Math.floor(overallCount / 3);

        if (zoo > toDiscount) {
            zoo = zoo - toDiscount;
            toDiscount = 0;
        } else {
            toDiscount = toDiscount - zoo;
            zoo = 0;
        }

        if (aq > toDiscount) {
            aq = aq - toDiscount;
            toDiscount = 0;
        } else {
            toDiscount = toDiscount - aq;
            aq = 0;
        }

        if (feed > toDiscount) {
            feed = feed - toDiscount;
            toDiscount = 0;
        } else {
            toDiscount = toDiscount - feed;
            feed = 0;
        }

        if (full > toDiscount) {
            full = full - toDiscount;
            toDiscount = 0;
        } else {
            toDiscount = toDiscount - full;
            full = 0;
        }

        return new int[]{ zoo, aq, feed, full };
    }

    public static boolean validNumberOfTickets(int zoo, int aq, int feed, int full) {
        return (
                zoo >= 0 &&
                aq >= 0 &&
                feed >= 0 &&
                full >= 0
        );
    }

    private static void clearStorage(){
        SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}


