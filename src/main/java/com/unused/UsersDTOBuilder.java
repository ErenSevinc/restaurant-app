//package com.builder.DTOBuilder;
//
//import com.DTO.UsersDTO;
//import com.builder.Builder;
//
//public class UsersDTOBuilder extends Builder {
//    private String username;
//    private String password;
//    private boolean enabled;
//
//    public UsersDTOBuilder username(String username){
//        this.username=username;
//        return this;
//    }
//    public UsersDTOBuilder password(String password){
//        this.password=password;
//        return this;
//    }
//    public UsersDTOBuilder enabled(boolean enabled){
//        this.enabled=enabled;
//        return this;
//    }
//
//    @Override
//    public UsersDTO build() {
//        UsersDTO usersDTO=new UsersDTO();
//        usersDTO.setUsername(this.username);
//        usersDTO.setPassword(this.password);
//        usersDTO.setEnabled(this.enabled);
//        return usersDTO;
//    }
//}
