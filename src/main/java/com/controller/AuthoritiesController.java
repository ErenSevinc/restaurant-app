package com.controller;

import com.DTO.AuthoritiesDTO;
import com.entity.Authorities;
import com.service.AuthoritiesService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthoritiesController {

    @Autowired
    AuthoritiesService authoritiesService;

    @GetMapping("/listall")
    public List<AuthoritiesDTO> authoritiesList(){
        return authoritiesService.authoritiesList();
    }

    @PostMapping("/add")
    public String addAuth(@RequestBody AuthoritiesDTO authoritiesDTO){
        authoritiesService.addAuth(authoritiesDTO);
        return "Auth Added";
    }

    @DeleteMapping("/delete/{username}")
    public String deleteAuth(@PathVariable String username){
         authoritiesService.deleteAuth(username);
         return "Auth Deleted";
    }

    @PutMapping("/update")
    public String updateAuth(@RequestBody AuthoritiesDTO authoritiesDTO){
         authoritiesService.updateAuth(authoritiesDTO);
        return "Auth Updated";
    }

}
