package com.crimsonlogic.ecommerce.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Category {

    private int categoryId;
    private String categoryName;
    private String description;
    private List<Product> products;

    public Category() {
        this.products = new ArrayList<>();
    }

    public Category(int categoryId, String categoryName, String description) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.products = new ArrayList<>();
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        if (product != null && !products.contains(product)) {
            products.add(product);
        }
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public int getTotalProducts() {
        return products.size();
    }

    @Override
    public String toString() {

        return "\n========== CATEGORY ==========" +
                "\nCategory ID   : " + categoryId +
                "\nCategory Name : " + categoryName +
                "\nDescription   : " + description +
                "\nProducts       : " + products.size() +
                "\n==============================";
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Category))
            return false;

        Category category = (Category) obj;

        return categoryId == category.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId);
    }
}
