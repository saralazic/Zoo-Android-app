package com.example.pandicazoovrt;

import android.os.Bundle;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Log.d("AboutActivity", "routed to About");
    }
}