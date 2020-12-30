package com.converter;

import com.DTO.RoleDTO;
import com.DTO.UsersDTO;
import com.entity.Role;
import com.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserDTOConverter {
    private static final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    public static List<UsersDTO> listUsers(List<User> usersList) {

        List<UsersDTO> usersDTOList = new ArrayList<>();
        for(User usr:usersList){
            UsersDTO usrDTO = new UsersDTO();
            usrDTO.setId(usr.getId());
            usrDTO.setEmail(usr.getEmail());
            usrDTO.setUsername(usr.getUsername());
            usrDTO.setEnabled(usr.isEnabled());
            usrDTO.setPassword(usr.getPassword());
            usrDTO.setRolesDTO(RoleDTOConverter.roleListConvertToRoleDTOList(usr.getRoles()));
            usersDTOList.add(usrDTO);
        }
        return usersDTOList;
    }

    public static User addUserRoleIDToDTO(UsersDTO usersDTO){

        User user =new User();
        user.setId(usersDTO.getId());
        user.setEmail(usersDTO.getEmail());
        user.setUsername(usersDTO.getUsername());
        user.setPassword(encoder.encode(usersDTO.getPassword()));
        user.setEnabled(usersDTO.isEnabled());
        user.setRoles(RoleDTOConverter.roleDTOListConvertToroleList(usersDTO.getRolesDTO()));

        return user;
    }

    public static UsersDTO addUserDTORoleIDToRole(User user){

        UsersDTO usersDTO =new UsersDTO();
        usersDTO.setId(user.getId());
        usersDTO.setEmail(user.getEmail());
        usersDTO.setUsername(user.getUsername());
        usersDTO.setPassword(encoder.encode(user.getPassword()));
        usersDTO.setEnabled(user.isEnabled());
        usersDTO.setRolesDTO(RoleDTOConverter.roleListConvertToRoleDTOList(user.getRoles()));
        return usersDTO;
    }

    public static User updateUserRoleIDToDTO(UsersDTO usersDTO){

        User user =new User();
        user.setId(usersDTO.getId());
        user.setEmail(usersDTO.getEmail());
        user.setUsername(usersDTO.getUsername());
        user.setPassword(encoder.encode(usersDTO.getPassword()));
        user.setEnabled(usersDTO.isEnabled());
        user.getRoles().addAll(RoleDTOConverter.roleDTOListConvertToroleList(usersDTO.getRolesDTO()));

        return user;

    }
    public static UsersDTO updateUserDTORoleIDToRole(User user){

        UsersDTO usersDTO =new UsersDTO();
        usersDTO.setId(user.getId());
        usersDTO.setEmail(user.getEmail());
        usersDTO.setUsername(user.getUsername());
        usersDTO.setPassword(encoder.encode(user.getPassword()));
        usersDTO.setEnabled(user.isEnabled());
        usersDTO.setRolesDTO(RoleDTOConverter.roleListConvertToRoleDTOList(user.getRoles()));
        return usersDTO;
    }

}
