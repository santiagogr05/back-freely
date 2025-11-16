package com.freely.freely.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="freelancers")
public class Freelancer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName="id")
    private User user;
    private String availabilty;

    @ManyToOne
    @JoinColumn(name="proficency_level_id", referencedColumnName="id")
    private ProficencyLevel proficencyLevel;

    private String certifications;

    @OneToOne
    @JoinColumn(name="profile_id", referencedColumnName="id")
    private Profile profile;

    private String career;

    @ManyToMany
    @JoinTable(
            name = "freelancer_languages",
            joinColumns = @JoinColumn(name = "freelancer_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private Set<Language> languages = new HashSet<>();


}
