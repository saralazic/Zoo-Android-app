package com.example.pandicazoovrt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;



public class EventsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        Log.d("AboutActivity", "routed to Events");
    }
}