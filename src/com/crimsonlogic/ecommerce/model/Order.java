package com.crimsonlogic.ecommerce.model;

import com.crimsonlogic.ecommerce.enums.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private String orderId;
    private Customer customer;
    private LocalDate orderDate;
    private OrderStatus orderStatus;
    private List<OrderItem> orderItems;
    private Payment payment;
    private Shipment shipment;

    public Order() {
        this.orderItems = new ArrayList<>();
        this.orderDate = LocalDate.now();
    }

    public Order(String orderId, Customer customer,
                 OrderStatus orderStatus,
                 Payment payment,
                 Shipment shipment) {

        this.orderId = orderId;
        this.customer = customer;
        this.orderStatus = orderStatus;
        this.payment = payment;
        this.shipment = shipment;
        this.orderItems = new ArrayList<>();
        this.orderDate = LocalDate.now();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
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

    /**
     * Calculates total order amount dynamically.
     */
    public double getTotalAmount() {

        return orderItems.stream()
                .mapToDouble(OrderItem::getSubTotal)
                .sum();

    }

    @Override
    public String toString() {

        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customer=" + customer.getUserName() +
                ", orderDate=" + orderDate +
                ", orderStatus=" + orderStatus +
                ", totalAmount=" + getTotalAmount() +
                '}';
    }
}
