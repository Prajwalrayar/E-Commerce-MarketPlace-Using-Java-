package com.crimsonlogic.ecommerce.model;

import com.crimsonlogic.ecommerce.enums.ModeOfPayment;
import com.crimsonlogic.ecommerce.enums.PaymentStatus;

import java.time.LocalDateTime;

public class Payment {

    private String paymentId;
    private Order order;
    private double amount;
    private ModeOfPayment modeOfPayment;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentDateTime;

    public Payment() {
    }

    public Payment(String paymentId,
                   Order order,
                   double amount,
                   ModeOfPayment modeOfPayment,
                   PaymentStatus paymentStatus,
                   LocalDateTime paymentDateTime) {

        this.paymentId = paymentId;
        this.order = order;
        this.amount = amount;
        this.modeOfPayment = modeOfPayment;
        this.paymentStatus = paymentStatus;
        this.paymentDateTime = paymentDateTime;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
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
        this.amount = amount;
    }

    public ModeOfPayment getPaymentMode() {
        return modeOfPayment;
    }

    public void setPaymentMode(ModeOfPayment paymentMode) {
        this.modeOfPayment = paymentMode;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(LocalDateTime paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }

    @Override
    public String toString() {

        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", orderId='" + order.getOrderId() + '\'' +
                ", amount=" + amount +
                ", paymentMode=" + modeOfPayment +
                ", paymentStatus=" + paymentStatus +
                ", paymentDateTime=" + paymentDateTime +
                '}';
    }
}
