package com.freely.freely.DTO.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @Email(message = "Must be a valid email address")
        String email,
        @NotBlank(message = "Password is required")
        String password
) {
}
