package com.freely.freely.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "project_statuses")
public class ProjectStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String status;
}
