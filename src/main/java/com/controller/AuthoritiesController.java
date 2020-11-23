package com.controller;

import com.entity.Authorities;
import com.service.AuthoritiesService;
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

    @GetMapping("/loadadminauth")
    public void loadAdmin(){
        List<Authorities> list=new ArrayList<>();
        Authorities auth = new Authorities("admin","ROLE_ADMIN");
        Authorities auth2=new Authorities("user1","ROLE_USER");
        list.add(auth);
        list.add(auth2);
        authoritiesService.loadAdmin(list);
    }

    @GetMapping("/listall")
    public List<Authorities> authoritiesList(){
        return authoritiesService.authoritiesList();
    }

    @PostMapping("/add")
    public void addAuth(@RequestBody Authorities auth){
        authoritiesService.addAuth(auth);
    }

    @DeleteMapping("/delete/{username}")
    public List<Authorities> deleteAuth(@PathVariable String username){
        return authoritiesService.deleteAuth(username);
    }

    @PutMapping("/update")
    public List<Authorities> updateAuth(@RequestBody Authorities auth){
        return authoritiesService.updateAuth(auth);
    }

}
