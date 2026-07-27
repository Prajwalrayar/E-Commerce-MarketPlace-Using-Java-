package com.crimsonlogic.ecommerce.helper;

import com.crimsonlogic.ecommerce.services.OrderOperations;

import java.util.Scanner;

public class OrderHandler {

    private OrderOperations orderOperations;
    private Scanner scanner;

    public OrderHandler(OrderOperations orderOperations) {

        this.orderOperations = orderOperations;
        this.scanner = new Scanner(System.in);
    }

    public void orderMenu() {

        int choice;

        do {

            System.out.println("\n========== ORDER MENU ==========");
            System.out.println("1. Place Order");
            System.out.println("2. Search Order");
            System.out.println("3. Display Customer Orders");
            System.out.println("4. Display All Orders");
            System.out.println("5. Confirm Order");
            System.out.println("6. Pack Order");
            System.out.println("7. Ship Order");
            System.out.println("8. Mark Out For Delivery");
            System.out.println("9. Deliver Order");
            System.out.println("10. Cancel Order");
            System.out.println("11. Total Orders");
            System.out.println("12. Total Pending Orders");
            System.out.println("13. Display Delivered Orders");
            System.out.println("14. Display Cancelled Orders");
            System.out.println("15. Display Confirmed Orders");
            System.out.println("0. Back");

            System.out.print("Enter your choice : ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    orderOperations.placeOrder();
                    break;

                case 2:
                    orderOperations.getOrderById();
                    break;

                case 3:
                    orderOperations.displayCustomerOrders();
                    break;

                case 4:
                    orderOperations.displayAllOrders();
                    break;

                case 5:
                    orderOperations.confirmOrder();
                    break;

                case 6:
                    orderOperations.packOrder();
                    break;

                case 7:
                    orderOperations.shipOrder();
                    break;

                case 8:
                    orderOperations.markOutForDelivery();
                    break;

                case 9:
                    orderOperations.deliverOrder();
                    break;

                case 10:
                    orderOperations.cancelOrder();
                    break;

                case 11:
                    orderOperations.getOrderCount();
                    break;

                case 12:
                    orderOperations.pendingOrdersCount();
                    break;

                case 13:
                    orderOperations.displayDeliveredOrders();
                    break;

                case 14:
                    orderOperations.displayCancelledOrders();
                    break;

                case 15:
                    orderOperations.displayConfirmedOrders();
                    break;

                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid Choice! Please try again.");
            }

        } while (choice != 0);
    }
}