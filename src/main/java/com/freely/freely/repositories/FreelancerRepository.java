package com.freely.freely.repositories;

import com.freely.freely.entities.Freelancer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelancerRepository extends JpaRepository<Freelancer, Integer> {
    @EntityGraph(attributePaths = {"user", "profile", "profile.skills"})
    Page<Freelancer> findAll(Pageable pageable);
}
