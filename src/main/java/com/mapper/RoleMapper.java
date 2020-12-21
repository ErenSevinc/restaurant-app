package com.mapper;

import com.DTO.RoleDTO;
import com.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDTO toDTO(Role role);
    Role toEntity(RoleDTO roleDTO);

}
