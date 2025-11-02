package com.freely.freely.DTO.auth;

import com.freely.freely.entities.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
        @Email(message = "Must be a valid email address")
        String email,
        @NotBlank(message = "Name is required")
        String name,
        @NotBlank(message = "Password is required")
        String password,
        UserRole role
) {
}
