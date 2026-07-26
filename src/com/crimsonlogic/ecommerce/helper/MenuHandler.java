package com.crimsonlogic.ecommerce.helper;

import java.util.Scanner;

import com.crimsonlogic.ecommerce.model.interfaces.PaymentGateway;
import com.crimsonlogic.ecommerce.services.*;

public class MenuHandler {

    private Scanner scanner = new Scanner(System.in);

    // Operations
    private CustomerOperations customerOperations = new CustomerOperations();
    private SellerOperations sellerOperations = new SellerOperations();
    private CategoryOperations categoryOperations = new CategoryOperations();

    private ProductOperations productOperations =
            new ProductOperations(categoryOperations, sellerOperations);

    private InventoryOperations inventoryOperations =
            new InventoryOperations(productOperations);

    private CouponOperations couponOperations =
            new CouponOperations();

    private CartOperations cartOperations =
            new CartOperations(customerOperations, productOperations);

    private WishlistOperations wishlistOperations =
            new WishlistOperations(customerOperations, productOperations);

    private OrderOperations orderOperations =
            new OrderOperations(
                    customerOperations,
                    cartOperations,
                    productOperations,
                    inventoryOperations,
                    couponOperations);

    private PaymentGateway paymentGateway = new PaymentGateway() {
        @Override
        public boolean processPayment(double amount) {
            return true;
        }
    };

    private PaymentOperations paymentOperations =
            new PaymentOperations(orderOperations, paymentGateway);

    private ShipmentOperations shipmentOperations =
            new ShipmentOperations(orderOperations);

    private ReviewOperations reviewOperations =
            new ReviewOperations(customerOperations, productOperations);

    private ReportOperations reportOperations =
            new ReportOperations(
                    customerOperations,
                    sellerOperations,
                    productOperations,
                    inventoryOperations,
                    orderOperations);

    private AdminOperations adminOperations =
            new AdminOperations(
                    customerOperations,
                    sellerOperations,
                    productOperations,
                    inventoryOperations,
                    orderOperations,
                    reportOperations);

    // Handlers
    private CustomerHandler customerHandler =
            new CustomerHandler(
                    customerOperations,
                    cartOperations,
                    wishlistOperations
            );

    private SellerHandler sellerHandler =
            new SellerHandler(sellerOperations);

    private CategoryHandler categoryHandler =
            new CategoryHandler(categoryOperations);

    private ProductHandler productHandler =
            new ProductHandler(productOperations);

    private InventoryHandler inventoryHandler =
            new InventoryHandler(inventoryOperations);

    private CouponHandler couponHandler =
            new CouponHandler(couponOperations);

    private OrderHandler orderHandler =
            new OrderHandler(orderOperations);

    private PaymentHandler paymentHandler =
            new PaymentHandler(paymentOperations);

    private ShipmentHandler shipmentHandler =
            new ShipmentHandler(shipmentOperations);

    private ReviewHandler reviewHandler =
            new ReviewHandler(reviewOperations);

    private ReportHandler reportHandler =
            new ReportHandler(reportOperations);

    private AdminHandler adminHandler =
            new AdminHandler(adminOperations);

    public MenuHandler() {
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

                case 1:
                    customerHandler.customerMenu();
                    break;

                case 2:
                    sellerHandler.sellerMenu();
                    break;

                case 3:
                    categoryHandler.categoryMenu();
                    break;

                case 4:
                    productHandler.productHandlerMethod();
                    break;

                case 5:
                    inventoryHandler.inventoryMenu();
                    break;

                case 6:
                    couponHandler.couponMenu();
                    break;

                case 7:
                    orderHandler.orderMenu();
                    break;

                case 8:
                    paymentHandler.paymentMenu();
                    break;

                case 9:
                    shipmentHandler.shipmentMenu();
                    break;

                case 10:
                    reviewHandler.reviewMenu();
                    break;

                case 11:
                    reportHandler.reportMenu();
                    break;

                case 12:
                    adminHandler.adminMenu();
                    break;

                case 0:
                    System.out.println("Thank you for using E-Commerce Marketplace.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);
    }
}