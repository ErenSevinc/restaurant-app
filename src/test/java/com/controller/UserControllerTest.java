package com.controller;

import com.DTO.RoleDTO;
import com.DTO.UsersDTO;
import com.builder.DTOBuilder.UserDTOBuilder;
import com.builder.UserBuilder;
import com.configuration.LocaleConfig;
import com.entity.Role;
import com.entity.User;
import com.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private UsersDTO usersDTO;
    private User user;
    private RoleDTO roleDTO;
    private Role role;

    private List<UsersDTO> usersDTOList=new ArrayList<>();

    private UserBuilder userBuilder=new UserBuilder();
    private UserDTOBuilder userDTOBuilder=new UserDTOBuilder();

    @Before
    public void setUp(){
        user=userBuilder.id(1).email("asd@asd.com").username("admin").password("123").enabled(true).build();
        usersDTO=userDTOBuilder.id(1).email("asd@asd.com").username("admin").password("123").enabled(true).build();
        usersDTOList.add(usersDTO);

    }

    @Test
    public void shouldListUsers(){
        Mockito.when(userService.listUsers(usersDTOList)).thenReturn(usersDTOList);

        List<UsersDTO> res=userController.listUsers();

        assertNotNull(res);
    }
    @Test
    public void shouldAddUser(){
        Mockito.when(userService.addUser(usersDTO)).thenReturn(usersDTO);

        UsersDTO res=userController.addUser(usersDTO);

        assertEquals(res.getId(),usersDTO.getId());
    }

    @Test
    public void shouldDeleteUser(){
        int id=1;
        Mockito.when(userService.deleteUser(id)).thenReturn("user deleted");

        String res=userController.deleteUser(id);

        assertEquals(res,"user deleted");


    }


}