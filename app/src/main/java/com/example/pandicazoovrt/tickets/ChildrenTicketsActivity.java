package com.example.pandicazoovrt.tickets;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pandicazoovrt.AboutActivity;
import com.example.pandicazoovrt.AccountActivity;
import com.example.pandicazoovrt.AnimalsActivity;
import com.example.pandicazoovrt.EventsActivity;
import com.example.pandicazoovrt.NotificationsActivity;
import com.example.pandicazoovrt.R;

public class ChildrenTicketsActivity extends AppCompatActivity {

    private NumberPicker picker1, picker2, picker3, picker4;
    private int cnt1, cnt2, cnt3, cnt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_children);

            TextView linkTextView = findViewById(R.id.aboutLink);
            linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
            linkTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle link click event here
                    // For example, navigate to another activity/page in your app
                    Intent intent = new Intent(ChildrenTicketsActivity.this, AboutActivity.class);
                    startActivity(intent);
                }
            });

            ImageButton ticketsImgBtn = findViewById(R.id.ticketsIconButton);
            ticketsImgBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChildrenTicketsActivity.this, TicketsActivity.class);
                    startActivity(intent);
                }
            });

            ImageButton eventsImgBtn = findViewById(R.id.eventsIconButton);
            eventsImgBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChildrenTicketsActivity.this, EventsActivity.class);
                    startActivity(intent);
                }
            });

            ImageButton animalsImgBtn = findViewById(R.id.animalsIconButton);
            animalsImgBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChildrenTicketsActivity.this, AnimalsActivity.class);
                    startActivity(intent);
                }
            });

            ImageButton notificationsImgBtn = findViewById(R.id.notificationsIconButton);
            notificationsImgBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChildrenTicketsActivity.this, NotificationsActivity.class);
                    startActivity(intent);
                }
            });

            ImageButton accountImgBtn = findViewById(R.id.accountIconButton);
            accountImgBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChildrenTicketsActivity.this, AccountActivity.class);
                    startActivity(intent);
                }
            });

            picker1 = findViewById(R.id.numberpicker_1);
            picker1.setMaxValue(100);
            picker1.setMinValue(0);

            picker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                    cnt1 = picker1.getValue();
                }
            });

            picker2 = findViewById(R.id.numberpicker_2);
            picker2.setMaxValue(100);
            picker2.setMinValue(0);

            picker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                    int cnt2 = picker2.getValue();
                }
            });

            picker3 = findViewById(R.id.numberpicker_3);
            picker3.setMaxValue(100);
            picker3.setMinValue(0);

            picker3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                    int cnt3 = picker3.getValue();
                }
            });

            picker4 = findViewById(R.id.numberpicker_4);
            picker4.setMaxValue(100);
            picker4.setMinValue(0);

            picker4.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                    int cnt4 = picker4.getValue();
                }
            });

    }
}