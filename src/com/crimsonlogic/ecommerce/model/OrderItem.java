package com.crimsonlogic.ecommerce.model;

import java.util.Objects;

public class OrderItem {

    private Product product;
    private int quantity;
    private double unitPrice;

    public OrderItem() {
    }

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;

        if (product != null) {
            this.unitPrice = product.getPrice();
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {

        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {

        if (unitPrice >= 0) {
            this.unitPrice = unitPrice;
        }
    }

    public double getSubTotal() {
        return unitPrice * quantity;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof OrderItem))
            return false;

        OrderItem other = (OrderItem) obj;

        return Objects.equals(product, other.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }

    @Override
    public String toString() {

        return "\n========== ORDER ITEM ==========" +
                "\nProduct ID   : " + product.getProductId() +
                "\nProduct Name : " + product.getProductName() +
                "\nQuantity     : " + quantity +
                "\nUnit Price   : $" + unitPrice +
                "\nSubtotal     : $" + getSubTotal() +
                "\n===============================";
    }
}
