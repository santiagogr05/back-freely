package com.freely.freely.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "languages")
public class Language {

    private Freelancer freelancer;
    private Language language;
}
