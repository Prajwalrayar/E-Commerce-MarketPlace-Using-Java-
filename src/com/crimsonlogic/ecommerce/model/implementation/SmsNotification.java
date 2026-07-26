package com.crimsonlogic.ecommerce.model.implementation;

import com.crimsonlogic.ecommerce.enums.ModeOfNotification;
import com.crimsonlogic.ecommerce.model.abstractclass.User;
import com.crimsonlogic.ecommerce.model.interfaces.NotificationChannel;

public class SmsNotification implements NotificationChannel {

    @Override
    public void sendNotification(User user,
                                 String subject,
                                 String message,
                                 ModeOfNotification mode) {

        if (mode != ModeOfNotification.SMS) {
            System.out.println("Invalid notification mode.");
            return;
        }

        System.out.println("\n========================================");
        System.out.println("          SMS NOTIFICATION");
        System.out.println("========================================");
        System.out.println("Recipient : " + user.getName());
        System.out.println("Phone     : " + user.getPhoneNumber());
        System.out.println("Message   : " + message);
        System.out.println("Status    : Sent Successfully");
        System.out.println("========================================");
    }
}
