package com.mapper;

import com.DTO.RoleDTO;
import com.entity.Role;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-21T15:46:33+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDTO toDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( role.getId() );
        roleDTO.setName( role.getName() );

        return roleDTO;
    }

    @Override
    public Role toEntity(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDTO.getId() );
        role.setName( roleDTO.getName() );

        return role;
    }
}
