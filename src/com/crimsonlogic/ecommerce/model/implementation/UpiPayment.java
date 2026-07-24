package com.crimsonlogic.ecommerce.model.implementation;

import com.crimsonlogic.ecommerce.model.Payment;
import com.crimsonlogic.ecommerce.model.interfaces.PaymentGateway;

public class UpiPayment implements PaymentGateway {
       @Override
    public boolean processPayment() {
        return false;
    }
}
