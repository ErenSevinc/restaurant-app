package com.service;

import com.DTO.UsersDTO;
import com.converter.AuthoritiesConverter;
import com.converter.UsersConverter;
import com.entity.Authorities;
import com.entity.Users;
import com.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;
    
    public List<UsersDTO> listUsers(){
        List<?> usersList=usersRepository.findAll();
        return (List<UsersDTO>)usersList;
    }

    public UsersDTO listUsersByUserName(String username){
        Optional<Users> list =usersRepository.findById(username);
        return UsersConverter.listUsersByUserName(list);
    }

    public String addUsers(UsersDTO usersDTO){
        usersRepository.save(UsersConverter.addUsers(usersDTO));
        return "Users Added";
    }

    public String deleteUsers(String username){
        usersRepository.deleteById(username);
        //return listUsers();
        return "Users Deleted";
    }

    public List<UsersDTO> updateUsers (UsersDTO usersDto){
        usersRepository.saveAndFlush(UsersConverter.updateUsers(usersDto));
        return listUsers();
    }
}
