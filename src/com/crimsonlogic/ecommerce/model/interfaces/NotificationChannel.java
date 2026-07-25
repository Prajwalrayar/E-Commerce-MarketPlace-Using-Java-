package com.crimsonlogic.ecommerce.model.interfaces;

import com.crimsonlogic.ecommerce.model.Payment;

public interface NotificationChannel {

    void sendNotification(String recipient, String message);

}
