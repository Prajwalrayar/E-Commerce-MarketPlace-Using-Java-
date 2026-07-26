package com.crimsonlogic.ecommerce.model.interfaces;

import com.crimsonlogic.ecommerce.model.Payment;

public interface PaymentGateway {
    boolean processPayment(double amount);
}
