package com.freely.freely.services;

import com.freely.freely.entities.NotificationType;
import com.freely.freely.entities.User;
import org.springframework.stereotype.Component;

@Component
public class SystemNotificationStrategy implements NotificationStrategy {

    @Override
    public void send(String message, User user) {

    }

    @Override
    public NotificationType getType() {
        return NotificationType.SYSTEM;
    }
}
