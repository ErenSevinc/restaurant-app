package com.builder.DTOBuilder;

import com.DTO.AuthoritiesDTO;
import com.builder.Builder;

public class AuthoritiesDTOBuilder extends Builder {
    private String username;
    private String authority;

    public AuthoritiesDTOBuilder username(String username){
        this.username=username;
        return this;
    }
    public AuthoritiesDTOBuilder authority(String authority){
        this.authority=authority;
        return this;
    }

    @Override
    public AuthoritiesDTO build() {
        AuthoritiesDTO authoritiesDTO=new AuthoritiesDTO();
        authoritiesDTO.setUsername(this.username);
        authoritiesDTO.setAuthority(this.authority);
        return authoritiesDTO;
    }
}

