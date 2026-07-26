package com.crimsonlogic.ecommerce.util;

import java.util.regex.Pattern;

public class ValidationUtil {

    private ValidationUtil() {
        // Prevent object creation
    }

    public static boolean isValidEmail(String email) {

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && Pattern.matches(regex, email);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {

        return phoneNumber != null &&
                phoneNumber.matches("\\d{10}");
    }

    public static boolean isValidPrice(double price) {

        return price > 0;
    }

    public static boolean isValidQuantity(int quantity) {

        return quantity >= 0;
    }

    public static boolean isValidRating(double rating) {

        return rating >= 1 && rating <= 5;
    }

    public static boolean isValidName(String name) {

        return name != null &&
                !name.trim().isEmpty();
    }

    public static boolean isValidPassword(String password) {

        return password != null &&
                password.length() >= 8;
    }
}
