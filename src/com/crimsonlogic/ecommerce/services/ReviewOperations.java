package com.crimsonlogic.ecommerce.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.crimsonlogic.ecommerce.model.Customer;
import com.crimsonlogic.ecommerce.model.Product;
import com.crimsonlogic.ecommerce.model.Review;

public class ReviewOperations {

    private List<Review> reviews;
    private CustomerOperations customerOperations;
    private ProductOperations productOperations;
    private Scanner scanner;

    public ReviewOperations(CustomerOperations customerOperations,
                            ProductOperations productOperations) {
        reviews = new ArrayList<>();
        this.customerOperations = customerOperations;
        this.productOperations = productOperations;
        scanner = new Scanner(System.in);
    }

    public ReviewOperations() {

    }

    private int generateReviewId() {
        return reviews.size() + 1;
    }

    public void addReview() {
        try {
            System.out.print("Enter Customer ID: ");
            int customerId = scanner.nextInt();

            Customer customer = customerOperations.findCustomerById(customerId);
            if (customer == null) {
                System.out.println("Customer not found.");
                return;
            }

            System.out.print("Enter Product ID: ");
            int productId = scanner.nextInt();

            Product product = productOperations.findProductById(productId);
            if (product == null) {
                System.out.println("Product not found.");
                return;
            }

            System.out.print("Enter Rating (1-5): ");
            int rating = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Review Comment: ");
            String comment = scanner.nextLine();

            Review review = new Review(generateReviewId(), customer, product,
                    rating, comment, LocalDate.now());

            reviews.add(review);
            System.out.println("Review added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }

    public void getReviewById() {
        System.out.print("Enter Review ID: ");
        int reviewId = scanner.nextInt();

        Review review = findReviewById(reviewId);

        if (review != null)
            System.out.println(review);
        else
            System.out.println("Review not found.");
    }

    public void getReviewsByProduct() {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();

        boolean found = false;

        for (Review review : reviews) {
            if (review.getProduct().getProductId() == productId) {
                System.out.println(review);
                found = true;
            }
        }

        if (!found)
            System.out.println("No reviews found.");
    }

    public void updateReview() {
        System.out.print("Enter Review ID: ");
        int reviewId = scanner.nextInt();
        scanner.nextLine();

        Review review = findReviewById(reviewId);

        if (review == null) {
            System.out.println("Review not found.");
            return;
        }

        System.out.print("Enter New Rating: ");
        review.setRating(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Enter New Comment: ");
        review.setReviewComment(scanner.nextLine());

        System.out.println("Review updated successfully.");
    }

    public void deleteReview() {
        System.out.print("Enter Review ID: ");
        int reviewId = scanner.nextInt();

        Review review = findReviewById(reviewId);

        if (review == null) {
            System.out.println("Review not found.");
            return;
        }

        reviews.remove(review);
        System.out.println("Review deleted successfully.");
    }

    public void displayAllReviews() {
        if (reviews.isEmpty()) {
            System.out.println("No reviews available.");
            return;
        }

        for (Review review : reviews) {
            System.out.println(review);
        }
    }

    public Review findReviewById(int reviewId) {
        for (Review review : reviews) {
            if (review.getReviewId() == reviewId) {
                return review;
            }
        }
        return null;
    }

    public void getReviewCount() {
        System.out.println("Total Reviews : " + reviews.size());
    }
}
