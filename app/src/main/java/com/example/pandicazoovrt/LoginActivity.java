package com.example.pandicazoovrt;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    public AuthorizationService authorizationService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        utils.initAll(); // since login is initial page, I will initialize storage on create of it

        setContentView(R.layout.activity_login);

        this.authorizationService = new AuthorizationService();

        TextView linkTextView = findViewById(R.id.registerLink);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle link click event here
                // For example, navigate to another activity/page in your app
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        Button myButton = findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernameEditText = findViewById(R.id.usernameTextEdit);
                EditText passwordEditText = findViewById(R.id.passwordTextEdit);

                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                Log.d("LoginActivity", "Login button clicked");
                boolean loginSuccessful = authorizationService.login(username, password);
                if (loginSuccessful) {
                    Intent intent = new Intent(LoginActivity.this, HomepageActivity.class);
                    startActivity(intent);
                }
                else {
                    TextView errorTextView = findViewById(R.id.textinput_error);
                    errorTextView.setText(Errors.BAD_CREDENTIALS);
                    errorTextView.setVisibility(View.VISIBLE); // Make the TextView visible
                }
            }
        });
    }
}
