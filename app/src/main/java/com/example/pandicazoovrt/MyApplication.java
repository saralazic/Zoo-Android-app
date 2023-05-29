package com.example.pandicazoovrt;

import android.app.Application;
import android.content.SharedPreferences;

public class MyApplication extends Application {
    private static final String SHARED_PREFS_NAME = "Pandica";

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public SharedPreferences getSharedPreferences() {
        return getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);
    }
}
