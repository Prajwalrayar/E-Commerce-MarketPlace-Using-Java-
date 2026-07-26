package com.crimsonlogic.ecommerce.exceptions;

public class PaymentFailedException extends Exception{

    public PaymentFailedException(String message) {
        super(message);
    }
}
