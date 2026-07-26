package com.crimsonlogic.ecommerce.model;

import com.crimsonlogic.ecommerce.enums.OrderStatus;
import com.crimsonlogic.ecommerce.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private int orderId;
    private Customer customer;
    private List<OrderItem> orderItems;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Payment payment;
    private Shipment shipment;

    public Order() {
        this.orderItems = new ArrayList<>();
        this.orderDate = LocalDateTime.now();
        this.orderStatus = OrderStatus.PENDING;
    }

    public Order(int orderId, Customer customer) {

        this.orderId = orderId;
        this.customer = customer;
        this.orderItems = new ArrayList<>();
        this.orderDate = LocalDateTime.now();
        this.orderStatus = OrderStatus.PENDING;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    // Add Order Item
    public void addOrderItem(OrderItem item) {
        orderItems.add(item);
    }

    // Remove Order Item
    public void removeOrderItem(OrderItem item) {
        orderItems.remove(item);
    }

    // Total Quantity
    public int getTotalItems() {

        int total = 0;

        for (OrderItem item : orderItems) {
            total += item.getQuantity();
        }

        return total;
    }

    // Total Amount
    public double getTotalAmount() {

        double total = 0;

        for (OrderItem item : orderItems) {
            total += item.getSubTotal();
        }

        return total;
    }

    public boolean isPaid() {

        return payment != null
                && payment.getPaymentStatus() == PaymentStatus.SUCCESS;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Order))
            return false;

        Order order = (Order) obj;

        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("\n========== ORDER ==========\n");
        builder.append("Order ID      : ").append(orderId).append("\n");

        if (customer != null) {
            builder.append("Customer      : ")
                    .append(customer.getName())
                    .append("\n");
        }

        builder.append("Order Date    : ")
                .append(orderDate)
                .append("\n");

        builder.append("Status        : ")
                .append(orderStatus)
                .append("\n");

        builder.append("-------------------------------\n");

        for (OrderItem item : orderItems) {
            builder.append(item).append("\n");
        }

        builder.append("-------------------------------\n");

        builder.append("Total Items   : ")
                .append(getTotalItems())
                .append("\n");

        builder.append("Total Amount  : $")
                .append(getTotalAmount())
                .append("\n");

        if (payment != null) {
            builder.append("Payment       : ")
                    .append(payment.getPaymentStatus())
                    .append("\n");
        }

        if (shipment != null) {
            builder.append("Shipment      : ")
                    .append(shipment.getShipmentStatus())
                    .append("\n");
        }

        builder.append("============================");

        return builder.toString();
    }
}