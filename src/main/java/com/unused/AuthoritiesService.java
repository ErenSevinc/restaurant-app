package com.unused;

import com.unused.AuthoritiesDTO;
import com.unused.AuthoritiesConverter;
import com.unused.Authorities;
import com.unused.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthoritiesService {

    @Autowired
    AuthoritiesRepository authoritiesRepository;


    public List<AuthoritiesDTO> authoritiesList(){
        List<Authorities> authList=authoritiesRepository.findAll();
        return AuthoritiesConverter.authoritiesList(authList);

    }

    public String addAuth(AuthoritiesDTO authoritiesDto){

        authoritiesRepository.save(AuthoritiesConverter.addAuth(authoritiesDto));
        return "Auth Eklendi";
    }

    public String deleteAuth(String username){

        authoritiesRepository.deleteById(username);
        return "Auth Silindi";
    }

    public List<AuthoritiesDTO> updateAuth (AuthoritiesDTO authoritiesDTO){
        authoritiesRepository.saveAndFlush(AuthoritiesConverter.updateAuth(authoritiesDTO));
        return authoritiesList();
    }
}