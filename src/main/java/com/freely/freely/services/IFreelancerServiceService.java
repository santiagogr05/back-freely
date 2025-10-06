package com.freely.freely.services;

import com.freely.freely.entities.FreelancerService;

import java.util.List;
import java.util.Optional;

public interface IFreelancerServiceService {
    List<FreelancerService> findAll();
    Optional<FreelancerService> findById(Integer id);
    FreelancerService save(FreelancerService services);
    Optional<FreelancerService> delete(FreelancerService services);
}
