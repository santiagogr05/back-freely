package com.freely.freely.controllers;

import com.freely.freely.DTO.ServicesDTO;
import com.freely.freely.entities.FreelancerService;
import com.freely.freely.services.FreelancerServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/services")
public class FreelancerServiceController {
    @Autowired
    private FreelancerServiceService service;

    @GetMapping("")
    public List<FreelancerService> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Integer id) {
        Optional<FreelancerService> freelancerServiceOptional = service.findById(id);
        // Verifies if the freelancer service is in the database
        if (freelancerServiceOptional.isPresent()) {
            return ResponseEntity.ok(freelancerServiceOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<FreelancerService> create(@RequestBody FreelancerService freelancerService) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(freelancerService));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FreelancerService> update(@PathVariable Integer id, @RequestBody FreelancerService freelancerService) {
        freelancerService.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(freelancerService));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        FreelancerService freelancerService = new  FreelancerService();
        freelancerService.setId(id);
        Optional<FreelancerService> freelancerServiceOptional = service.delete(freelancerService);
        if (freelancerServiceOptional.isPresent()) {
            return ResponseEntity.ok(freelancerServiceOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
