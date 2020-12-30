package com.service;

import com.DTO.RoleDTO;
import com.DTO.UsersDTO;
import com.converter.RoleDTOConverter;
import com.converter.UserDTOConverter;
import com.entity.Role;
import com.entity.User;
import com.exception.BusinessRuleException;
import com.exception.SystemException;
import com.mapper.RoleMapper;
import com.mapper.UsersMapper;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<UsersDTO> listUsers(List<UsersDTO> usersDTOList){
//        userRepository.findAll().iterator().forEachRemaining(usersDTOList::add);
        return usersMapper.toDTOList(userRepository.findAll());
    }
    public UsersDTO getSelectedUser(int id){
//        User user=userRepository.findById(id).get();
//        return UserDTOConverter.addUserDTORoleIDToRole(user);
        return usersMapper.toDTO(userRepository.findById(id).orElseThrow(()->new BusinessRuleException("User not found")));
    }
    @Transactional
    public UsersDTO addUser(UsersDTO usersDTO){

        usersDTO.setPassword(encoder.encode(usersDTO.getPassword()));
        User user= usersMapper.toEntity(usersDTO);
        userRepository.save(user);

        return usersMapper.toDTO(user);
    }

    public UsersDTO updateUser(UsersDTO usersDTO){
        Role role=new Role();
        role.setName("ROLE_REPORTER");
        User user= userRepository.getUserByUsername(usersDTO.getUsername());
        user.setRoles(null);
        userRepository.save(usersMapper.toEntity(usersDTO));

        return usersMapper.toDTO(user);
    }

    public List<RoleDTO> listRoles(List<RoleDTO> rolesDTO){
//        List<Role> roles=roleRepository.findAll();
//        return RoleDTOConverter.roleListConvertToRoleDTOList(roles);
        return roleMapper.toDTOList(roleRepository.findAll());
    }

    public String deleteUser(int id){
        User user= userRepository.findById(id).orElseThrow(()->new BusinessRuleException("User not found"));
        user.setRoles(null);
        userRepository.delete(user);

       return "user deleted";

    }



}
