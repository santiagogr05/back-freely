package com.freely.freely.services;

import com.freely.freely.DTO.ServicesDTO;
import com.freely.freely.entities.Services;
import com.freely.freely.respositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceService implements IServiceService{

    @Autowired
    private ServiceRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Services> findAll() {
        return (List<Services>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Services> findById(Integer id) {
        return repository.findById(id);
    }


    @Override
    public Services save(Services service) {
        return repository.save(service);
    }

    @Override
    public Optional<Services> delete(Services service) {
        Optional<Services> serviceOptional = repository.findById(service.getId());
        serviceOptional.ifPresent(serviceDb -> repository.delete(serviceDb));
        return serviceOptional;
    }
}
