package com.crimsonlogic.ecommerce.helper;

import com.crimsonlogic.ecommerce.services.AdminOperations;

import java.util.Scanner;

public class AdminHandler {
    private AdminOperations adminOperations;
    private Scanner scanner;

    public AdminHandler(AdminOperations adminOperations) {
        this.adminOperations = adminOperations;
        this.scanner = new Scanner(System.in);
    }

    public void adminMenu() {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("        ADMIN PANEL");
            System.out.println("=================================");
            System.out.println("1. View All Customers");
            System.out.println("2. View All Sellers");
            System.out.println("3. View All Products");
            System.out.println("4. View All Inventories");
            System.out.println("5. View All Orders");
            System.out.println("6. View Reports");
            System.out.println("0. Back");
            System.out.println("=================================");
            System.out.print("Enter Choice : ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    adminOperations.viewCustomers();
                    break;

                case 2:
                    adminOperations.viewSellers();
                    break;

                case 3:
                    adminOperations.viewProducts();
                    break;

                case 4:
                    adminOperations.viewInventories();
                    break;

                case 5:
                    adminOperations.viewOrders();
                    break;

                case 6:
                    adminOperations.viewReports();
                    break;

                case 0:
                    System.out.println("Returning...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);
    }
}

