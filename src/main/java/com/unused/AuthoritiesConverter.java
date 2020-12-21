package com.unused;

import java.util.ArrayList;
import java.util.List;

public class AuthoritiesConverter {

    public static List<AuthoritiesDTO> authoritiesList(List<Authorities> authList) {
        List<AuthoritiesDTO> authDTOList = new ArrayList<>();

        for (Authorities auth : authList) {

            AuthoritiesDTO authDTO = new AuthoritiesDTO();
            authDTO.setUsername(auth.getUsername());
            authDTO.setAuthority(auth.getAuthority());
            authDTOList.add(authDTO);
        }
        return authDTOList;
    }
    public static Authorities addAuth(AuthoritiesDTO authoritiesDto){

        Authorities authorities=new Authorities();
        authorities.setUsername(authoritiesDto.getUsername());
        authorities.setAuthority(authoritiesDto.getAuthority());

        return authorities;
    }
    public static Authorities updateAuth (AuthoritiesDTO authoritiesDTO){

        Authorities authorities=new Authorities();
        authorities.setUsername(authoritiesDTO.getUsername());
        authorities.setAuthority(authoritiesDTO.getAuthority());

        return authorities;
    }
}


