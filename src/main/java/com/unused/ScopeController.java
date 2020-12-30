package com.unused;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/scope")
public class ScopeController {
    @Autowired
    PrototypeScopeComponent prototypeScopeComponent;
    @Autowired
    SingeltonScopeComponent singeltonScopeComponent;
    @Autowired
    RequestScopeComponent requestScopeComponent;
    @Autowired
    SessionScopeComponent sessionScopeComponent;

    @GetMapping("/prototype")
    public long getPrototype(){
        prototypeScopeComponent.printInstanceInfo();
        return System.identityHashCode(prototypeScopeComponent);
    }
    @GetMapping("/singelton")
    public long getSingelton(){
        singeltonScopeComponent.printInstanceInfo();
        return System.identityHashCode(prototypeScopeComponent);
    }
    @GetMapping("/request")
    public long getRequest(){
        requestScopeComponent.printInstanceInfo();
        return System.identityHashCode(prototypeScopeComponent);
    }
    @GetMapping("/session")
    public long getSession(){
        sessionScopeComponent.printInstanceInfo();
        return System.identityHashCode(prototypeScopeComponent);
    }


}
