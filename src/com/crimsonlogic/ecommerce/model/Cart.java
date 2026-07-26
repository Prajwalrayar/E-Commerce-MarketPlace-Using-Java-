package com.crimsonlogic.ecommerce.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Cart {

    private int cartId;
    private Customer customer;
    private List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public Cart(int cartId, Customer customer) {
        this.cartId = cartId;
        this.customer = customer;
        this.cartItems = new ArrayList<>();
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    // Add Product
    public void addProduct(Product product, int quantity) {

        Optional<CartItem> existingItem = cartItems.stream()
                .filter(item -> item.getProduct().equals(product))
                .findFirst();

        if (existingItem.isPresent()) {

            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);

        } else {

            cartItems.add(new CartItem(product, quantity));
        }
    }

    // Remove Product
    public boolean removeProduct(int productId) {

        return cartItems.removeIf(item ->
                item.getProduct().getProductId() == productId);
    }

    // Update Quantity
    public boolean updateQuantity(int productId, int quantity) {

        Optional<CartItem> existingItem = cartItems.stream()
                .filter(item -> item.getProduct().getProductId() == productId)
                .findFirst();

        if (existingItem.isPresent()) {

            existingItem.get().setQuantity(quantity);
            return true;
        }

        return false;
    }

    // Total Amount (Stream API)
    public double getTotalAmount() {

        return cartItems.stream()
                .mapToDouble(CartItem::getSubTotal)
                .sum();
    }

    // Total Items
    public int getTotalItems() {

        return cartItems.stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

    // Empty Cart
    public void clearCart() {
        cartItems.clear();
    }

    // Check Empty
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Cart))
            return false;

        Cart cart = (Cart) obj;

        return cartId == cart.cartId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("\n========== SHOPPING CART ==========\n");
        builder.append("Cart ID : ").append(cartId).append("\n");

        if (customer != null) {
            builder.append("Customer : ")
                    .append(customer.getName())
                    .append("\n");
        }

        builder.append("-----------------------------------\n");

        if (cartItems.isEmpty()) {

            builder.append("Cart is Empty.\n");

        } else {

            cartItems.forEach(item ->
                    builder.append(item).append("\n"));
        }

        builder.append("-----------------------------------\n");
        builder.append("Total Items  : ")
                .append(getTotalItems())
                .append("\n");

        builder.append("Total Amount : $")
                .append(getTotalAmount())
                .append("\n");

        builder.append("===================================");

        return builder.toString();
    }

}
