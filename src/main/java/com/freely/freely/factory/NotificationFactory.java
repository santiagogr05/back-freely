package com.freely.freely.factory;

import com.freely.freely.entities.Notification;
import com.freely.freely.entities.NotificationRequest;
import com.freely.freely.entities.User;
import com.freely.freely.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NotificationFactory {
    @Autowired
    private IUserRepository userRepository;

    public Notification create(NotificationRequest req) {
        User user = userRepository.findById(req.getUserId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Notification notification = new Notification();

        notification.setUser(user);
        notification.setType(req.getType());
        notification.setChannel(req.getChannel());
        notification.setTitle(req.getTitle());
        notification.setMessage(req.getMessage());
        notification.setStatus("PENDING");
        return notification;

    }

    public String buildTitle(NotificationRequest req) {
        if (req.getTitle() != null) {
            return req.getTitle();
        }

        return switch (req.getType()) {
            case NEW_MESSAGE ->  "New Message received";
            case DELIVERABLE_SENT ->   "New deliverable sent";
            case DELIVERABLE_APPROVED ->    "Deliverable approved";
        };
    }

    public String buildMessage(NotificationRequest req) {
        if (req.getMessage() != null) {
            return req.getMessage();
        }

        return switch (req.getType()) {
            case NEW_MESSAGE ->  "You have received a new message in your inbox. Please check it out.";
            case DELIVERABLE_SENT ->   "A new deliverable has been sent for your review. Please take a look.";
            case DELIVERABLE_APPROVED ->    "Your deliverable has been approved. Great job!";
        };
    }
}
