package com.crimsonlogic.ecommerce.model;

import java.util.Objects;

public class CartItem {

    private Product product;
    private int quantity;

    public CartItem() {
    }

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
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

        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    public double getSubTotal() {

        if (product == null) {
            return 0.0;
        }

        return product.getPrice() * quantity;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof CartItem))
            return false;

        CartItem cartItem = (CartItem) obj;

        return Objects.equals(product, cartItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }

    @Override
    public String toString() {

        return "\n========== CART ITEM ==========" +
                "\nProduct ID   : " + product.getProductId() +
                "\nProduct Name : " + product.getProductName() +
                "\nUnit Price   : $" + product.getPrice() +
                "\nQuantity     : " + quantity +
                "\nSubtotal     : $" + getSubTotal() +
                "\n===============================";
    }
}
