package com.builder.DTOBuilder;

import com.DTO.RoleDTO;
import com.DTO.UsersDTO;
import com.builder.Builder;

import java.util.List;

public class UserDTOBuilder extends Builder {
    private int id;
    private String email;
    private String username;
    private String password;
    private boolean enabled;
    private List<RoleDTO> rolesDTO;

    public UserDTOBuilder id(int id){
        this.id=id;
        return this;
    }
    public UserDTOBuilder email(String email){
        this.email=email;
        return this;
    }
    public UserDTOBuilder username(String username){
        this.username=username;
        return this;
    }
    public UserDTOBuilder password(String password){
        this.password=password;
        return this;
    }
    public UserDTOBuilder enabled(boolean enabled){
        this.enabled=enabled;
        return this;
    }
    public UserDTOBuilder rolesDTO(List<RoleDTO> rolesDTO){
        this.rolesDTO=rolesDTO;
        return this;
    }

    @Override
    public UsersDTO build() {
        UsersDTO usersDTO=new UsersDTO();

        usersDTO.setId(this.id);
        usersDTO.setUsername(this.username);
        usersDTO.setEmail(this.email);
        usersDTO.setPassword(this.password);
        usersDTO.setEnabled(this.enabled);
        usersDTO.setRolesDTO(this.rolesDTO);

        return usersDTO;
    }
}
