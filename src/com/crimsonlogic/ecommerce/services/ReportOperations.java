package com.crimsonlogic.ecommerce.services;

import com.crimsonlogic.ecommerce.enums.OrderStatus;
import com.crimsonlogic.ecommerce.model.Product;
import com.crimsonlogic.ecommerce.model.OrderItem;
import com.crimsonlogic.ecommerce.model.Order;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    public void topFiveBestSellingProducts() {

        orderOperations.getAllOrders().stream()
                .flatMap(order -> order.getOrderItems().stream())
                .collect(Collectors.groupingBy(OrderItem::getProduct,
                        Collectors.summingInt(OrderItem::getQuantity)
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<Product, Integer>comparingByValue().reversed())
                .limit(5).forEach(entry ->
                        System.out.println(entry.getKey().getProductName()
                                + " -> Sold : " + entry.getValue()));
    }

    public void totalMarketplaceRevenue() {

        double totalRevenue = orderOperations.getAllOrders()
                .stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();

        System.out.println("Total Marketplace Revenue : $" + totalRevenue);
    }

    public void groupOrdersByStatus() {

        Map<OrderStatus, List<Order>> groupedOrders = orderOperations.getAllOrders()
                .stream()
                .collect(Collectors.groupingBy(Order::getOrderStatus));
        groupedOrders.forEach((status, orders) -> {
            System.out.println("\n" + status);
            orders.forEach(System.out::println);
        });
    }

    public void countOrdersByStatus() {

        Map<OrderStatus, Long> orderCount = orderOperations.getAllOrders()
                .stream()
                .collect(Collectors.groupingBy(
                        Order::getOrderStatus,
                        Collectors.counting()
                ));

        orderCount.forEach((status, count) ->
                System.out.println(status + " : " + count));
    }
}