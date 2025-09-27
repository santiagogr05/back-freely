package com.freely.freely.services;

import com.freely.freely.DTO.ServicesDTO;
import com.freely.freely.entities.Services;
import com.freely.freely.respositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {
    @Autowired
    private ServiceRepository repository;

    public List<Services> findAll(){
        return repository.findAll();
    }

    public ResponseEntity<Services> create(ServicesDTO servicesDTO) throws SQLException {
        return repository.create(servicesDTO);
    }

    public Optional<Services> update(Integer id, ServicesDTO servicesDTO) throws SQLException {
        return repository.update(id,servicesDTO);
    }

    public Optional<Services> delete(Integer id) throws SQLException {
        return repository.delete(id);
    }
}
