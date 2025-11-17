package com.freely.freely.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="services")
public class FreelancerService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String service;
    private String description;
    private String category;

    @ManyToMany
    @JoinTable(
            name = "profile_services",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id")
    )
    @JsonIgnore
    private Set<Profile> profiles = new HashSet<>();
}
