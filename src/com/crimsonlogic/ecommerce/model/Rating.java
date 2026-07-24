package com.crimsonlogic.ecommerce.model;

import java.time.LocalDate;

public class Rating {

    private String ratingId;
    private Customer customer;
    private Product product;
    private int ratingValue;
    private LocalDate ratingDate;

    public Rating() {
    }

    public Rating(String ratingId,
                  Customer customer,
                  Product product,
                  int ratingValue,
                  LocalDate ratingDate) {

        this.ratingId = ratingId;
        this.customer = customer;
        this.product = product;
        this.ratingValue = ratingValue;
        this.ratingDate = ratingDate;
    }

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
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

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }

    public LocalDate getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(LocalDate ratingDate) {
        this.ratingDate = ratingDate;
    }

    @Override
    public String toString() {

        return "Rating{" +
                "ratingId='" + ratingId + '\'' +
                ", customer='" + customer.getUserName() + '\'' +
                ", product='" + product.getProductName() + '\'' +
                ", ratingValue=" + ratingValue +
                ", ratingDate=" + ratingDate +
                '}';
    }

}
