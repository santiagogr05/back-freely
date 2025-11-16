package com.freely.freely.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Table
@Entity(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String language;

    @ManyToMany
    @JoinTable(
            name = "freelancer_languages",
            joinColumns = @JoinColumn(name = "language_id"),
            inverseJoinColumns = @JoinColumn(name = "freelancer_id")
    )
    private Set<Freelancer> freelancers = new HashSet<>();
}
