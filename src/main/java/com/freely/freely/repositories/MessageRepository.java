package com.freely.freely.repositories;

import com.freely.freely.entities.Message;

import java.util.List;

public interface MessageRepository {
    Message save (Message message);
    List<Message> findByProjectId (Integer ProjectId);
    List<Message> findUnreadMessages (Integer ClientId);
}
