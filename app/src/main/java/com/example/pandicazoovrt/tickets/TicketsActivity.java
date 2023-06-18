package com.example.pandicazoovrt.tickets;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pandicazoovrt.AboutActivity;
import com.example.pandicazoovrt.AccountActivity;
import com.example.pandicazoovrt.animals.AnimalsActivity;
import com.example.pandicazoovrt.EventsActivity;
import com.example.pandicazoovrt.NotificationsActivity;
import com.example.pandicazoovrt.R;

public class TicketsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);


        TextView linkTextView = findViewById(R.id.aboutLink);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle link click event here
                // For example, navigate to another activity/page in your app
                Intent intent = new Intent(TicketsActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        ImageButton ticketsImgBtn = findViewById(R.id.ticketsIconButton);
        ticketsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicketsActivity.this, TicketsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton eventsImgBtn = findViewById(R.id.eventsIconButton);
        eventsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicketsActivity.this, EventsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton animalsImgBtn = findViewById(R.id.animalsIconButton);
        animalsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicketsActivity.this, AnimalsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton notificationsImgBtn = findViewById(R.id.notificationsIconButton);
        notificationsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicketsActivity.this, NotificationsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton accountImgBtn = findViewById(R.id.accountIconButton);
        accountImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicketsActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });

        Button childrenBtn = findViewById(R.id.ChildrenBtn);
        childrenBtn.setOnClickListener(v -> {
            Intent intent = new Intent(TicketsActivity.this, ChildrenTicketsActivity.class);
            startActivity(intent);
        });

        Button adultsBtn = findViewById(R.id.AdultBtn);
        adultsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(TicketsActivity.this, AdultsTicketsActivity.class);
            startActivity(intent);
        });

        Button groupBtn = findViewById(R.id.GroupBtn);
        groupBtn.setOnClickListener(v -> {
            Intent intent = new Intent(TicketsActivity.this, GroupTicketsActivity.class);
            startActivity(intent);
        });

    }

}