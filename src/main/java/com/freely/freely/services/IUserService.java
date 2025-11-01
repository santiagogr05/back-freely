package com.freely.freely.services;

import com.freely.freely.DTO.user.CreateUserDTO;
import com.freely.freely.DTO.user.ResponseUserDTO;
import com.freely.freely.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<ResponseUserDTO> findAll();
    ResponseUserDTO save(CreateUserDTO dto);
    Optional<User> findByEmail(String email);

}
