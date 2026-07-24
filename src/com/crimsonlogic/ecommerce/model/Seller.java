package com.crimsonlogic.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User{

    private String storeName;
    private List<Product> products;
    private List<Rating> ratings;

    public Seller() {
        this.products = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    public Seller(String userId, String userName, String email,
                  String mobileNumber, String storeName) {

        super(userId, userName, email, mobileNumber);

        this.storeName = storeName;
        this.products = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerId='" + getUserId() + '\'' +
                ", sellerName='" + getUserName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", mobileNumber='" + getMobileNumber() + '\'' +
                ", storeName='" + storeName + '\'' +
                ", totalProducts=" + products.size() +
                ", totalRatings=" + ratings.size() +
                '}';
    }
}
