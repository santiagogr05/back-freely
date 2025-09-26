package com.freely.freely.services;

import com.freely.freely.entities.Services;
import com.freely.freely.respositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    @Autowired
    private ServiceRepository repository;

    public List<Services> findAll(){
        return repository.findAll();
    }
}
