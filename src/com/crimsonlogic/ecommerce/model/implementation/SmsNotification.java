package com.crimsonlogic.ecommerce.model.implementation;

import com.crimsonlogic.ecommerce.model.interfaces.NotificationChannel;

public class SmsNotification implements NotificationChannel {

    @Override
    public void sendNotification(String recipient, String message) {

        System.out.println("\nSMS Notification");
        System.out.println("-------------------------");
        System.out.println("Recipient : " + recipient);
        System.out.println("Message   : " + message);
    }
}
