package com.freely.freely.services;

import com.freely.freely.DTO.user.CreateUserDTO;
import com.freely.freely.DTO.user.ResponseUserDTO;
import com.freely.freely.entities.User;
import com.freely.freely.mappers.UserMapper;
import com.freely.freely.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<ResponseUserDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public ResponseUserDTO save(CreateUserDTO dto) {
        User user = mapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = repository.save(user);
        return mapper.toDto(savedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByEmail(String email) {
        return repository.findUserByEmail(email);
    }
}
