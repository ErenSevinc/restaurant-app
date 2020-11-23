package com.service;

import com.entity.Users;
import com.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public void loadAdmin(List<Users> users){
        usersRepository.saveAll(users);
    }

    public List<Users> listUsers(){
        return usersRepository.findAll();
    }
    public Optional<Users> listUsersByUserName(String username){
        return usersRepository.findById(username);
    }

    public void addUsers(Users users){
        usersRepository.save(users);
    }

    public List<Users> deleteUsers(String username){
        usersRepository.deleteById(username);
        return listUsers();
    }

    public List<Users> updateUsers (Users users){
        usersRepository.saveAndFlush(users);
        return listUsers();
    }
}
