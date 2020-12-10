package com.builder;

import com.entity.Authorities;

public class AuthoritiesBuilder extends Builder {
    private String username;
    private String authority;

   public AuthoritiesBuilder username(String username){
       this.username=username;
       return this;
   }
   public AuthoritiesBuilder authority(String authority){
       this.authority=authority;
       return this;
   }

    @Override
    public Authorities build() {
        Authorities authorities=new Authorities();
        authorities.setUsername(this.username);
        authorities.setAuthority(this.authority);
        return authorities;
    }
}
