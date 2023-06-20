package com.example.pandicazoovrt.animals;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.example.pandicazoovrt.AboutActivity;
import com.example.pandicazoovrt.AccountActivity;
import com.example.pandicazoovrt.EventsActivity;
import com.example.pandicazoovrt.NotificationsActivity;
import com.example.pandicazoovrt.R;
import com.example.pandicazoovrt.models.Animal;
import com.example.pandicazoovrt.tickets.Comment;
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
                Intent intent = new Intent(PageAnimalActivity.this, AnimalsActivity.class);
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

        LinearLayout commentsLevel1 = findViewById(R.id.commentLevel1); // Assuming you have a LinearLayout with id 'container' in your XML layout

        Comment[] comments = currentAnimal.getComments();

        LayoutInflater inflater = LayoutInflater.from(this);

        for (int i=0; i<comments.length; i++) {
           Comment comment = comments[i];
           LinearLayout commentLayout = (LinearLayout) inflater.inflate(R.layout.comment_item, commentsLevel1, false);

           // Find the views within the inflated layout
           ImageView avatarImageView = commentLayout.findViewById(R.id.avatarImageView);
           TextView nameTextView = commentLayout.findViewById(R.id.nameTextView);
           TextView commentTextView = commentLayout.findViewById(R.id.commentTextView);

           // Set the comment data to the views
            int textColor = Color.BLACK; // Text color for the letter
            int backgroundColor = ContextCompat.getColor(this, R.color.avatar); // Background color of the circle

           avatarImageView.setImageDrawable(createAvatarDrawable(String.valueOf(comment.getAuthor().charAt(0)), textColor, backgroundColor)); // Replace with your avatar logic
           nameTextView.setText(comment.getAuthor());
           commentTextView.setText(comment.getText());

           // Add the comment layout to the comment container
           commentsLevel1.addView(commentLayout);

            Comment[] replyComments = comment.getReplies(); // Replace with your logic to retrieve reply comments

            LinearLayout replyCommentContainer = commentLayout.findViewById(R.id.replyCommentContainer);

            for (Comment replyComment : replyComments) {
                // Inflate the reply_comment_item.xml layout
                LinearLayout replyCommentLayout = (LinearLayout) inflater.inflate(R.layout.comment_item, replyCommentContainer, false);

                // Find the views within the inflated layout
                ImageView replyAvatarImageView = replyCommentLayout.findViewById(R.id.avatarImageView);
                TextView replyNameTextView = replyCommentLayout.findViewById(R.id.nameTextView);
                TextView replyCommentTextView = replyCommentLayout.findViewById(R.id.commentTextView);

                // Set the reply comment data to the views
                replyAvatarImageView.setImageDrawable(createAvatarDrawable(String.valueOf(replyComment.getAuthor().charAt(0)), textColor, backgroundColor)); // Replace with your avatar logic
                replyNameTextView.setText(replyComment.getAuthor());
                replyCommentTextView.setText(replyComment.getText());

                // Add the reply comment layout to the reply comment container
                replyCommentContainer.addView(replyCommentLayout);
            }
       }

    }


    private Drawable createAvatarDrawable(String letter, int textColor, int backgroundColor) {
       int AVATAR_SIZE = 100;
        Bitmap bitmap = Bitmap.createBitmap(AVATAR_SIZE, AVATAR_SIZE, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        // Draw a circle as the background
        Paint backgroundPaint = new Paint();
        backgroundPaint.setColor(backgroundColor);
        canvas.drawCircle(AVATAR_SIZE / 2, AVATAR_SIZE / 2, AVATAR_SIZE / 2, backgroundPaint);

        // Draw the letter in the center
        Paint textPaint = new Paint();
        textPaint.setColor(textColor);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setTextSize(AVATAR_SIZE / 2);
        textPaint.setTextAlign(Paint.Align.CENTER);

        Rect textBounds = new Rect();
        textPaint.getTextBounds(letter, 0, 1, textBounds);
        float textX = canvas.getWidth() / 2f;
        float textY = (canvas.getHeight() / 2f) + (textBounds.height() / 2f);

        canvas.drawText(letter, textX, textY, textPaint);

        return new BitmapDrawable(getResources(), bitmap);
    }

    Drawable getImage(int imageId){
        return getResources().getDrawable(imageId);
    }
}
