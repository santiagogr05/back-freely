package com.freely.freely.controllers;

import com.freely.freely.DTO.ServicesDTO;
import com.freely.freely.entities.Services;
import com.freely.freely.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
=======
import org.springframework.http.HttpStatus;
>>>>>>> 35f0f6c6969e13c147614e6680ee41ed6a48b0d7
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
<<<<<<< HEAD
    public ResponseEntity<Services> create(
=======
    @ResponseStatus(HttpStatus.CREATED)
    public Services create(
>>>>>>> 35f0f6c6969e13c147614e6680ee41ed6a48b0d7
            @RequestBody ServicesDTO servicesDTO
            ) throws SQLException {
        return serviceService.create(servicesDTO);
    }

    @PutMapping("/{id}")
    public Services update(@PathVariable Integer id, @RequestBody ServicesDTO servicesDTO) throws SQLException {
        return serviceService.update(id, servicesDTO);
    }
}
