package com.freely.freely.controllers;

import com.freely.freely.DTO.freelancer.FreelancerCardDTO;
import com.freely.freely.services.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/freelancers")
public class FreelancerController {

    @Autowired
    private FreelancerService service;

    @GetMapping("/cards")
    public ResponseEntity<List<FreelancerCardDTO>> getTopFreelancers() {
        return ResponseEntity.ok(service.getTopFreelancers());
    }

    @GetMapping("/all")
    public ResponseEntity<List<FreelancerCardDTO>> getAllFreelancers() {
        return ResponseEntity.ok(service.getAllFreelancers());
    }

    @GetMapping("{id}")
    public ResponseEntity<FreelancerCardDTO> getFreelancerById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getFreelancerById(id));
    }

}
