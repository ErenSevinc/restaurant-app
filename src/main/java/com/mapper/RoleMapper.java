package com.mapper;

import com.DTO.RoleDTO;
import com.DTO.UsersDTO;
import com.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
//    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleMapper INSTANCE =null;

    List<RoleDTO> toDTOList(List<Role> roleList);

    List<Role> toEntityList(List<RoleDTO> roleDTOList);

    RoleDTO toDTO(Role role);

    Role toEntity(RoleDTO roleDTO);

}
