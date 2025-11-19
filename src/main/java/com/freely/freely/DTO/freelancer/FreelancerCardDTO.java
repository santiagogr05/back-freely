package com.freely.freely.DTO.freelancer;

import java.util.List;

public record FreelancerCardDTO(
        Integer id,
        String name,
        String career,
        String description,
        List<String> skills
) {
}
