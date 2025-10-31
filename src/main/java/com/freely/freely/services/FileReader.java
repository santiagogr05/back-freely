package com.freely.freely.services;

public interface FileReader {
    byte[] readFile(String fileName);
    boolean canRead(Integer fileId, Integer userId);
}
