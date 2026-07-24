package com.crimsonlogic.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
    private Cart cart;
    private List<Order> orders;
    private List<Review> reviews;
    private List<Rating> ratings;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Customer() {
        this.cart = new Cart();
        this.orders = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    public Customer(String userId,
                    String userName,
                    String email,
                    String mobileNumber) {

        super(userId, userName, email, mobileNumber);

        this.cart = new Cart();
        this.orders = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Customer{" + "cart=" + cart + ", orders=" + orders + ", reviews=" + reviews + ", ratings=" + ratings + '}';
    }
}
