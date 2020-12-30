package com.controller;

import com.DTO.RoleDTO;
import com.DTO.UsersDTO;
import com.configuration.LocaleConfig;
import com.entity.Role;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

//    @GetMapping("/add")
//    Role role = roleRepository.findById(1).get();

    @GetMapping("/login")
    public String loginAdmin(@RequestHeader("Accept-Language")String locale){
        return LocaleConfig.messageSource().getMessage("hello.txt",null,new Locale(locale));
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
    public UsersDTO addUser(@Valid @RequestBody UsersDTO usersDTO){
        return userService.addUser(usersDTO);
    }
    @PutMapping("/update/{id}")
    public String updateUser(@Valid @RequestBody UsersDTO usersDTO){
        userService.updateUser(usersDTO);
        return "User Updated";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
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
