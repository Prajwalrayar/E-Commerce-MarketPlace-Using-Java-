package com.crimsonlogic.ecommerce.model;

import java.time.LocalDate;

public class Review {

    private String reviewId;
    private Customer customer;
    private Product product;
    private String reviewDescription;
    private LocalDate reviewDate;

    public Review() {
    }

    public Review(String reviewId, Customer customer,
                  Product product, String reviewDescription,
                  LocalDate reviewDate) {

        this.reviewId = reviewId;
        this.customer = customer;
        this.product = product;
        this.reviewDescription = reviewDescription;
        this.reviewDate = reviewDate;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
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

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", customer='" + customer.getUserName() + '\'' +
                ", product='" + product.getProductName() + '\'' +
                ", reviewDescription='" + reviewDescription + '\'' +
                ", reviewDate=" + reviewDate +
                '}';
    }

}
