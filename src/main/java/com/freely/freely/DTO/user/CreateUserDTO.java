package com.freely.freely.DTO.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserDTO(
        @NotBlank(message = "Name is required")
        String name,
        @Email(message = "Must be a valid email address")
        String email,
        @NotBlank(message = "Password is required")
        String password) {


}
