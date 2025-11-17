package com.freely.freely.mappers;

import com.freely.freely.DTO.freelancer.FreelancerCardDTO;
import com.freely.freely.entities.Freelancer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FreelancerCardMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(
            target = "name",
            expression = "java(freelancer.getUser().getName())"
    )
    @Mapping(target = "career", source = "career")
    @Mapping(target = "description", expression = "java(freelancer.getProfile().getDescription())")
    @Mapping(
            target = "skills",
            expression = "java(freelancer.getProfile().getSkills().stream().map(Skill -> Skill.getSkill()).toList())"
    )
    FreelancerCardDTO toCardDTO(Freelancer freelancer);

    List<FreelancerCardDTO> toCardDTOs(List<Freelancer> freelancers);

}
