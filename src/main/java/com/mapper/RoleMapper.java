package com.mapper;

import com.DTO.RoleDTO;
import com.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
//    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleMapper INSTANCE =null;

    List<RoleDTO> toDTOList(List<Role> roleList);

    RoleDTO toDTO(Role role);

    Role toEntity(RoleDTO roleDTO);

}
