package com.crimsonlogic.ecommerce.model.implementation;

import com.crimsonlogic.ecommerce.enums.ModeOfNotification;
import com.crimsonlogic.ecommerce.model.abstractclass.User;
import com.crimsonlogic.ecommerce.model.interfaces.NotificationChannel;

public class EmailNotification implements NotificationChannel {

    @Override
    public void sendNotification(User user,
                                 String subject,
                                 String message,
                                 ModeOfNotification mode) {

        if (mode != ModeOfNotification.EMAIL) {
            System.out.println("Invalid notification mode.");
            return;
        }

        System.out.println("\n========================================");
        System.out.println("         EMAIL NOTIFICATION");
        System.out.println("========================================");
        System.out.println("Recipient : " + user.getName());
        System.out.println("Email     : " + user.getEmail());
        System.out.println("Subject   : " + subject);
        System.out.println("Message   : " + message);
        System.out.println("Status    : Sent Successfully");
        System.out.println("========================================");
    }
}
