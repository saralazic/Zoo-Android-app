package com.example.pandicazoovrt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pandicazoovrt.animals.AnimalsActivity;
import com.example.pandicazoovrt.models.Notifications;
import com.example.pandicazoovrt.models.User;
import com.example.pandicazoovrt.tickets.TicketsActivity;

import java.util.List;

public class NotificationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        ImageButton ticketsImgBtn = findViewById(R.id.ticketsIconButton);
        ticketsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNotificationsSeen();
                Intent intent = new Intent(NotificationsActivity.this, TicketsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton eventsImgBtn = findViewById(R.id.eventsIconButton);
        eventsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNotificationsSeen();
                Intent intent = new Intent(NotificationsActivity.this, EventsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton animalsImgBtn = findViewById(R.id.animalsIconButton);
        animalsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNotificationsSeen();
                Intent intent = new Intent(NotificationsActivity.this, AnimalsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton notificationsImgBtn = findViewById(R.id.notificationsIconButton);
        notificationsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNotificationsSeen();
                Intent intent = new Intent(NotificationsActivity.this, NotificationsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton accountImgBtn = findViewById(R.id.accountIconButton);
        accountImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNotificationsSeen();
                Intent intent = new Intent(NotificationsActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });

        List<Notifications> notifications = utils.getNotificationsForLoggedUser();


        LinearLayout layout = findViewById(R.id.layout_notification);

        for (int i=0; i<notifications.size(); i++){
            Notifications item = notifications.get(i);
            TextView notif = new TextView(NotificationsActivity.this);
            notif.setText(item.getText());
            int color = item.isSeen() ? Color.WHITE : Color.parseColor("#f4f397");
            notif.setBackgroundColor(color);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams.setMargins(50, 20, 50, 20); // Set bottom margin of 8 pixels

            notif.setLayoutParams(layoutParams);

//            Typeface typeface = Typeface.createFromAsset(getAssets(), "baloo_bhai.ttf");
//            notif.setTypeface(typeface);

            Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
            notif.setTypeface(boldTypeface);
            notif.setTextSize(18);
            notif.setTextColor(Color.parseColor("#FF003300"));

            layout.addView(notif);
        }



        TextView linkTextView = findViewById(R.id.aboutLink);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle link click event here
                // For example, navigate to another activity/page in your app
                Intent intent = new Intent(NotificationsActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });



    }

    private void setNotificationsSeen(){
        User logged = utils.getLoggedInUser();
        List<Notifications> allNotifications = utils.getAllNotifications();

        allNotifications.forEach(notification -> {
            if (notification.getUsername().equals(logged.getUsername())){
                notification.setSeen(true);
            }
        });
        utils.saveListOfObjectsToLocalStorage(utils.NOTIFICATIONS, allNotifications);
    }
}