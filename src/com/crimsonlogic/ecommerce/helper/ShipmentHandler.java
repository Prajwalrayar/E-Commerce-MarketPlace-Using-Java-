package com.crimsonlogic.ecommerce.helper;

import com.crimsonlogic.ecommerce.services.ShipmentOperations;

import java.util.Scanner;

public class ShipmentHandler {

    private ShipmentOperations shipmentOperations;
    private Scanner scanner;

    public ShipmentHandler(ShipmentOperations shipmentOperations) {
        this.shipmentOperations = shipmentOperations;
        this.scanner = new Scanner(System.in);
    }

    public void shipmentMenu() {

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("       SHIPMENT MANAGEMENT");
            System.out.println("==================================");
            System.out.println("1. Create Shipment");
            System.out.println("2. Get Shipment By ID");
            System.out.println("3. Get Shipment By Order");
            System.out.println("4. Update Shipment Status");
            System.out.println("5. Display All Shipments");
            System.out.println("6. Total Shipments");
            System.out.println("0. Back");
            System.out.println("==================================");
            System.out.print("Enter your choice : ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    shipmentOperations.createShipment();
                    break;

                case 2:
                    shipmentOperations.getShipmentById();
                    break;

                case 3:
                    shipmentOperations.getShipmentByOrder();
                    break;

                case 4:
                    shipmentOperations.updateShipmentStatus();
                    break;

                case 5:
                    shipmentOperations.displayAllShipments();
                    break;

                case 6:
                    shipmentOperations.getShipmentCount();
                    break;

                case 0:
                    System.out.println("Returning...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 0);
    }
}
