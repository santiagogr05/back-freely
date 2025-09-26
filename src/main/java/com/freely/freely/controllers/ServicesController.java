package com.freely.freely.controllers;

import com.freely.freely.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/")
    public String findAll(){
        return serviceService.findAll().toString();
    }
}
