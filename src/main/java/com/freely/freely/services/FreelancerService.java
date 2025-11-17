package com.freely.freely.services;

import com.freely.freely.DTO.freelancer.FreelancerCardDTO;
import com.freely.freely.entities.Freelancer;
import com.freely.freely.mappers.FreelancerCardMapper;
import com.freely.freely.repositories.FreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class FreelancerService implements IFreelancerService{

    @Autowired
    private FreelancerRepository repository;

    @Autowired
    private FreelancerCardMapper mapper;

    @Override
    public List<FreelancerCardDTO> getTopFreelancers() {
        Pageable pageable = PageRequest.of(0, 6, Sort.by(Sort.Direction.DESC, "id"));

        List<Freelancer> freelancers = repository.findAll(pageable).getContent();
        return mapper.toCardDTOs(freelancers);
    }
}
