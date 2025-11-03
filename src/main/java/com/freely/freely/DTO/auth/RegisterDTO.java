package com.freely.freely.DTO.auth;

import com.freely.freely.entities.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Registration request DTO for creating a new user account")
public record RegisterDTO(
        @Schema(description = "User's email address", example = "newuser@example.com", required = true)
        @Email(message = "Must be a valid email address")
        String email,

        @Schema(description = "User's full name", example = "John Doe", required = true)
        @NotBlank(message = "Name is required")
        String name,

        @Schema(description = "User's password", example = "SecurePassword123!", required = true)
        @NotBlank(message = "Password is required")
        String password,

        @Schema(description = "User's role in the system", example = "FREELANCER", required = true)
        UserRole role
) {
}
