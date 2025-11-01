package com.freely.freely.mappers;

import com.freely.freely.DTO.user.CreateUserDTO;
import com.freely.freely.DTO.user.ResponseUserDTO;
import com.freely.freely.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(CreateUserDTO dto);
    ResponseUserDTO toDto(User user);
}
