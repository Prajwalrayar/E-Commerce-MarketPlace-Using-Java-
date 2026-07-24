package com.crimsonlogic.ecommerce.model;

public class Product {
    private String productId;
    private String productName;
    private String description;
    private double price;

    private Category category;
    private Seller seller;
    private Inventory inventory;

    public Product() {
    }

    public Product(String productId, String productName, String description,
                   double price, Category category, Seller seller,
                   Inventory inventory) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.category = category;
        this.seller = seller;
        this.inventory = inventory;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
        this.price = price;
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Product{" + "productId='" + productId +
                '\'' + ", productName='" + productName + '\''
                + ", description='" + description + '\'' + ", price=" + price
                + ", category=" + category + ", seller=" + seller
                + ", inventory=" + inventory + '}';
    }
}
