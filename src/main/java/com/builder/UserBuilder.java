package com.builder;

import com.entity.Role;
import com.entity.User;

import java.util.List;

public class UserBuilder extends Builder {
    private int id;
    private String email;
    private String username;
    private String password;
    private boolean enabled;
    private List<Role> roles;

    public UserBuilder id(int id){
        this.id=id;
        return this;
    }
    public UserBuilder email(String email){
        this.email=email;
        return this;
    }
    public UserBuilder username(String username){
        this.username=username;
        return this;
    }
    public UserBuilder password(String password){
        this.password=password;
        return this;
    }
    public UserBuilder enabled(boolean enabled){
        this.enabled=enabled;
        return this;
    }
    public UserBuilder roles(List<Role> roles){
        this.roles=roles;
        return this;
    }

    @Override
    public User build() {
        User user=new User();

        user.setId(this.id);
        user.setEmail(this.email);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setEnabled(this.enabled);
        user.setRoles(this.roles);

        return user;
    }
}
