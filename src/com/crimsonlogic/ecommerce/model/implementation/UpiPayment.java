package com.crimsonlogic.ecommerce.model.implementation;

import com.crimsonlogic.ecommerce.model.Payment;
import com.crimsonlogic.ecommerce.model.interfaces.PaymentGateway;

public class UpiPayment implements PaymentGateway {

    private String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean processPayment(double amount) {

        if (upiId == null || upiId.isBlank()) {
            System.out.println("Invalid UPI ID.");
            return false;
        }

        System.out.println("--------------------------------");
        System.out.println("Payment Mode : UPI");
        System.out.println("UPI ID       : " + upiId);
        System.out.println("Amount       : $" + amount);
        System.out.println("Payment Successful.");
        System.out.println("--------------------------------");

        return true;
    }
}
