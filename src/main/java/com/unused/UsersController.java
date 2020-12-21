//package com.controller;
//
//import com.DTO.UsersDTO;
//import com.service.UsersService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/users")
//@CrossOrigin(origins = "*")
//public class UsersController {
//
//    @Autowired
//    UsersService usersService;
//
//
//    @GetMapping("/listall")
//    public List<UsersDTO> listUsers(){
//        return usersService.listUsers();
//    }
//    @GetMapping("/listall/{username}")
//    public UsersDTO listUsersByUserName(@PathVariable String username){
//        return usersService.listUsersByUserName(username);
//    }
//
//    @PostMapping("/add")
//    public String addUsers(@RequestBody UsersDTO usersDTO){
//        usersService.addUsers(usersDTO);
//        return "Users Added";
//    }
//
//    @DeleteMapping("/delete/{username}")
//    public String deleteUsers(@PathVariable String username){
//        usersService.deleteUsers(username);
//        return "Users Deleted";
//    }
//
//    @PutMapping("/update")
//    public List<UsersDTO> updateUsers(@RequestBody UsersDTO usersDTO){
//        return usersService.updateUsers(usersDTO);
//    }
//}