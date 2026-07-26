package com.crimsonlogic.ecommerce.model.implementation;

import com.crimsonlogic.ecommerce.model.Payment;
import com.crimsonlogic.ecommerce.model.interfaces.PaymentGateway;

public class CashPayment implements PaymentGateway {


    @Override
    public boolean processPayment(double amount) {

        System.out.println("--------------------------------");
        System.out.println("Payment Mode : CASH");
        System.out.println("Amount       : $" + amount);
        System.out.println("Cash will be collected on delivery.");
        System.out.println("--------------------------------");

        return true;
    }
}
