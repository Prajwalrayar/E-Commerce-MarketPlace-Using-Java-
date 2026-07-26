package com.crimsonlogic.ecommerce.services;

import com.crimsonlogic.ecommerce.exceptions.InvalidQuantityException;
import com.crimsonlogic.ecommerce.exceptions.OutOfStockException;
import com.crimsonlogic.ecommerce.model.Cart;
import com.crimsonlogic.ecommerce.model.Customer;
import com.crimsonlogic.ecommerce.model.Product;

import java.util.Scanner;

public class CartOperations {

    private CustomerOperations customerOperations;
    private ProductOperations productOperations;
    private Scanner scanner = new Scanner(System.in);

    public CartOperations(CustomerOperations customerOperations,
                          ProductOperations productOperations) {

        this.customerOperations = customerOperations;
        this.productOperations = productOperations;
    }

    // Add Product to Cart
    public void addProductToCart() {

        try {

            System.out.print("Enter Customer ID : ");
            int customerId = scanner.nextInt();

            Customer customer =
                    customerOperations.findCustomerById(customerId);

            System.out.print("Enter Product ID : ");
            int productId = scanner.nextInt();

            Product product =
                    productOperations.findProductById(productId);

            System.out.print("Enter Quantity : ");
            int quantity = scanner.nextInt();

            if (quantity <= 0) {
                throw new InvalidQuantityException("Invalid Quantity.");
            }

            if (product.getQuantity() < quantity) {
                throw new OutOfStockException("Product is out of stock.");
            }

            customer.getCart().addProduct(product, quantity);

            System.out.println("Product added to cart successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Remove Product
    public void removeProductFromCart() {

        try {

            System.out.print("Enter Customer ID : ");
            int customerId = scanner.nextInt();

            Customer customer =
                    customerOperations.findCustomerById(customerId);

            System.out.print("Enter Product ID : ");
            int productId = scanner.nextInt();

            if (customer.getCart().removeProduct(productId)) {

                System.out.println("Product removed successfully.");

            } else {

                System.out.println("Product not found in cart.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Update Quantity
    public void updateProductQuantity() {

        try {

            System.out.print("Enter Customer ID : ");
            int customerId = scanner.nextInt();

            Customer customer =
                    customerOperations.findCustomerById(customerId);

            System.out.print("Enter Product ID : ");
            int productId = scanner.nextInt();

            System.out.print("Enter New Quantity : ");
            int quantity = scanner.nextInt();

            if (quantity <= 0) {
                throw new InvalidQuantityException("Invalid Quantity.");
            }

            if (customer.getCart().updateQuantity(productId, quantity)) {

                System.out.println("Quantity updated successfully.");

            } else {

                System.out.println("Product not found in cart.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // View Cart
    public void viewCart() {

        try {

            System.out.print("Enter Customer ID : ");
            int customerId = scanner.nextInt();

            Customer customer =
                    customerOperations.findCustomerById(customerId);

            System.out.println(customer.getCart());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Clear Cart
    public void clearCart() {

        try {

            System.out.print("Enter Customer ID : ");
            int customerId = scanner.nextInt();

            Customer customer =
                    customerOperations.findCustomerById(customerId);

            customer.getCart().clearCart();

            System.out.println("Cart cleared successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Total Amount
    public void getCartTotal() {

        try {

            System.out.print("Enter Customer ID : ");
            int customerId = scanner.nextInt();

            Customer customer =
                    customerOperations.findCustomerById(customerId);

            System.out.println("Total Amount : "
                    + customer.getCart().getTotalAmount());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Total Items
    public void getTotalItems() {

        try {

            System.out.print("Enter Customer ID : ");
            int customerId = scanner.nextInt();

            Customer customer =
                    customerOperations.findCustomerById(customerId);

            System.out.println("Total Items : "
                    + customer.getCart().getTotalItems());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Is Cart Empty
    public void isCartEmpty() {

        try {

            System.out.print("Enter Customer ID : ");
            int customerId = scanner.nextInt();

            Customer customer =
                    customerOperations.findCustomerById(customerId);

            if (customer.getCart().isEmpty()) {

                System.out.println("Cart is empty.");

            } else {

                System.out.println("Cart contains items.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}