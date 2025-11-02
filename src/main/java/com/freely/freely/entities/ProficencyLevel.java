package com.freely.freely.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "proficency_levels")
public class ProficencyLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String level;
}
