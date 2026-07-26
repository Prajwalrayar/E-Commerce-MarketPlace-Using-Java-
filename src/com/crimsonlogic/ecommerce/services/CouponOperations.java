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

            System.out.print("Enter Coupon Code : ");
            String couponCode = scanner.next();

            if (coupons.containsKey(couponCode)) {
                throw new DuplicateDataException("Coupon already exists.");
            }

            System.out.print("Enter Discount Percentage : ");
            double discountPercentage = scanner.nextDouble();

            System.out.print("Enter Minimum Purchase Amount : ");
            double minimumPurchase = scanner.nextDouble();

            System.out.print("Enter Expiry Date (yyyy-mm-dd) : ");
            LocalDate expiryDate = LocalDate.parse(scanner.next());

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