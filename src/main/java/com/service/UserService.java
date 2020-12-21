package com.service;

import com.DTO.RoleDTO;
import com.DTO.UsersDTO;
import com.converter.RoleDTOConverter;
import com.converter.UserDTOConverter;
import com.entity.Role;
import com.entity.User;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<UsersDTO> listUsers(List<UsersDTO> usersDTOList){
        List<User> usrList=userRepository.findAll();
//        userRepository.findAll().iterator().forEachRemaining(usersDTOList::add);
        return UserDTOConverter.listUsers(usrList);
    }
    public UsersDTO getSelectedUser(int id){
        User user=userRepository.findById(id).get();
        return UserDTOConverter.addUserDTORoleIDToRole(user);
    }

    public UsersDTO addUser(UsersDTO usersDTO){
//        User user=userRepository.save(UserDTOConverter.addUserRoleIDToDTO(usersDTO));
//        return UserDTOConverter.addUserDTORoleIDToRole(user);
        User user = UserDTOConverter.addUserRoleIDToDTO(usersDTO);
        for(int i=0;i<usersDTO.getRolesDTO().size();i++){
            Role role=roleRepository.findById(usersDTO.getRolesDTO().get(i).getId()).get();
            user.getRoles().add(role);
        }
        userRepository.save(user);
        return UserDTOConverter.addUserDTORoleIDToRole(user);
    }
    public UsersDTO updateUser(UsersDTO usersDTO){
        Role role=new Role();
        role.setName("ROLE_REPORTER");
        User user= userRepository.getUserByUsername(usersDTO.getUsername());
        user.setRoles(null);
        userRepository.saveAndFlush(UserDTOConverter.updateUserRoleIDToDTO(usersDTO));

        return UserDTOConverter.updateUserDTORoleIDToRole(user);
    }

    public List<RoleDTO> listRoles(List<RoleDTO> rolesDTO){
        List<Role> roles=roleRepository.findAll();
        return RoleDTOConverter.roleListConvertToRoleDTOList(roles);
    }

    public String deleteUser(int id){
        User user= userRepository.findById(id).get();
        user.setRoles(null);
        userRepository.delete(user);

       return "user deleted";

    }



}
