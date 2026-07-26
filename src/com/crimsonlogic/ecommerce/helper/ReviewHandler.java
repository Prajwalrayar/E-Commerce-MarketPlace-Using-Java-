package com.crimsonlogic.ecommerce.helper;

import java.util.Scanner;

import com.crimsonlogic.ecommerce.services.ReviewOperations;

public class ReviewHandler {

    private ReviewOperations reviewOperations;
    private Scanner scanner;

    public ReviewHandler(ReviewOperations reviewOperations) {
        this.reviewOperations = reviewOperations;
        this.scanner = new Scanner(System.in);
    }

    public void reviewMenu() {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("      REVIEW MANAGEMENT");
            System.out.println("=================================");
            System.out.println("1. Add Review");
            System.out.println("2. Update Review");
            System.out.println("3. Delete Review");
            System.out.println("4. Display All Reviews");
            System.out.println("5. Total Reviews");
            System.out.println("0. Back");
            System.out.println("=================================");
            System.out.print("Enter Choice : ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    reviewOperations.addReview();
                    break;

                case 2:
                    reviewOperations.updateReview();
                    break;

                case 3:
                    reviewOperations.deleteReview();
                    break;

                case 4:
                    reviewOperations.displayAllReviews();
                    break;

                case 5:
                    reviewOperations.getReviewCount();
                    break;

                case 0:
                    System.out.println("Returning...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);
    }
}
