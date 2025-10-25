package com.freely.freely.services;

import com.freely.freely.entities.NotificationType;
import com.freely.freely.entities.User;

public interface NotificationStrategy {
    void send(String message, User user);
    NotificationType getType();
}
