package com.freely.freely.strategy;

import com.freely.freely.entities.Notification;
import com.freely.freely.entities.NotificationChannel;
import com.freely.freely.repositories.INotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppNotificationStrategy implements NotificationStrategy {

    @Autowired
    private INotificationRepository notificationRepository;

    @Override
    public NotificationChannel getChannel() {
        return NotificationChannel.APP;
    }

    @Override
    public void send(Notification notification) {
        notificationRepository.save(notification);
    }
}
