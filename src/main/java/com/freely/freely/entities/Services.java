package com.freely.freely.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Services {
    private Integer id;
    private String service;
    private String description;
    private String category;

    public Services(String service, String description, String category) {
        this.service = service;
        this.description = description;
        this.category = category;
    }
}
