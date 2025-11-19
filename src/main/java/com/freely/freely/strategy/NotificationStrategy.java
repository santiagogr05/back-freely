package com.freely.freely.strategy;

import com.freely.freely.entities.Notification;
import com.freely.freely.entities.NotificationChannel;

public interface NotificationStrategy {
    NotificationChannel getChannel();
    void send(Notification notification);
}
