package com.crimsonlogic.ecommerce.model;

import com.crimsonlogic.ecommerce.model.abstractclass.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer extends User {
    private double walletBalance;
    private int loyaltyPoints;

    private Wishlist wishlist;
    private List<Order> orderHistory;
    private Cart cart;

    public Customer() {
        this.orderHistory = new ArrayList<>();
        this.cart = new Cart();
        this.wishlist = new Wishlist(this);
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public Customer(int userId,
                    String name,
                    String email,
                    String password,
                    String phoneNumber,
                    String address,
                    LocalDate registrationDate) {

        super(userId,
                name,
                email,
                phoneNumber,
                address,
                registrationDate,
                password);

        this.orderHistory = new ArrayList<>();
        this.cart = new Cart();
        this.wishlist = new Wishlist();
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
    }

    public void addMoney(double amount) {
        walletBalance += amount;
    }

    public boolean deductMoney(double amount) {

        if (walletBalance >= amount) {
            walletBalance -= amount;
            return true;
        }

        return false;
    }

    public void addLoyaltyPoints(int points) {
        loyaltyPoints += points;
    }

    @Override
    public String toString() {

        return "\n========== CUSTOMER ==========\n" +
                super.toString() +
                "\nWallet Balance : " + walletBalance +
                "\nLoyalty Points : " + loyaltyPoints +
                "\nOrders Placed  : " + orderHistory.size() +
                "\n==============================";
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Customer))
            return false;

        Customer customer = (Customer) obj;

        return getUserId() == customer.getUserId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }
}
