package com.crimsonlogic.ecommerce.model.interfaces;

import com.crimsonlogic.ecommerce.enums.ModeOfNotification;
import com.crimsonlogic.ecommerce.model.Payment;
import com.crimsonlogic.ecommerce.model.abstractclass.User;

public interface NotificationChannel {

    void sendNotification(User user,
                          String subject,
                          String message,
                          ModeOfNotification mode);

}
