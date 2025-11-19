package com.freely.freely.repositories;

import com.freely.freely.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotificationRepository extends JpaRepository<Notification, Integer> {
}
