package com.crimsonlogic.ecommerce.services;

public class AdminOperations {

    private CustomerOperations customerOperations;
    private SellerOperations sellerOperations;
    private ProductOperations productOperations;
    private InventoryOperations inventoryOperations;
    private OrderOperations orderOperations;
    private ReportOperations reportOperations;


    public AdminOperations(
            CustomerOperations customerOperations,
            SellerOperations sellerOperations,
            ProductOperations productOperations,
            InventoryOperations inventoryOperations,
            OrderOperations orderOperations,
            ReportOperations reportOperations) {

        this.customerOperations = customerOperations;
        this.sellerOperations = sellerOperations;
        this.productOperations = productOperations;
        this.inventoryOperations = inventoryOperations;
        this.orderOperations = orderOperations;
        this.reportOperations = reportOperations;
    }


    public void viewCustomers() {

        System.out.println("\n========== CUSTOMERS ==========");
        customerOperations.displayAllCustomers();
    }


    public void viewSellers() {

        System.out.println("\n========== SELLERS ==========");
        sellerOperations.displayAllSellers();
    }


    public void viewProducts() {

        System.out.println("\n========== PRODUCTS ==========");
        productOperations.displayAllProducts();
    }


    public void viewInventories() {

        System.out.println("\n========== INVENTORY ==========");
        inventoryOperations.displayAllInventories();
    }


    public void viewOrders() {

        System.out.println("\n========== ORDERS ==========");
        orderOperations.displayAllOrders();
    }


    public void viewReports() {

        reportOperations.customerReport();
        reportOperations.sellerReport();
        reportOperations.productReport();
        reportOperations.inventoryReport();
        reportOperations.orderReport();
    }
}