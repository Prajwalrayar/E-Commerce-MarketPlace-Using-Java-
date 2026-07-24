package com.crimsonlogic.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private String cartId;
    private List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public Cart(String cartId) {
        this.cartId = cartId;
        this.cartItems = new ArrayList<>();
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {

        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", totalItems=" + cartItems.size() +
                '}';
    }

}
