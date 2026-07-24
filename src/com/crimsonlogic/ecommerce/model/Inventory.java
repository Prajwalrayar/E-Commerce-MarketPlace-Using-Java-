package com.crimsonlogic.ecommerce.model;

public class Inventory {
    private String inventoryId;
    private Product product;
    private int quantity;

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Inventory() {
    }

    public Inventory(String inventoryId, Product product, int quantity) {
        this.inventoryId = inventoryId;
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" + "inventoryId='"
                + inventoryId + '\'' + ", product="
                + product + ", quantity=" + quantity
                + '}';
    }
}
