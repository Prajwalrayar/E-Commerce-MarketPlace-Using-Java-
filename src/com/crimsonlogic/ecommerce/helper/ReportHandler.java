package com.crimsonlogic.ecommerce.helper;

import com.crimsonlogic.ecommerce.services.ReportOperations;

import java.util.Scanner;

public class ReportHandler {
    private ReportOperations reportOperations;
    private Scanner scanner;

    public ReportHandler(ReportOperations reportOperations) {
        this.reportOperations = reportOperations;
        this.scanner = new Scanner(System.in);
    }

    public void reportMenu() {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("       REPORT MANAGEMENT");
            System.out.println("=================================");
            System.out.println("1. Customer Report");
            System.out.println("2. Seller Report");
            System.out.println("3. Product Report");
            System.out.println("4. Inventory Report");
            System.out.println("5. Order Report");
            System.out.println("0. Back");
            System.out.println("=================================");
            System.out.print("Enter Choice : ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    reportOperations.customerReport();
                    break;

                case 2:
                    reportOperations.sellerReport();
                    break;

                case 3:
                    reportOperations.productReport();
                    break;

                case 4:
                    reportOperations.inventoryReport();
                    break;

                case 5:
                    reportOperations.orderReport();
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
