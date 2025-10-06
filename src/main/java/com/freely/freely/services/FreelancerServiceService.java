package com.freely.freely.services;

import com.freely.freely.entities.FreelancerService;
import com.freely.freely.respositories.FreelancerServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FreelancerServiceService implements IFreelancerServiceService {

    @Autowired
    private FreelancerServiceRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<FreelancerService> findAll() {
        return (List<FreelancerService>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<FreelancerService> findById(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public FreelancerService save(FreelancerService service) {
        return repository.save(service);
    }

    @Transactional
    @Override
    public Optional<FreelancerService> update(Integer id, FreelancerService freelancerService) {
        Optional<FreelancerService> serviceOptional = repository.findById(id);
        if (serviceOptional.isPresent() ) {
            FreelancerService serviceDb = serviceOptional.orElseThrow();
            serviceDb.setService(freelancerService.getService());
            serviceDb.setDescription(freelancerService.getDescription());
            serviceDb.setCategory(freelancerService.getCategory());
            return Optional.of(repository.save(serviceDb));

        };
        return serviceOptional;
    }

    @Transactional
    @Override
    public Optional<FreelancerService> delete(Integer id) {
        Optional<FreelancerService> serviceOptional = repository.findById(id);
        serviceOptional.ifPresent(serviceDb -> repository.delete(serviceDb));
        return serviceOptional;
    }
}
