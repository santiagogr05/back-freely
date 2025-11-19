package com.freely.freely.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NotificationRequest {
    private Integer userId;
    private NotificationType type;
    private NotificationChannel channel;
    private String title;
    private String message;
}
