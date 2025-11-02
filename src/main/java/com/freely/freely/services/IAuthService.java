package com.freely.freely.services;

import com.freely.freely.DTO.auth.LoginDTO;
import com.freely.freely.DTO.auth.RegisterDTO;
import com.freely.freely.DTO.auth.ResponseDTO;

public interface IAuthService {
    ResponseDTO login(LoginDTO loginDTO);
    ResponseDTO register(RegisterDTO registerDTO);
}
