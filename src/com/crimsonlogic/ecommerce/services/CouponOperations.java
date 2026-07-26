package com.crimsonlogic.ecommerce.services;

import com.crimsonlogic.ecommerce.exceptions.DuplicateDataException;
import com.crimsonlogic.ecommerce.model.Coupon;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CouponOperations {

    private Map<String, Coupon> coupons;
    private Scanner scanner;

    public CouponOperations() {
        coupons = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    // Add Coupon
    public void addCoupon() {

        try {

            String couponCode;

            while (true) {

                System.out.print("Enter Coupon Code : ");
                couponCode = scanner.next().trim().toUpperCase();

                if (couponCode.isEmpty()) {
                    System.out.println("Coupon Code cannot be empty.");
                } else if (coupons.containsKey(couponCode)) {
                    System.out.println("Coupon Code already exists. Please enter another code.");
                } else {
                    break;
                }
            }

            double discountPercentage;

            while (true) {

                System.out.print("Enter Discount Percentage : ");

                if (scanner.hasNextDouble()) {

                    discountPercentage = scanner.nextDouble();

                    if (discountPercentage >= 0 && discountPercentage <= 100) {
                        break;
                    }

                    System.out.println("Discount Percentage must be between 0 and 100.");

                } else {

                    System.out.println("Invalid Discount Percentage! Please enter numbers only.");
                    scanner.next();
                }
            }

            double minimumPurchase;

            while (true) {

                System.out.print("Enter Minimum Purchase Amount : ");

                if (scanner.hasNextDouble()) {

                    minimumPurchase = scanner.nextDouble();

                    if (minimumPurchase >= 0) {
                        break;
                    }

                    System.out.println("Minimum Purchase Amount cannot be negative.");

                } else {

                    System.out.println("Invalid Amount! Please enter numbers only.");
                    scanner.next();
                }
            }

            LocalDate expiryDate;

            while (true) {

                System.out.print("Enter Expiry Date (yyyy-mm-dd) : ");
                String date = scanner.next();

                try {

                    expiryDate = LocalDate.parse(date);

                    if (expiryDate.isBefore(LocalDate.now())) {
                        System.out.println("Expiry Date cannot be in the past.");
                    } else {
                        break;
                    }

                } catch (Exception e) {

                    System.out.println("Invalid Date! Please use yyyy-mm-dd format.");
                }
            }

            Coupon coupon = new Coupon(
                    couponCode,
                    discountPercentage,
                    minimumPurchase,
                    expiryDate
            );

            coupons.put(couponCode, coupon);

            System.out.println("Coupon added successfully.");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    // Search Coupon
    public void getCouponByCode() {

        try {

            System.out.print("Enter Coupon Code : ");
            String couponCode = scanner.next();

            Coupon coupon = findCouponByCode(couponCode);

            System.out.println(coupon);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Helper Method
    public Coupon findCouponByCode(String couponCode) {

        Coupon coupon = coupons.get(couponCode);

        if (coupon == null) {
            throw new IllegalArgumentException("Coupon not found.");
        }

        return coupon;
    }

    // Update Coupon
    public void updateCoupon() {

        try {

            System.out.print("Enter Coupon Code : ");
            String couponCode = scanner.next();

            Coupon coupon = findCouponByCode(couponCode);

            System.out.println("Current Coupon Details");
            System.out.println(coupon);

            System.out.print("Enter New Discount Percentage : ");
            coupon.setDiscountPercentage(scanner.nextDouble());

            System.out.print("Enter New Minimum Purchase Amount : ");
            coupon.setMinimumPurchase(scanner.nextDouble());

            System.out.print("Enter New Expiry Date (yyyy-mm-dd) : ");
            coupon.setExpiryDate(LocalDate.parse(scanner.next()));

            System.out.println("Coupon updated successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Delete Coupon
    public void deleteCoupon() {

        try {

            System.out.print("Enter Coupon Code : ");
            String couponCode = scanner.next();

            findCouponByCode(couponCode);

            coupons.remove(couponCode);

            System.out.println("Coupon deleted successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Display All Coupons
    public void displayAllCoupons() {

        if (coupons.isEmpty()) {
            System.out.println("No coupons available.");
            return;
        }

        System.out.println("\n========== ALL COUPONS ==========");

        for (Coupon coupon : coupons.values()) {
            System.out.println(coupon);
            System.out.println("--------------------------------");
        }
    }


    public boolean couponExists(String couponCode) {
        return coupons.containsKey(couponCode);
    }

    public int getCouponCount() {
        return coupons.size();
    }
}