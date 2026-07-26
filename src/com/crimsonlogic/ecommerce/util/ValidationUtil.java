package com.crimsonlogic.ecommerce.util;

import java.util.regex.Pattern;

public class ValidationUtil {

    private ValidationUtil() {
        // Prevent object creation
    }

    // Name Validation
    public static boolean isValidName(String name) {

        return name != null &&
                name.matches("^[A-Za-z ]{3,30}$");
    }

    // Email Validation
    public static boolean isValidEmail(String email) {

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email != null && Pattern.matches(regex, email);
    }

    // Password Validation
    public static boolean isValidPassword(String password) {

        return password != null &&
                password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,20}$");
    }

    // Phone Number Validation
    public static boolean isValidPhoneNumber(String phoneNumber) {

        return phoneNumber != null &&
                phoneNumber.matches("\\d{10}");
    }

    // Price Validation
    public static boolean isValidPrice(double price) {

        return price > 0;
    }

    // Quantity Validation
    public static boolean isValidQuantity(int quantity) {

        return quantity >= 0;
    }

    // Rating Validation
    public static boolean isValidRating(double rating) {

        return rating >= 1 && rating <= 5;
    }
}