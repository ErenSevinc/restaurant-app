package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HelloController {

    @GetMapping("/user")
    public String sayHelloUser(){
        return "hi User";
    }
    @GetMapping("/admin")
    public String sayHelloAdmin(){
        return "hi Admin";
    }
}