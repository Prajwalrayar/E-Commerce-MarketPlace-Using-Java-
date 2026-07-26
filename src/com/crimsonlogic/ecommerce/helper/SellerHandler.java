package com.crimsonlogic.ecommerce.helper;

import com.crimsonlogic.ecommerce.services.SellerOperations;

import java.util.Scanner;

public class SellerHandler {

    private Scanner sc;
    private SellerOperations sellerOperations;

    public SellerHandler(SellerOperations sellerOperations) {
        this.sellerOperations = sellerOperations;
        this.sc = new Scanner(System.in);
    }

    public void sellerMenu() {

        int choice;

        do {

            System.out.println("\n========== SELLER MENU ==========");
            System.out.println("1. Register Seller");
            System.out.println("2. Search Seller");
            System.out.println("3. Update Seller");
            System.out.println("4. Delete Seller");
            System.out.println("5. Display All Sellers");
            System.out.println("0. Back");
            System.out.print("Enter Your Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sellerOperations.addSeller();
                    break;

                case 2:
                    sellerOperations.getSellerById();
                    break;

                case 3:
                    sellerOperations.updateSeller();
                    break;

                case 4:
                    sellerOperations.deleteSeller();
                    break;

                case 5:
                    sellerOperations.displayAllSellers();
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