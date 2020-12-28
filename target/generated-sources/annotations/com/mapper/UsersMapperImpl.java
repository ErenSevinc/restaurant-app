package com.mapper;

import com.DTO.RoleDTO;
import com.DTO.UsersDTO;
import com.entity.Role;
import com.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-27T21:43:35+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class UsersMapperImpl implements UsersMapper {

    @Override
    public List<UsersDTO> toDTOList(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UsersDTO> list = new ArrayList<UsersDTO>( userList.size() );
        for ( User user : userList ) {
            list.add( toDTO( user ) );
        }

        return list;
    }

    @Override
    public UsersDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UsersDTO usersDTO = new UsersDTO();

        usersDTO.setRolesDTO( roleListToRoleDTOList( user.getRoles() ) );
        usersDTO.setId( user.getId() );
        usersDTO.setEmail( user.getEmail() );
        usersDTO.setUsername( user.getUsername() );
        usersDTO.setPassword( user.getPassword() );
        usersDTO.setEnabled( user.isEnabled() );

        return usersDTO;
    }

    @Override
    public User toEntity(UsersDTO usersDTO) {
        if ( usersDTO == null ) {
            return null;
        }

        User user = new User();

        user.setRoles( roleDTOListToRoleList( usersDTO.getRolesDTO() ) );
        user.setId( usersDTO.getId() );
        user.setEmail( usersDTO.getEmail() );
        user.setUsername( usersDTO.getUsername() );
        user.setPassword( usersDTO.getPassword() );
        user.setEnabled( usersDTO.isEnabled() );

        return user;
    }

    protected RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( role.getId() );
        roleDTO.setName( role.getName() );

        return roleDTO;
    }

    protected List<RoleDTO> roleListToRoleDTOList(List<Role> list) {
        if ( list == null ) {
            return null;
        }

        List<RoleDTO> list1 = new ArrayList<RoleDTO>( list.size() );
        for ( Role role : list ) {
            list1.add( roleToRoleDTO( role ) );
        }

        return list1;
    }

    protected Role roleDTOToRole(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDTO.getId() );
        role.setName( roleDTO.getName() );

        return role;
    }

    protected List<Role> roleDTOListToRoleList(List<RoleDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Role> list1 = new ArrayList<Role>( list.size() );
        for ( RoleDTO roleDTO : list ) {
            list1.add( roleDTOToRole( roleDTO ) );
        }

        return list1;
    }
}
