package com.controller;

import com.entity.Users;
import com.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("/loadadminusers")
    public void loadAdmin(){
        List<Users> list=new ArrayList<>();
        Users users1 = new Users("admin","{noop}pass3",true);
        Users users2 = new Users("user1","{noop}pass1",true);
        list.add(users1);
        list.add(users2);
        usersService.loadAdmin(list);
    }

    @GetMapping("/listall")
    public List<Users> listUsers(){
        return usersService.listUsers();
    }
    @GetMapping("/listall/{username}")
    public Optional<Users> listUsersByUserName(@PathVariable String username){
        return usersService.listUsersByUserName(username);
    }

    @PostMapping("/add")
    public void addUsers(@RequestBody Users users){
        usersService.addUsers(users);
    }

    @DeleteMapping("/delete/{username}")
    public List<Users> deleteUsers(@PathVariable String username){
        return usersService.deleteUsers(username);
    }

    @PutMapping("/update")
    public List<Users> updateUsers(@RequestBody Users users){
        return usersService.updateUsers(users);
    }
}