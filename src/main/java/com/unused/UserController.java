//package com.controller;
//
//import com.entity.User;
//import com.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/user")
//
//public class UserController{
//    @Autowired
//    private UserService userService ;
//
//    @GetMapping("/list")
//    public List<User> getUser(){
//        return userService.getAllUser();
//    }
//
//    @GetMapping("/list/{id}")
//    public User getSelectedUser(@PathVariable int id){
//        return userService.getSelectedUser(id);
//    }
//
//    @PostMapping("/add")
//    public User addUser(@RequestBody User user){
//        return userService.addUser(user);
//    }
//
//    @PutMapping("/update/{id}")
//    public User updateUser(@PathVariable int id,@RequestBody User user){
//        return userService.updateUser(id,user);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public List<User> deleteUser(@PathVariable int id){
//        return userService.deleteUser(id);
//    }
//
//}