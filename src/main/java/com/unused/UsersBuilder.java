//package com.builder;
//
//import com.entity.Users;
//
//public class UsersBuilder extends Builder {
//    private String username;
//    private String password;
//    private boolean enabled;
//
//    public UsersBuilder username(String username){
//        this.username=username;
//        return this;
//    }
//    public UsersBuilder password(String password){
//        this.password=password;
//        return this;
//    }
//    public UsersBuilder enabled(boolean enabled){
//        this.enabled=enabled;
//        return this;
//    }
//
//    @Override
//    public Users build() {
//        Users users=new Users();
//        users.setUsername(this.username);
//        users.setPassword(this.password);
//        users.setEnabled(this.enabled);
//        return users;
//    }
//}
