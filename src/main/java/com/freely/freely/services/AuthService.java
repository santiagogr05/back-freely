package com.freely.freely.services;

import com.freely.freely.DTO.auth.LoginDTO;
import com.freely.freely.DTO.auth.RegisterDTO;
import com.freely.freely.DTO.auth.ResponseDTO;
import com.freely.freely.entities.User;
import com.freely.freely.mappers.AuthMapper;
import com.freely.freely.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private AuthMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserRepository repository;

    @Autowired
    private JwtService jwtService;

    @Override
    public ResponseDTO login(LoginDTO loginDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password()));
        UserDetails user = repository.findByEmail(loginDTO.email()).orElseThrow();
        String token = jwtService.getToken(user);
        return ResponseDTO.builder()
                .token(token)
                .build();
    }

    @Override
    public ResponseDTO register(RegisterDTO registerDTO) {
        User user = mapper.toEntity(registerDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRegistrationDate(LocalDateTime.now());
        repository.save(user);
        return ResponseDTO
                .builder()
                .token(jwtService.getToken(user))
                .build();


    }
}
