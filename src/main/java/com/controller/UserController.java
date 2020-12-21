package com.controller;

import com.DTO.RoleDTO;
import com.DTO.UsersDTO;
import com.entity.Role;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;




//    @GetMapping("/add")
//    Role role = roleRepository.findById(1).get();

    @GetMapping("/login")
    public void loginAdmin(){

    }

    @GetMapping("/list")
    public List<UsersDTO> listUsers(){
        List<UsersDTO> usersDTOList =new ArrayList<>();
        return userService.listUsers(usersDTOList);
    }
    @GetMapping("/list/{id}")
    public UsersDTO listUsersById(@PathVariable int id){
        return userService.getSelectedUser(id);
    }
    @PostMapping("/add")
    public String addUser(@RequestBody UsersDTO usersDTO){
        userService.addUser(usersDTO);
        return "User Added";
    }
    @PutMapping("/update")
    public String updateUser(@RequestBody UsersDTO usersDTO){
        userService.updateUser(usersDTO);
        return "User Updated";
    }
    @GetMapping("list-roles")
    public List<RoleDTO> listRoles(){
        List<RoleDTO> rolesDTO=new ArrayList<>();
        return userService.listRoles(rolesDTO);
    }
    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return "user deleted";
    }

}
