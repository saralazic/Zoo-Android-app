package com.example.pandicazoovrt.animals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pandicazoovrt.AboutActivity;
import com.example.pandicazoovrt.AccountActivity;
import com.example.pandicazoovrt.EventsActivity;
import com.example.pandicazoovrt.NotificationsActivity;
import com.example.pandicazoovrt.R;
import com.example.pandicazoovrt.models.Animal;
import com.example.pandicazoovrt.tickets.TicketsActivity;
import com.example.pandicazoovrt.utils;

import java.util.List;

public class AnimalsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        // footer
        TextView linkTextView = findViewById(R.id.aboutLink);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle link click event here
                // For example, navigate to another activity/page in your app
                Intent intent = new Intent(AnimalsActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        //header
        ImageButton ticketsImgBtn = findViewById(R.id.ticketsIconButton);
        ticketsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimalsActivity.this, TicketsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton eventsImgBtn = findViewById(R.id.eventsIconButton);
        eventsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimalsActivity.this, EventsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton animalsImgBtn = findViewById(R.id.animalsIconButton);
        animalsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimalsActivity.this, AnimalsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton notificationsImgBtn = findViewById(R.id.notificationsIconButton);
        notificationsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimalsActivity.this, NotificationsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton accountImgBtn = findViewById(R.id.accountIconButton);
        accountImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimalsActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });


        ImageButton[] animalImages = {null, null, null, null, null, null, null, null, null, null};
        TextView animalSpecies[] = {null, null, null, null, null, null, null, null, null, null};

        int[] animalImgIds = {R.id.animalImg1, R.id.animalImg2, R.id.animalImg3, R.id.animalImg4, R.id.animalImg5, R.id.animalImg6, R.id.animalImg7, R.id.animalImg8, R.id.animalImg9, R.id.animalImg10};
        int[] animalSpcsIds = {R.id.specie1, R.id.specie2, R.id.specie3, R.id.specie4, R.id.specie5, R.id.specie6, R.id.specie7, R.id.specie8, R.id.specie9, R.id.specie10};

        List<Animal> animals = utils.getAllAnimals();

        // animals
        for(int i=0; i<10; i++){
            Animal currentAnimal = animals.get(i);
            Drawable img = getImage(currentAnimal.getImg());
            animalImages[i] = findViewById(animalImgIds[i]);
            animalSpecies[i] = findViewById(animalSpcsIds[i]);

            animalImages[i].setBackground(img);
            animalSpecies[i].setText(currentAnimal.getSpecie());

            animalImages[i].setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            utils.saveOneObjectToLocalStorage(utils.CURRENT_ANIMAL, currentAnimal);
                            Intent intent = new Intent(AnimalsActivity.this, PageAnimalActivity.class);
                            startActivity(intent);
                        }
                    }
            );
        }



    }


    Drawable getImage(int imageId){
        return getResources().getDrawable(imageId);
    }
}
