package com.crimsonlogic.ecommerce.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Wishlist {
    private int wishlistId;
    private Customer customer;
    private List<Product> products;

    public Wishlist() {
        products = new ArrayList<>();
    }

    public Wishlist(int wishlistId, Customer customer) {
        this.wishlistId = wishlistId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {

        Optional<Product> existing = products.stream()
                .filter(p -> p.equals(product))
                .findFirst();

        if (existing.isEmpty()) {
            products.add(product);
        }
    }

    public void removeProduct(int productId) {

        products.removeIf(product ->
                product.getProductId() == productId);
    }

    @Override
    public boolean equals(Object obj) {

        if(this==obj)
            return true;

        if(!(obj instanceof Wishlist))
            return false;

        Wishlist wishlist=(Wishlist)obj;

        return wishlistId==wishlist.wishlistId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wishlistId);
    }

    @Override
    public String toString() {

        return "\nWishlist ID : "+wishlistId+
                "\nCustomer : "+customer.getName()+
                "\nProducts : "+products.size();
    }
}
