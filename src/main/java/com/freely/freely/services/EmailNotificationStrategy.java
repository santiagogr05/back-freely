package com.freely.freely.services;

import com.freely.freely.entities.NotificationType;
import com.freely.freely.entities.User;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationStrategy implements NotificationStrategy {
    @Override
    public void send(String message, User user) {
        //external api connection
    }

    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL;
    }
}
