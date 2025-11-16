package com.freely.freely.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Table
@Entity(name="skills")
public class Skill {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String skill;

    @ManyToMany
    @JoinTable(
            name = "profile_skills",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id")
    )
    private Set<Profile> profiles = new HashSet<>();
}
