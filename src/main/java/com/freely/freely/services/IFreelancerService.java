package com.freely.freely.services;

import com.freely.freely.DTO.freelancer.FreelancerCardDTO;

import java.util.List;

public interface IFreelancerService {
    List<FreelancerCardDTO> getTopFreelancers();
}
