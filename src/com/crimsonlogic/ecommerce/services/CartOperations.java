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

            Customer customer;

            while (true) {

                System.out.print("Enter Customer ID : ");

                if (scanner.hasNextInt()) {

                    int customerId = scanner.nextInt();

                    try {
                        customer = customerOperations.findCustomerById(customerId);
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid Customer ID! Please enter a valid Customer ID.");
                    }

                } else {

                    System.out.println("Invalid Customer ID! Please enter numbers only.");
                    scanner.nextLine();
                }
            }

            Product product;

            while (true) {

                System.out.print("Enter Product ID : ");

                if (scanner.hasNextInt()) {

                    int productId = scanner.nextInt();

                    try {
                        product = productOperations.findProductById(productId);
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid Product ID! Please enter a valid Product ID.");
                    }

                } else {

                    System.out.println("Invalid Product ID! Please enter numbers only.");
                    scanner.nextLine();
                }
            }

            int quantity;

            while (true) {

                System.out.print("Enter Quantity : ");

                if (scanner.hasNextInt()) {

                    quantity = scanner.nextInt();

                    if (quantity <= 0) {
                        System.out.println("Quantity must be greater than zero.");
                        continue;
                    }

                    if (product.getQuantity() < quantity) {
                        System.out.println("Product is out of stock or insufficient quantity available.");
                        continue;
                    }

                    break;

                } else {

                    System.out.println("Invalid Quantity! Please enter numbers only.");
                    scanner.nextLine();
                }
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