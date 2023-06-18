package com.example.pandicazoovrt.authorization;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pandicazoovrt.AuthorizationService;
import com.example.pandicazoovrt.constants.Errors;
import com.example.pandicazoovrt.HomepageActivity;
import com.example.pandicazoovrt.R;
import com.example.pandicazoovrt.Validator;
import com.example.pandicazoovrt.models.User;

public class RegistrationActivity extends AppCompatActivity {

    public AuthorizationService authorizationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        this.authorizationService = new AuthorizationService();

        TextView linkTextView = findViewById(R.id.linkTextView);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle link click event here
                // For example, navigate to another activity/page in your app
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        Button myButton = findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernameEditText = findViewById(R.id.usernameTextEdit);
                EditText passwordEditText = findViewById(R.id.passwordTextEdit);
                EditText emailEditText = findViewById(R.id.emailEditText);
                EditText firstNameEditText = findViewById(R.id.firstNameEditText);
                EditText lastNameEditText = findViewById(R.id.lastNameEditText);
                EditText addressEditText = findViewById(R.id.addressEditText);
                EditText phoneEditText = findViewById(R.id.phoneEditText);


                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                int[] events = {0,0,0,0,0};
                User userToRegister = new User(username, password, email, firstName, lastName, phone, address, events);

                String validationError = Validator.validateInput(userToRegister);

                if (validationError.length()>0){
                    TextView errorTextView = findViewById(R.id.textinput_error);
                    errorTextView.setText(validationError);
                    errorTextView.setVisibility(View.VISIBLE);
                    return;
                }

                Log.d("RegistrationActivity", "Register button clicked");
                boolean registrationSuccessful = authorizationService.register(userToRegister);
                if (!registrationSuccessful) {
                    TextView errorTextView = findViewById(R.id.textinput_error);
                    errorTextView.setText(Errors.USER_EXISTS);
                    errorTextView.setVisibility(View.VISIBLE);
                    return;
                }

                Intent intent = new Intent(RegistrationActivity.this, HomepageActivity.class);
                startActivity(intent);
            }
        });
    }
}
