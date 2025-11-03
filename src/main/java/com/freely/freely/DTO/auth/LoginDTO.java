package com.freely.freely.DTO.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Login request DTO containing user credentials")
public record LoginDTO(
        @Schema(description = "User's email address", example = "user@example.com", required = true)
        @Email(message = "Must be a valid email address")
        String email,

        @Schema(description = "User's password", example = "SecurePassword123!", required = true)
        @NotBlank(message = "Password is required")
        String password
) {
}
