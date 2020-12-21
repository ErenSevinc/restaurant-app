package com.converter;

import com.DTO.RoleDTO;
import com.entity.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleDTOConverter {

    public static Role roleDTOConvertToRole(RoleDTO dto){
        Role role=new Role();
        role.setId(dto.getId());
        role.setName(dto.getName());
        return role;
    }

    public static RoleDTO roleConvertToRoleDTO(Role role){
        RoleDTO roleDTO=new RoleDTO();

        roleDTO.setId(roleDTO.getId());
        roleDTO.setName(roleDTO.getName());

        return roleDTO;
    }

    public static List<Role> roleDTOListConvertToroleList(List<RoleDTO> roleDTOList){
        List<Role> list=new ArrayList<>();
        for (int i=0;i<roleDTOList.size();i++){
            Role role=new Role();
            role.setId(roleDTOList.get(i).getId());
            role.setName(roleDTOList.get(i).getName());
            list.add(role);
        }
        return list;
    }
    public static List<RoleDTO> roleListConvertToRoleDTOList(List<Role> roleList){
        List<RoleDTO> roleDTOList = new ArrayList<>();
        for (int i=0;i<roleList.size();i++){
            RoleDTO roleDTO=new RoleDTO();
            roleDTO.setId(roleList.get(i).getId());
            roleDTO.setName(roleList.get(i).getName());
            roleDTOList.add(roleDTO);
        }
        return roleDTOList;
    }
}
