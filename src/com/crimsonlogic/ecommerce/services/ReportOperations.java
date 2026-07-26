package com.crimsonlogic.ecommerce.services;

import java.util.Scanner;

public class ReportOperations {

    private CustomerOperations customerOperations;
    private SellerOperations sellerOperations;
    private ProductOperations productOperations;
    private InventoryOperations inventoryOperations;
    private OrderOperations orderOperations;

    private Scanner scanner;

    public ReportOperations(CustomerOperations customerOperations,
                            SellerOperations sellerOperations,
                            ProductOperations productOperations,
                            InventoryOperations inventoryOperations,
                            OrderOperations orderOperations) {

        this.customerOperations = customerOperations;
        this.sellerOperations = sellerOperations;
        this.productOperations = productOperations;
        this.inventoryOperations = inventoryOperations;
        this.orderOperations = orderOperations;

        scanner = new Scanner(System.in);
    }

    public ReportOperations() {

    }

    public void customerReport() {

        System.out.println("\n========== CUSTOMER REPORT ==========");
        customerOperations.displayAllCustomers();
        customerOperations.getCustomerCount();
    }

    public void sellerReport() {

        System.out.println("\n========== SELLER REPORT ==========");
        sellerOperations.displayAllSellers();
        sellerOperations.getSellerCount();
    }

    public void productReport() {

        System.out.println("\n========== PRODUCT REPORT ==========");
        productOperations.displayAllProducts();
        productOperations.getProductCount();
    }

    public void inventoryReport() {

        System.out.println("\n========== INVENTORY REPORT ==========");
        inventoryOperations.displayAllInventories();
        inventoryOperations.getInventoryCount();
    }

    public void orderReport() {

        System.out.println("\n========== ORDER REPORT ==========");
        orderOperations.displayAllOrders();
        orderOperations.getOrderCount();
    }
}