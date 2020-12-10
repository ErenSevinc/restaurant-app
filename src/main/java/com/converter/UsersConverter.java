package com.converter;

import com.DTO.UsersDTO;
import com.entity.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersConverter {
//    public static List<UsersDTO> listUsers(List<Users> usersList){
//
//        List<UsersDTO> usersDTOList=new ArrayList<>();
//        for(Users usr:usersList){
//        UsersDTO usrDTO=new UsersDTO();
//            usrDTO.setUsername(usr.getUsername());
//            usrDTO.setEnabled(usr.getEnabled());
//            usr.setPassword(usr.getPassword());
//            usersDTOList.add(usrDTO);
//        }
//        return usersDTOList;
//    }
    public static UsersDTO listUsersByUserName(Optional<Users> list){

        UsersDTO usersDTO=new UsersDTO();

        usersDTO.setUsername(list.get().getUsername());
        usersDTO.setEnabled(list.get().getEnabled());
        usersDTO.setPassword(list.get().getPassword());

        return usersDTO;
    }
    public static  Users addUsers(UsersDTO usersDTO){

        Users users=new Users();

        users.setUsername(usersDTO.getUsername());
        users.setEnabled(usersDTO.getEnabled());
        users.setPassword(usersDTO.getPassword());

       return users;
    }

    public static Users updateUsers (UsersDTO usersDto){

        Users users=new Users();

        users.setUsername(usersDto.getUsername());
        users.setEnabled(usersDto.getEnabled());
        users.setPassword(usersDto.getPassword());

        return users;
    }

}
