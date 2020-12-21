package com.builder.DTOBuilder;

import com.DTO.RoleDTO;
import com.builder.Builder;

public class RoleDTOBuilder extends Builder {
    private int id;
    private String name;

    public RoleDTOBuilder id(int id){
        this.id=id;
        return this;
    }
    public RoleDTOBuilder name(String name){
        this.name=name;
        return this;
    }

    @Override
    public RoleDTO build() {
        RoleDTO roleDTO=new RoleDTO();
        roleDTO.setId(this.id);
        roleDTO.setName(this.name);
        return roleDTO;
    }
}

