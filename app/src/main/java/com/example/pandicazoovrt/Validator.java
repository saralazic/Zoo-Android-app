package com.example.pandicazoovrt;

import java.util.regex.Pattern;

public class Validator {

    public static String validateInput(User user) {
        if (emptyInputs(user))
            return Errors.EMPTY_INPUTS;
        if (!isPasswordValid(user.getPassword()))
            return Errors.BAD_PASSWORD;
        if (!isEmailValid(user.getEmail()))
            return Errors.BAD_EMAIL;
        if (!isValidPhoneNumber(user.getPhone()))
            return Errors.BAD_PHONE;
        return "";
    }

    private static boolean emptyInputs(User user){
        if (
            user.getUsername().length() < 3 ||
            user.getPassword().length() < 3||
            user.getEmail().length() < 3 ||
            user.getFirstName().length() < 3 ||
            user.getLastName().length() < 3 ||
            user.getAddress().length() < 3 ||
            user.getPhone().length() < 3
        ) {
            return true; //error
        }
        return false;
    }

    private static boolean isPasswordValid(String password) {
        // Regex pattern for password validation
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$";

        // Create a Pattern object from the regex
        Pattern pattern = Pattern.compile(regex);

        // Match the password against the pattern
        boolean isMatch = pattern.matcher(password).matches();

        // Additional check for starting with a letter
        boolean startsWithLetter = Pattern.matches("^[a-zA-Z].*", password);

        // Return true if the password matches the pattern and starts with a letter
        return isMatch && startsWithLetter;

    }

    private static boolean isEmailValid(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        // Create a Pattern object from the regex
        Pattern pattern = Pattern.compile(regex);

        // Match the email against the pattern
        return pattern.matcher(email).matches();

    }

    private static boolean isValidPhoneNumber(String phone) {
        // Regex pattern for phone number validation
        String regex = "^\\+(3816)([0-9]){6,9}$";

        // Create a Pattern object from the regex
        Pattern pattern = Pattern.compile(regex);

        // Match the phone number against the pattern
        return pattern.matcher(phone).matches();
    }

}
