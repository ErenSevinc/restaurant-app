package com.DTO;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class UsersDTO {

    private int id;
    private String email;
    private String username;
    private String password;
    private boolean enabled;
    private List<RoleDTO> rolesDTO=new ArrayList<>();

}
