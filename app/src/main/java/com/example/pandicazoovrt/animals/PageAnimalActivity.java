package com.example.pandicazoovrt.animals;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pandicazoovrt.AboutActivity;
import com.example.pandicazoovrt.AccountActivity;
import com.example.pandicazoovrt.EventsActivity;
import com.example.pandicazoovrt.NotificationsActivity;
import com.example.pandicazoovrt.R;
import com.example.pandicazoovrt.models.Animal;
import com.example.pandicazoovrt.tickets.TicketsActivity;
import com.example.pandicazoovrt.utils;

import java.util.List;

public class PageAnimalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_animal);

        // footer
        TextView linkTextView = findViewById(R.id.aboutLink);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle link click event here
                // For example, navigate to another activity/page in your app
                Intent intent = new Intent(PageAnimalActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        //header
        ImageButton ticketsImgBtn = findViewById(R.id.ticketsIconButton);
        ticketsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageAnimalActivity.this, TicketsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton eventsImgBtn = findViewById(R.id.eventsIconButton);
        eventsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageAnimalActivity.this, EventsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton animalsImgBtn = findViewById(R.id.animalsIconButton);
        animalsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageAnimalActivity.this, PageAnimalActivity.class);
                startActivity(intent);
            }
        });

        ImageButton notificationsImgBtn = findViewById(R.id.notificationsIconButton);
        notificationsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageAnimalActivity.this, NotificationsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton accountImgBtn = findViewById(R.id.accountIconButton);
        accountImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageAnimalActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });


        Animal currentAnimal = utils.getCurrentAnimal();

        Drawable img = getImage(currentAnimal.getImg());
        ImageView imageView= findViewById(R.id.animalImg);
        imageView.setBackground(img);


        TextView specieView = findViewById(R.id.specie);
        specieView.setText(currentAnimal.getSpecie());

        TextView latinView = findViewById(R.id.latin);
        latinView.setText("latinski naziv: "+currentAnimal.getLatin());


        TextView descentView = findViewById(R.id.descent);
        descentView.setText("poreklo: "+currentAnimal.getDescent());

        TextView populationView = findViewById(R.id.population);
        populationView.setText("populacija: "+currentAnimal.getPopulation());


        TextView lifespanView = findViewById(R.id.lifespan);
        lifespanView.setText("životni vek: "+currentAnimal.getLifespan());


    }


    Drawable getImage(int imageId){
        return getResources().getDrawable(imageId);
    }
}
