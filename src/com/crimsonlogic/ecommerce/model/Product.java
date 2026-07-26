package com.crimsonlogic.ecommerce.model;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    int productId;
    private String productName;
    private String brand;
    private String description;
    private double price;
    private int quantity;
    private double rating;
    private Category category;
    private Seller seller;
    private LocalDate dateAdded;

    public Product() {
    }

    public Product(int productId,
                   String productName,
                   String brand,
                   String description,
                   double price,
                   int quantity,
                   double rating,
                   Category category,
                   Seller seller,
                   LocalDate dateAdded) {

        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.rating = rating;
        this.category = category;
        this.seller = seller;
        this.dateAdded = dateAdded;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        if (price >= 0) {
            this.price = price;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {

        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {

        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void increaseStock(int qty) {
        if (qty > 0) {
            quantity += qty;
        }
    }

    public boolean decreaseStock(int qty) {

        if (qty > 0 && quantity >= qty) {
            quantity -= qty;
            return true;
        }

        return false;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Product))
            return false;

        Product product = (Product) obj;

        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {

        return "\n========== PRODUCT ==========" +
                "\nProduct ID     : " + productId +
                "\nName           : " + productName +
                "\nBrand          : " + brand +
                "\nDescription    : " + description +
                "\nPrice          : $" + price +
                "\nQuantity       : " + quantity +
                "\nRating         : " + rating +
                "\nCategory       : " +
                (category != null ? category.getCategoryName() : "N/A") +
                "\nSeller         : " +
                (seller != null ? seller.getName() : "N/A") +
                "\nDate Added     : " + dateAdded +
                "\n=============================";
    }
}
