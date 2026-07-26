package com.crimsonlogic.ecommerce.services;

import com.crimsonlogic.ecommerce.model.Customer;
import com.crimsonlogic.ecommerce.model.Product;

import java.util.Scanner;

public class WishlistOperations {

    private CustomerOperations customerOperations;
    private ProductOperations productOperations;
    private Scanner scanner = new Scanner(System.in);

    public WishlistOperations(CustomerOperations customerOperations,
                              ProductOperations productOperations) {

        this.customerOperations = customerOperations;
        this.productOperations = productOperations;
    }

    // Add Product to Wishlist
    public void addProductToWishlist() {

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

            customer.getWishlist().addProduct(product);

            System.out.println("Product added to wishlist successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Remove Product
    public void removeProductFromWishlist() {

        try {

            System.out.print("Enter Customer ID : ");
            int customerId = scanner.nextInt();

            Customer customer =
                    customerOperations.findCustomerById(customerId);

            System.out.print("Enter Product ID : ");
            int productId = scanner.nextInt();

            customer.getWishlist().removeProduct(productId);

            System.out.println("Product removed successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // View Wishlist
    public void viewWishlist() {

        try {

            System.out.print("Enter Customer ID : ");
            int customerId = scanner.nextInt();

            Customer customer =
                    customerOperations.findCustomerById(customerId);

            System.out.println(customer.getWishlist());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Clear Wishlist
    public void clearWishlist() {

        try {

            System.out.print("Enter Customer ID : ");
            int customerId = scanner.nextInt();

            Customer customer =
                    customerOperations.findCustomerById(customerId);

            customer.getWishlist().getProducts().clear();

            System.out.println("Wishlist cleared successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Total Wishlist Items
    public void getWishlistItemCount() {

        try {

            System.out.print("Enter Customer ID : ");
            int customerId = scanner.nextInt();

            Customer customer =
                    customerOperations.findCustomerById(customerId);

            System.out.println("Total Wishlist Items : "
                    + customer.getWishlist().getProducts().size());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Check Wishlist Empty
    public void isWishlistEmpty() {

        try {

            System.out.print("Enter Customer ID : ");
            int customerId = scanner.nextInt();

            Customer customer =
                    customerOperations.findCustomerById(customerId);

            if (customer.getWishlist().getProducts().isEmpty()) {
                System.out.println("Wishlist is empty.");
            } else {
                System.out.println("Wishlist contains products.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}