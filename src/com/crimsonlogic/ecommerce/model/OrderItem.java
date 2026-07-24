package com.crimsonlogic.ecommerce.model;

public class OrderItem {

    private String orderItemId;
    private Product product;
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(String orderItemId, Product product, int quantity) {
        this.orderItemId = orderItemId;
        this.product = product;
        this.quantity = quantity;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
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

    /**
     * Calculates subtotal dynamically.
     */
    public double getSubTotal() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId='" + orderItemId + '\'' +
                ", product=" + product.getProductName() +
                ", quantity=" + quantity +
                ", subTotal=" + getSubTotal() +
                '}';
    }
}
