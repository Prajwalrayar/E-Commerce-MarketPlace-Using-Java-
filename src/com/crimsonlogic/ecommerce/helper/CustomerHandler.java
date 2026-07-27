package com.crimsonlogic.ecommerce.helper;

import com.crimsonlogic.ecommerce.services.CartOperations;
import com.crimsonlogic.ecommerce.services.CustomerOperations;
import com.crimsonlogic.ecommerce.services.WishlistOperations;

import java.util.Scanner;

public class CustomerHandler {

    private Scanner sc = new Scanner(System.in);

    private CustomerOperations customerOperations;
    private CartOperations cartOperations;
    private WishlistOperations wishlistOperations;

    public CustomerHandler(CustomerOperations customerOperations,
                           CartOperations cartOperations,
                           WishlistOperations wishlistOperations) {

        this.customerOperations = customerOperations;
        this.cartOperations = cartOperations;
        this.wishlistOperations = wishlistOperations;
    }

    public void customerMenu() {

        int ch;

        do {

            System.out.println("\n========== CUSTOMER MENU ==========");
            System.out.println("1. Register Customer");
            System.out.println("2. Search Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Display All Customers");
            System.out.println("6. Cart Menu");
            System.out.println("7. Wishlist Menu");
            System.out.println("8. Customers with Orders");
            System.out.println("9. Total number of Customers");
            System.out.println("10. Customers Without Orders");
            System.out.println("0. Back");
            System.out.print("Enter Your Choice : ");

            ch = sc.nextInt();

            switch (ch) {

                case 1:
                    customerOperations.addCustomer();
                    break;

                case 2:
                    customerOperations.getCustomerById();
                    break;

                case 3:
                    customerOperations.updateCustomer();
                    break;

                case 4:
                    customerOperations.deleteCustomer();
                    break;

                case 5:
                    customerOperations.displayAllCustomers();
                    break;

                case 6:
                    cartMenu();
                    break;

                case 7:
                    wishlistMenu();
                    break;

                case 8:
                    customerOperations.customersWithOrders();
                    break;

                case 9:
                    customerOperations.getCustomerCount();
                    break;

                case 10:
                    customerOperations.displayCustomersWithoutOrders();
                    break;

                case 0:
                    System.out.println("Returning...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (ch != 0);
    }

    public void cartMenu() {

        int choice;

        do {

            System.out.println("\n========== CART MENU ==========");
            System.out.println("1. View Cart");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Update Product Quantity");
            System.out.println("5. Clear Cart");
            System.out.println("6. Total Items");
            System.out.println("7. Total Amount");
            System.out.println("0. Back");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    cartOperations.viewCart();
                    break;

                case 2:
                    cartOperations.addProductToCart();
                    break;

                case 3:
                    cartOperations.removeProductFromCart();
                    break;

                case 4:
                    cartOperations.updateProductQuantity();
                    break;

                case 5:
                    cartOperations.clearCart();
                    break;

                case 6:
                    cartOperations.getTotalItems();
                    break;

                case 7:
                    cartOperations.getCartTotal();
                    break;

                case 0:
                    System.out.println("Returning...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 0);
    }

    public void wishlistMenu() {

        int choice;

        do {

            System.out.println("\n========== WISHLIST MENU ==========");
            System.out.println("1. View Wishlist");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Clear Wishlist");
            System.out.println("5. Total Wishlist Items");
            System.out.println("6. Is Wishlist Empty");
            System.out.println("0. Back");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    wishlistOperations.viewWishlist();
                    break;

                case 2:
                    wishlistOperations.addProductToWishlist();
                    break;

                case 3:
                    wishlistOperations.removeProductFromWishlist();
                    break;

                case 4:
                    wishlistOperations.clearWishlist();
                    break;

                case 5:
                    wishlistOperations.getWishlistItemCount();
                    break;

                case 6:
                    wishlistOperations.isWishlistEmpty();
                    break;

                case 0:
                    System.out.println("Returning...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 0);
    }
}