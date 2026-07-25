package com.crimsonlogic.ecommerce.model.implementation;

import com.crimsonlogic.ecommerce.model.interfaces.NotificationChannel;

public class EmailNotification implements NotificationChannel {

    @Override
    public void sendNotification(String recipient, String message) {

        System.out.println("\nEmail Notification");
        System.out.println("-------------------------");
        System.out.println("Recipient : " + recipient);
        System.out.println("Message   : " + message);
    }
}
