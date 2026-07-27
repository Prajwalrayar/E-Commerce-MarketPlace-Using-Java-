package com.crimsonlogic.ecommerce.services;

import com.crimsonlogic.ecommerce.model.interfaces.PaymentGateway;

public class ApplicationOperations {
    private final CustomerOperations customerOperations;
    private final SellerOperations sellerOperations;
    private final CategoryOperations categoryOperations;
    private final ProductOperations productOperations;
    private final InventoryOperations inventoryOperations;
    private final CartOperations cartOperations;
    private final WishlistOperations wishlistOperations;
    private final CouponOperations couponOperations;
    private final OrderOperations orderOperations;
    private final PaymentOperations paymentOperations;
    private final ShipmentOperations shipmentOperations;
    private final ReviewOperations reviewOperations;
    private final ReportOperations reportOperations;
    private final AdminOperations adminOperations;

    public ApplicationOperations() {

        customerOperations = new CustomerOperations();
        sellerOperations = new SellerOperations();
        categoryOperations = new CategoryOperations();
        productOperations = new ProductOperations(categoryOperations, sellerOperations);
        inventoryOperations = new InventoryOperations(productOperations);
        cartOperations = new CartOperations(customerOperations, productOperations);
        wishlistOperations = new WishlistOperations(customerOperations, productOperations);
        couponOperations = new CouponOperations();
        orderOperations = new OrderOperations(customerOperations, cartOperations,
                productOperations, inventoryOperations, couponOperations);

        // Dummy Payment Gateway
        PaymentGateway paymentGateway = new PaymentGateway() {

            @Override
            public boolean processPayment(double amount) {

                System.out.println("Processing Payment : RS." + amount);

                return true;
            }
        };

        paymentOperations = new PaymentOperations(orderOperations, paymentGateway);

        shipmentOperations = new ShipmentOperations(orderOperations);

        reviewOperations = new ReviewOperations();

        reportOperations = new ReportOperations();

        adminOperations = new AdminOperations(customerOperations, sellerOperations,
                productOperations, inventoryOperations, orderOperations, reportOperations);
    }

    public AdminOperations getAdminOperations() {
        return adminOperations;
    }

    public CustomerOperations getCustomerOperations() {
        return customerOperations;
    }

    public SellerOperations getSellerOperations() {
        return sellerOperations;
    }

    public CategoryOperations getCategoryOperations() {
        return categoryOperations;
    }

    public ProductOperations getProductOperations() {
        return productOperations;
    }

    public InventoryOperations getInventoryOperations() {
        return inventoryOperations;
    }

    public CartOperations getCartOperations() {
        return cartOperations;
    }

    public WishlistOperations getWishlistOperations() {
        return wishlistOperations;
    }

    public CouponOperations getCouponOperations() {
        return couponOperations;
    }

    public OrderOperations getOrderOperations() {
        return orderOperations;
    }

    public PaymentOperations getPaymentOperations() {
        return paymentOperations;
    }

    public ShipmentOperations getShipmentOperations() {
        return shipmentOperations;
    }

    public ReviewOperations getReviewOperations() {
        return reviewOperations;
    }

    public ReportOperations getReportOperations() {
        return reportOperations;
    }
}