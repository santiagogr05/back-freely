package com.freely.freely.controllers;

import com.freely.freely.DTO.ServicesDTO;
import com.freely.freely.entities.Services;
import com.freely.freely.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/")
    public List<Services> findAll(){
        return serviceService.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Services create(
            @RequestBody ServicesDTO servicesDTO
            ) throws SQLException {
        return serviceService.create(servicesDTO);
    }

    @PutMapping("/{id}")
    public Services update(@PathVariable Integer id, @RequestBody ServicesDTO servicesDTO) throws SQLException {
        return serviceService.update(id, servicesDTO);
    }
}
