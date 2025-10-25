package com.freely.freely.services;

public interface ReviewableFile extends FileReader{
    void acceptFile(Integer fileId, Integer clientId);
    void rejectFile(Integer fileId, Integer clientId, String reason);
}
