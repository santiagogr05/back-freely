package com.freely.freely.controllers;

import com.freely.freely.DTO.auth.LoginDTO;
import com.freely.freely.DTO.auth.RegisterDTO;
import com.freely.freely.DTO.auth.ResponseDTO;
import com.freely.freely.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;

    @PostMapping(value = "/login")
    public ResponseEntity<ResponseDTO> login(@Valid @RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(service.login(loginDTO));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<ResponseDTO> register(@Valid @RequestBody RegisterDTO registerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.register(registerDTO));
    }
}
