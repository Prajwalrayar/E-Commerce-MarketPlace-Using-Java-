package com.crimsonlogic.ecommerce.model;

import java.time.LocalDate;
import java.util.Objects;

public class Inventory {
    private int inventoryId;
    private Product product;
    private int availableQuantity;
    private int reorderLevel;
    private LocalDate lastUpdated;

    public Inventory() {
    }

    public Inventory(int inventoryId, Product product, int availableQuantity, int reorderLevel, LocalDate lastUpdated) {

        this.inventoryId = inventoryId;
        this.product = product;
        this.availableQuantity = availableQuantity;
        this.reorderLevel = reorderLevel;
        this.lastUpdated = lastUpdated;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {

        if (availableQuantity >= 0) {
            this.availableQuantity = availableQuantity;
        }
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {

        if (reorderLevel >= 0) {
            this.reorderLevel = reorderLevel;
        }
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void restock(int quantity) {

        if (quantity > 0) {
            availableQuantity += quantity;
            lastUpdated = LocalDate.now();
        }
    }

    public boolean reduceStock(int quantity) {

        if (quantity > 0 && availableQuantity >= quantity) {

            availableQuantity -= quantity;
            lastUpdated = LocalDate.now();
            return true;
        }

        return false;
    }

    public boolean isOutOfStock() {
        return availableQuantity == 0;
    }

    public boolean isLowStock() {
        return availableQuantity <= reorderLevel;
    }

    public String getStockStatus() {

        if (availableQuantity == 0) {
            return "OUT OF STOCK";
        }

        if (availableQuantity <= reorderLevel) {
            return "LOW STOCK";
        }

        return "IN STOCK";
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Inventory)) return false;

        Inventory inventory = (Inventory) obj;

        return inventoryId == inventory.inventoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId);
    }

    @Override
    public String toString() {

        return "\n========== INVENTORY ==========" + "\nInventory ID      : " + inventoryId + "\nProduct           : " + (product != null ? product.getProductName() : "N/A") + "\nAvailable Quantity: " + availableQuantity + "\nReorder Level     : " + reorderLevel + "\nStock Status      : " + getStockStatus() + "\nLast Updated      : " + lastUpdated + "\n===============================";
    }
}
