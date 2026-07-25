package com.crimsonlogic.ecommerce.model.implementation;

import com.crimsonlogic.ecommerce.model.Payment;
import com.crimsonlogic.ecommerce.model.interfaces.PaymentGateway;

public class CashPayment implements PaymentGateway {


    @Override
    public boolean processPayment() {

        System.out.println("\nCash on Delivery Selected.");
        System.out.println("Payment will be collected at the time of delivery.");

        return true;

    }
}
