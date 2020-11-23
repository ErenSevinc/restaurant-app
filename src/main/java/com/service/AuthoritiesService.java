package com.service;

import com.entity.Authorities;
import com.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthoritiesService {

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    public void loadAdmin(List<Authorities> list){
        authoritiesRepository.saveAll(list);
    }

    public List<Authorities> authoritiesList(){
        return authoritiesRepository.findAll();
    }

    public void addAuth(Authorities auth){
        authoritiesRepository.save(auth);
    }

    public List<Authorities> deleteAuth(String username){
        authoritiesRepository.deleteById(username);
        return authoritiesList();
    }

    public List<Authorities> updateAuth (Authorities auth){
        authoritiesRepository.saveAndFlush(auth);
        return authoritiesList();
    }
}