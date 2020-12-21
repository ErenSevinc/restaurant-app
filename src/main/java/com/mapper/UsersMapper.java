package com.mapper;

import com.DTO.UsersDTO;
import com.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsersMapper {
    UsersMapper INSTANCE= Mappers.getMapper(UsersMapper.class);

//    @Mapping(source ="RoleDTO.rolesDTO",target = "Role.roles")
//    UsersDTO toDTO(User user);
    @Mapping(source ="roles",target = "rolesDTO")
    UsersDTO toDTO(User user);

    @Mapping(source = "rolesDTO",target="roles")
    User toEntity(UsersDTO usersDTO);
}
