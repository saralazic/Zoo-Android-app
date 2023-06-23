package com.example.pandicazoovrt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pandicazoovrt.animals.AnimalsActivity;
import com.example.pandicazoovrt.authorization.LoginActivity;
import com.example.pandicazoovrt.models.User;
import com.example.pandicazoovrt.tickets.TicketsActivity;

import java.util.List;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        ImageButton ticketsImgBtn = findViewById(R.id.ticketsIconButton);
        ticketsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, TicketsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton eventsImgBtn = findViewById(R.id.eventsIconButton);
        eventsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, EventsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton animalsImgBtn = findViewById(R.id.animalsIconButton);
        animalsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, AnimalsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton notificationsImgBtn = findViewById(R.id.notificationsIconButton);
        notificationsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, NotificationsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton accountImgBtn = findViewById(R.id.accountIconButton);
        accountImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });

        User loggedIn = utils.getLoggedInUser();

        EditText usernameEditText = findViewById(R.id.usernameTextEdit);
        usernameEditText.setHint(loggedIn.getUsername());
        usernameEditText.setHintTextColor(Color.WHITE);

        EditText passwordEditText = findViewById(R.id.passwordTextEdit);
        passwordEditText.setHint(loggedIn.getPassword());
        passwordEditText.setHintTextColor(Color.WHITE);

        TextView emailTextView = findViewById(R.id.emailTextView);
        emailTextView.setText(loggedIn.getEmail());

        EditText firstNameEditText = findViewById(R.id.firstNameEditText);
        firstNameEditText.setHint(loggedIn.getFirstName());
        firstNameEditText.setHintTextColor(Color.WHITE);

        EditText lastNameEditText = findViewById(R.id.lastNameEditText);
        lastNameEditText.setHint(loggedIn.getLastName());
        lastNameEditText.setHintTextColor(Color.WHITE);


        EditText addressEditText = findViewById(R.id.addressEditText);
        addressEditText.setHint(loggedIn.getAddress());
        addressEditText.setHintTextColor(Color.WHITE);

        EditText phoneEditText = findViewById(R.id.phoneEditText);
        phoneEditText.setHint(loggedIn.getPhone());
        phoneEditText.setHintTextColor(Color.WHITE);


        Button confirmBtn = findViewById(R.id.confirm_button);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String phone = phoneEditText.getText().toString();

                if (username.length() > 3) {
                    utils.changeUsernameEveryWhere(loggedIn.getUsername(), username);
                    loggedIn.setUsername(username);
                }
                if (password.length() > 3) loggedIn.setPassword(password);
                if (firstName.length() > 3) loggedIn.setFirstName(firstName);
                if (lastName.length() > 3) loggedIn.setLastName(lastName);
                if (address.length() > 3) loggedIn.setAddress(address);
                if (phone.length() > 3) loggedIn.setPhone(phone);

                List<User> allUsers = utils.getAllUsers();
                allUsers.forEach(u -> {
                    if (u.getEmail().equals(loggedIn.getEmail())) {
                        u.setUsername(loggedIn.getUsername());
                        u.setPassword(loggedIn.getPassword());
                        u.setFirstName(loggedIn.getFirstName());
                        u.setLastName(loggedIn.getLastName());
                        u.setPhone(loggedIn.getPhone());
                        u.setAddress(loggedIn.getAddress());
                    }
                });
                utils.saveListOfObjectsToLocalStorage(utils.ALL_USERS, allUsers);
                utils.saveOneObjectToLocalStorage(utils.LOGGED_USER, loggedIn);
            }});


            // OSTALO JE ENABLE DISABLE DUGMETA


            //LOGOUT
            Button logout = findViewById(R.id.logout_button);
            logout.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick (View v){
                        utils.logout();
                        Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                });

    }
}