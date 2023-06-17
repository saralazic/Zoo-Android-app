package com.example.pandicazoovrt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pandicazoovrt.tickets.TicketsActivity;


public class EventsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        // header
        ImageButton ticketsImgBtn = findViewById(R.id.ticketsIconButton);
        ticketsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventsActivity.this, TicketsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton eventsImgBtn = findViewById(R.id.eventsIconButton);
        eventsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventsActivity.this, EventsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton animalsImgBtn = findViewById(R.id.animalsIconButton);
        animalsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventsActivity.this, AnimalsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton notificationsImgBtn = findViewById(R.id.notificationsIconButton);
        notificationsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventsActivity.this, NotificationsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton accountImgBtn = findViewById(R.id.accountIconButton);
        accountImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventsActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });



        TextView linkTextView = findViewById(R.id.aboutLink);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle link click event here
                // For example, navigate to another activity/page in your app
                Intent intent = new Intent(EventsActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        User loggedUser = utils.getLoggedInUser();
        int[] events = utils.getEvents();

        //likes init color

        ImageButton like[] = {null, null, null, null, null};
        TextView cntLikeText[] = {null, null, null, null, null};
        int[] idsBtns = new int[]{R.id.like1, R.id.like2, R.id.like3, R.id.like4, R.id.like5};
        int[] idsCnts = new int[]{R.id.number_of_likes_1, R.id.number_of_likes_2, R.id.number_of_likes_3, R.id.number_of_likes_4, R.id.number_of_likes_5};

        //like[i]
        for(int i = 0; i<5; i++) {
            like[i] = findViewById(idsBtns[i]);
            if (loggedUser.getEvents()[i] == 1)
                like[i].setColorFilter(getResources().getColor(R.color.heart), PorterDuff.Mode.SRC_IN);
            else
                like[i].setColorFilter(getResources().getColor(R.color.greenBackground), PorterDuff.Mode.SRC_IN);

            cntLikeText[i] = findViewById(idsCnts[i]);
            cntLikeText[i].setText("" + utils.getEvents()[i]);

            int finalI = i;
            like[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int[] userEvents = loggedUser.getEvents();
                    int[] eventLikes = utils.getEvents();
                    if (userEvents[finalI] == 0) {
                        userEvents[finalI] = 1;
                        loggedUser.setEvents(userEvents);
                        utils.saveOneObjectToLocalStorage(utils.LOGGED_USER, loggedUser);
                        eventLikes[finalI]++;
                        utils.saveEvents((eventLikes));
                        cntLikeText[finalI].setText("" + eventLikes[finalI]);
                        like[finalI].setColorFilter(getResources().getColor(R.color.heart), PorterDuff.Mode.SRC_IN);
                    } else {
                        userEvents[finalI] = 0;
                        loggedUser.setEvents(userEvents);
                        utils.saveOneObjectToLocalStorage(utils.LOGGED_USER, loggedUser);
                        eventLikes[finalI]--;
                        utils.saveEvents(eventLikes);
                        cntLikeText[finalI].setText("" + eventLikes[finalI]);
                        like[finalI].setColorFilter(getResources().getColor(R.color.greenBackground), PorterDuff.Mode.SRC_IN);
                    }
                }
            });
        
        }
        // like2
        ImageButton like2 = findViewById(R.id.like2);
        if (loggedUser.getEvents()[1] == 1)
            like2.setColorFilter(getResources().getColor(R.color.heart), PorterDuff.Mode.SRC_IN);
        else like2.setColorFilter(getResources().getColor(R.color.greenBackground), PorterDuff.Mode.SRC_IN);

        TextView cntLikes2 = findViewById(R.id.number_of_likes_2);
        cntLikes2.setText(""+utils.getEvents()[1]);

        like2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] userEvents = loggedUser.getEvents();
                int[] eventLikes = utils.getEvents();
                if (userEvents[1] == 0){
                    userEvents[1] = 1;
                    loggedUser.setEvents(userEvents);
                    utils.saveOneObjectToLocalStorage(utils.LOGGED_USER, loggedUser);
                    eventLikes[1]++;
                    utils.saveEvents((eventLikes));
                    cntLikes2.setText(""+eventLikes[1]);
                    like2.setColorFilter(getResources().getColor(R.color.heart), PorterDuff.Mode.SRC_IN);
                }
                else {
                    userEvents[1] = 0;
                    loggedUser.setEvents(userEvents);
                    utils.saveOneObjectToLocalStorage(utils.LOGGED_USER, loggedUser);
                    eventLikes[1]--;
                    utils.saveEvents(eventLikes);
                    cntLikes2.setText(""+eventLikes[1]);
                    like2.setColorFilter(getResources().getColor(R.color.greenBackground), PorterDuff.Mode.SRC_IN);
                }
            }
        });


    }

}