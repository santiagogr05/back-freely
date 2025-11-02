package com.freely.freely.mappers;

import com.freely.freely.DTO.auth.RegisterDTO;
import com.freely.freely.DTO.auth.ResponseDTO;
import com.freely.freely.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthMapper {
    User toEntity(RegisterDTO registerDTO);
    ResponseDTO toDTO(User user);
}
