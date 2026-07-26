package com.crimsonlogic.ecommerce.helper;

import com.crimsonlogic.ecommerce.services.CouponOperations;

import java.util.Scanner;

public class CouponHandler {

    private Scanner sc = new Scanner(System.in);
    private CouponOperations couponOperations;

    public CouponHandler(CouponOperations couponOperations) {
        this.couponOperations = couponOperations;
    }

    public void couponMenu() {

        int ch;

        do {

            System.out.println("\n========== COUPON MENU ==========");
            System.out.println("1. Add Coupon");
            System.out.println("2. Search Coupon");
            System.out.println("3. Update Coupon");
            System.out.println("4. Delete Coupon");
            System.out.println("5. Display All Coupons");
            System.out.println("6. Total Coupons");
            System.out.println("0. Back");

            System.out.print("Enter Choice : ");
            ch = sc.nextInt();

            switch (ch) {

                case 1:
                    couponOperations.addCoupon();
                    break;

                case 2:
                    couponOperations.getCouponByCode();
                    break;

                case 3:
                    couponOperations.updateCoupon();
                    break;

                case 4:
                    couponOperations.deleteCoupon();
                    break;

                case 5:
                    couponOperations.displayAllCoupons();
                    break;

                case 6:
                    System.out.println("Total Coupons : "
                            + couponOperations.getCouponCount());
                    break;

                case 0:
                    System.out.println("Returning...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (ch != 0);
    }
}