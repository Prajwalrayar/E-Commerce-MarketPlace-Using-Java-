package com.crimsonlogic.ecommerce.model;

import com.crimsonlogic.ecommerce.enums.PaymentMethod;
import com.crimsonlogic.ecommerce.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.Objects;

public class Payment {

    private int paymentId;
    private Order order;
    private double amount;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
    private String transactionId;
    private LocalDateTime paymentDate;

    public Payment() {
        this.paymentDate = LocalDateTime.now();
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public Payment(int paymentId,
                   Order order,
                   double amount,
                   PaymentMethod paymentMethod,
                   String transactionId) {

        this.paymentId = paymentId;
        this.order = order;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.paymentDate = LocalDateTime.now();
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {

        if (amount >= 0) {
            this.amount = amount;
        }
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void processPayment() {
        this.paymentStatus = PaymentStatus.SUCCESS;
        this.paymentDate = LocalDateTime.now();
    }

    public void failPayment() {
        this.paymentStatus = PaymentStatus.FAILED;
        this.paymentDate = LocalDateTime.now();
    }

    public void refundPayment() {
        this.paymentStatus = PaymentStatus.REFUNDED;
        this.paymentDate = LocalDateTime.now();
    }

    public boolean isSuccessful() {
        return paymentStatus == PaymentStatus.SUCCESS;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Payment))
            return false;

        Payment payment = (Payment) obj;

        return paymentId == payment.paymentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId);
    }

    @Override
    public String toString() {

        return "\n========== PAYMENT ==========" +
                "\nPayment ID      : " + paymentId +
                "\nOrder ID        : " +
                (order != null ? order.getOrderId() : "N/A") +
                "\nAmount          : $" + amount +
                "\nPayment Method  : " + paymentMethod +
                "\nTransaction ID  : " + transactionId +
                "\nPayment Status  : " + paymentStatus +
                "\nPayment Date    : " + paymentDate +
                "\n=============================";
    }
}