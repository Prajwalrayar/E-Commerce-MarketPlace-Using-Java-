package com.crimsonlogic.ecommerce.model.implementation;

import com.crimsonlogic.ecommerce.model.Payment;
import com.crimsonlogic.ecommerce.model.interfaces.PaymentGateway;

public class CardPayment implements PaymentGateway {

    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    public CardPayment(String cardNumber,
                       String cardHolderName,
                       String expiryDate,
                       String cvv) {

        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean processPayment(double amount) {

        if (cardNumber == null || cardNumber.length() != 16) {
            System.out.println("Invalid Card Number.");
            return false;
        }

        System.out.println("--------------------------------");
        System.out.println("Payment Mode : CARD");
        System.out.println("Card Holder  : " + cardHolderName);
        System.out.println("Amount       : $" + amount);
        System.out.println("Payment Successful.");
        System.out.println("--------------------------------");

        return true;
    }
}
