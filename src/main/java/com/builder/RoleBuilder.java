package com.builder;

import com.entity.Role;

public class RoleBuilder extends Builder {
    private int id;
    private String name;

   public RoleBuilder id(int id){
       this.id=id;
       return this;
   }
   public RoleBuilder name(String name){
       this.name=name;
       return this;
   }

    @Override
    public Role build() {
        Role role=new Role();

        role.setId(this.id);
        role.setName(this.name);

        return role;
    }
}
