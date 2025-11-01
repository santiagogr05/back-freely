package com.freely.freely.DTO.user;

public record ResponseUserDTO(
        Integer id,
        String name,
        String email,
        String role) {
}
