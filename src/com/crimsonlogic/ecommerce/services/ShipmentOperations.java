package com.crimsonlogic.ecommerce.services;

import com.crimsonlogic.ecommerce.enums.ShipmentStatus;
import com.crimsonlogic.ecommerce.exceptions.OrderNotFoundException;
import com.crimsonlogic.ecommerce.exceptions.ShipmentNotFoundException;
import com.crimsonlogic.ecommerce.model.Order;
import com.crimsonlogic.ecommerce.model.Shipment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShipmentOperations {

    private List<Shipment> shipments;

    private OrderOperations orderOperations;

    private Scanner scanner;

    public ShipmentOperations(OrderOperations orderOperations) {

        this.shipments = new ArrayList<>();
        this.orderOperations = orderOperations;
        this.scanner = new Scanner(System.in);
    }

    // Generate Shipment ID
    private int generateShipmentId() {

        int maxId = 0;

        for (Shipment shipment : shipments) {

            if (shipment.getShipmentId() > maxId) {
                maxId = shipment.getShipmentId();
            }
        }

        return maxId + 1;
    }

    // Create Shipment
    public void createShipment() {

        try {

            System.out.print("Enter Order ID : ");
            int orderId = scanner.nextInt();
            scanner.nextLine();

            Order order = orderOperations.findOrderById(orderId);

            if (order.getShipment() != null) {

                System.out.println("Shipment already exists.");
                return;
            }

            System.out.print("Enter Shipping Address : ");
            String address = scanner.nextLine();

            System.out.print("Enter Courier Partner : ");
            String courier = scanner.nextLine();

            System.out.print("Enter Tracking Number : ");
            String tracking = scanner.nextLine();

            LocalDate dispatchDate = LocalDate.now();
            LocalDate expectedDate = dispatchDate.plusDays(5);

            Shipment shipment = new Shipment(
                    generateShipmentId(),
                    order,
                    address,
                    courier,
                    tracking,
                    dispatchDate,
                    expectedDate
            );

            shipment.setShipmentStatus(ShipmentStatus.PENDING);

            shipments.add(shipment);

            order.setShipment(shipment);

            System.out.println("Shipment created successfully.");

        } catch (OrderNotFoundException e) {

            System.out.println(e.getMessage());

        } catch (Exception e) {

            System.out.println("Invalid Input.");
        }
    }

    // Search Shipment
    public void getShipmentById() {

        try {

            System.out.print("Enter Shipment ID : ");
            int shipmentId = scanner.nextInt();

            Shipment shipment = findShipmentById(shipmentId);

            System.out.println(shipment);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    // Update Shipment Status
    public void updateShipmentStatus() {

        try {

            System.out.print("Enter Shipment ID : ");
            int shipmentId = scanner.nextInt();

            Shipment shipment = findShipmentById(shipmentId);

            System.out.println("1. DISPATCHED");
            System.out.println("2. IN_TRANSIT");
            System.out.println("3. OUT_FOR_DELIVERY");
            System.out.println("4. DELIVERED");
            System.out.println("5. RETURNED");

            System.out.print("Choose Status : ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    shipment.setShipmentStatus(ShipmentStatus.DISPATCHED);
                    shipment.setDispatchDate(LocalDate.now());
                    break;

                case 2:
                    shipment.setShipmentStatus(ShipmentStatus.IN_TRANSIT);
                    break;

                case 3:
                    shipment.setShipmentStatus(ShipmentStatus.OUT_FOR_DELIVERY);
                    break;

                case 4:
                    shipment.setShipmentStatus(ShipmentStatus.DELIVERED);
                    shipment.setDeliveredDate(LocalDate.now());
                    break;

                case 5:
                    shipment.setShipmentStatus(ShipmentStatus.RETURNED);
                    break;

                default:
                    System.out.println("Invalid Status.");
                    return;
            }

            System.out.println("Shipment status updated successfully.");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    // Search Shipment by Order
    public void getShipmentByOrder() {

        try {

            System.out.print("Enter Order ID : ");
            int orderId = scanner.nextInt();

            Order order = orderOperations.findOrderById(orderId);

            for (Shipment shipment : shipments) {

                if (shipment.getOrder().getOrderId() == order.getOrderId()) {

                    System.out.println(shipment);
                    return;
                }
            }

            throw new ShipmentNotFoundException("Shipment not found.");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    // Display All Shipments
    public void displayAllShipments() {

        if (shipments.isEmpty()) {

            System.out.println("No Shipments Available.");
            return;
        }

        for (Shipment shipment : shipments) {

            System.out.println(shipment);
        }
    }

    // Find Shipment
    public Shipment findShipmentById(int shipmentId)
            throws ShipmentNotFoundException {

        for (Shipment shipment : shipments) {

            if (shipment.getShipmentId() == shipmentId) {
                return shipment;
            }
        }

        throw new ShipmentNotFoundException("Shipment not found.");
    }

    // Shipment Count
    public void getShipmentCount() {

        System.out.println("Total Shipments : " + shipments.size());
    }
}