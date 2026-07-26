package com.crimsonlogic.ecommerce.model;

import com.crimsonlogic.ecommerce.model.abstractclass.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Seller extends User {

    private String companyName;
    private double sellerRating;
    private List<Product> products;
    private double totalRevenue;

    public Seller() {
        this.products = new ArrayList<>();
    }

    public Seller(int userId, String name, String email, String password, String phoneNumber,
            String address, LocalDate registrationDate, String companyName){

        super(userId, name, email, phoneNumber, address, registrationDate, password);

        this.companyName = companyName;
        this.products = new ArrayList<>();
        this.totalRevenue = 0.0;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void addRevenue(double amount) {
        totalRevenue += amount;
    }

    @Override
    public String toString() {

        return "\n========== SELLER ==========\n" +
                super.toString() +
                "\nCompany Name   : " + companyName +
                "\nSeller Rating : " + sellerRating +
                "\nProducts      : " + products.size() +
                "\nRevenue       : " + totalRevenue +
                "\n============================";
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Seller))
            return false;

        Seller seller = (Seller) obj;

        return getUserId() == seller.getUserId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }
}
