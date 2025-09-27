package com.freely.freely.controllers;

import com.freely.freely.DTO.ServicesDTO;
import com.freely.freely.entities.Services;
import com.freely.freely.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private ServiceService service;

    @GetMapping("/")
    public List<Services> findAll(){
        return service.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Services create(
            @RequestBody ServicesDTO servicesDTO
            ) throws SQLException {
        return service.create(servicesDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Services> update(@PathVariable Integer id, @RequestBody ServicesDTO body) throws SQLException {
        return service.update(id, body).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Services> delete(@PathVariable Integer id) throws SQLException {
        return service.delete(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
