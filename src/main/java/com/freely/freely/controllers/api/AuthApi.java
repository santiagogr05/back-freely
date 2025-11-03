package com.freely.freely.controllers.api;

import com.freely.freely.DTO.auth.LoginDTO;
import com.freely.freely.DTO.auth.RegisterDTO;
import com.freely.freely.DTO.auth.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Authentication", description = "Authentication management APIs")
public interface AuthApi {

    @Operation(
            summary = "User Login",
            description = "Authenticate a user with email and password and return a JWT token."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful authentication",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Invalid credentials"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input data"
            )
    })
    ResponseEntity<ResponseDTO> login(@Valid @RequestBody LoginDTO loginDTO);

    @Operation(
            summary = "User Registration",
            description = "Register a new user and return a JWT token."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "User successfully registered",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input data or user already exists"
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Email already in use"
            )
    })
    ResponseEntity<ResponseDTO> register(@Valid @RequestBody RegisterDTO registerDTO);
}
