package com.crimsonlogic.ecommerce.helper;

import java.util.Scanner;
import com.crimsonlogic.ecommerce.services.*;

public class MenuHandler {
    private final Scanner scanner = new Scanner(System.in);

    // Centralized Operations
    private final ApplicationOperations applicationOperations = new ApplicationOperations();

    // Handlers
    private final CustomerHandler customerHandler;
    private final SellerHandler sellerHandler;
    private final CategoryHandler categoryHandler;
    private final ProductHandler productHandler;
    private final InventoryHandler inventoryHandler;
    private final CouponHandler couponHandler;
    private final OrderHandler orderHandler;
    private final PaymentHandler paymentHandler;
    private final ShipmentHandler shipmentHandler;
    private final ReviewHandler reviewHandler;
    private final ReportHandler reportHandler;
    private final AdminHandler adminHandler;

    public MenuHandler() {

        customerHandler = new CustomerHandler(applicationOperations.getCustomerOperations(),
                applicationOperations.getCartOperations(),
                applicationOperations.getWishlistOperations());

        sellerHandler = new SellerHandler(applicationOperations.getSellerOperations());

        categoryHandler = new CategoryHandler(applicationOperations.getCategoryOperations());

        productHandler = new ProductHandler(applicationOperations.getProductOperations());

        inventoryHandler = new InventoryHandler(applicationOperations.getInventoryOperations());

        couponHandler = new CouponHandler(applicationOperations.getCouponOperations());

        orderHandler = new OrderHandler(applicationOperations.getOrderOperations());

        paymentHandler = new PaymentHandler(applicationOperations.getPaymentOperations());

        shipmentHandler = new ShipmentHandler(applicationOperations.getShipmentOperations());

        reviewHandler = new ReviewHandler(applicationOperations.getReviewOperations());

        reportHandler = new ReportHandler(applicationOperations.getReportOperations());

        adminHandler = new AdminHandler(applicationOperations.getAdminOperations());
    }

    public void marketPlaceMenu() {

        int choice;

        do {

            System.out.println("\n==========================================");
            System.out.println("     E-COMMERCE MARKETPLACE SYSTEM");
            System.out.println("==========================================");
            System.out.println("1. Customer");
            System.out.println("2. Seller");
            System.out.println("3. Category");
            System.out.println("4. Product");
            System.out.println("5. Inventory");
            System.out.println("6. Coupon");
            System.out.println("7. Order");
            System.out.println("8. Payment");
            System.out.println("9. Shipment");
            System.out.println("10. Review");
            System.out.println("11. Reports");
            System.out.println("12. Admin");
            System.out.println("0. Exit");
            System.out.println("==========================================");
            System.out.print("Enter Choice : ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1 -> customerHandler.customerMenu();
                case 2 -> sellerHandler.sellerMenu();
                case 3 -> categoryHandler.categoryMenu();
                case 4 -> productHandler.productHandlerMethod();
                case 5 -> inventoryHandler.inventoryMenu();
                case 6 -> couponHandler.couponMenu();
                case 7 -> orderHandler.orderMenu();
                case 8 -> paymentHandler.paymentMenu();
                case 9 -> shipmentHandler.shipmentMenu();
                case 10 -> reviewHandler.reviewMenu();
                case 11 -> reportHandler.reportMenu();
                case 12 -> adminHandler.adminMenu();
                case 0 -> System.out.println("Thank you for using E-Commerce Marketplace.");
                default -> System.out.println("Invalid Choice!");
            }

        } while (choice != 0);
    }
}