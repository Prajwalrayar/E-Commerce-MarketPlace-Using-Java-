package com.crimsonlogic.ecommerce.helper;

import java.util.Scanner;

import com.crimsonlogic.ecommerce.services.PaymentOperations;

public class PaymentHandler {

    private PaymentOperations paymentOperations;
    private Scanner scanner;

    public PaymentHandler(PaymentOperations paymentOperations) {

        this.paymentOperations = paymentOperations;
        this.scanner = new Scanner(System.in);
    }

    public void paymentMenu() {

        int choice;

        do {

            System.out.println("\n========== PAYMENT MENU ==========");
            System.out.println("1. Process Payment");
            System.out.println("2. Search Payment");
            System.out.println("3. Search Payment By Order");
            System.out.println("4. Display All Payments");
            System.out.println("5. Total Payments");
            System.out.println("0. Back");
            System.out.print("Enter Choice : ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    paymentOperations.processPayment();
                    break;

                case 2:
                    paymentOperations.getPaymentById();
                    break;

                case 3:
                    paymentOperations.getPaymentByOrder();
                    break;

                case 4:
                    paymentOperations.displayAllPayments();
                    break;

                case 5:
                    paymentOperations.getPaymentCount();
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