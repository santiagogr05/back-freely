package com.freely.freely.DTO.auth;

import lombok.Builder;

@Builder
public record ResponseDTO(
        String token
) {
}
