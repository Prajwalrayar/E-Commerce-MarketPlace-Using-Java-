package com.crimsonlogic.ecommerce.model;

import java.time.LocalDate;
import java.util.Objects;

public class Review {

    private int reviewId;
    private Customer customer;
    private Product product;
    private int rating;
    private String reviewComment;
    private LocalDate reviewDate;

    public Review() {
        this.reviewDate = LocalDate.now();
    }

    public Review(int reviewId,
                  Customer customer,
                  Product product,
                  int rating,
                  String reviewComment,
                  LocalDate reviewDate) {

        this.reviewId = reviewId;
        this.customer = customer;
        this.product = product;
        setRating(rating);
        this.reviewComment = reviewComment;
        this.reviewDate = reviewDate;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {

        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException(
                    "Rating must be between 1 and 5.");
        }

        this.rating = rating;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Review))
            return false;

        Review review = (Review) obj;

        return reviewId == review.reviewId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId);
    }

    @Override
    public String toString() {

        return "\n========== REVIEW ==========" +
                "\nReview ID      : " + reviewId +
                "\nCustomer       : " +
                (customer != null ? customer.getName() : "N/A") +
                "\nProduct        : " +
                (product != null ? product.getProductName() : "N/A") +
                "\nRating         : " + rating + "/5" +
                "\nComment        : " + reviewComment +
                "\nReview Date    : " + reviewDate +
                "\n============================";
    }
}
