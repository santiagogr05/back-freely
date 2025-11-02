package com.freely.freely.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "freelancers")
public class Freelancer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    private String availability;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proficency_level_id")
    private ProficencyLevel proficencyLevel;
}

