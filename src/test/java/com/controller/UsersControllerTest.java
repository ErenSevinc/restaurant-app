package com.controller;

import com.DTO.UsersDTO;
import com.builder.DTOBuilder.UsersDTOBuilder;
import com.builder.UsersBuilder;
import com.entity.Users;
import com.service.UsersService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class UsersControllerTest {
    @InjectMocks
    private UsersController usersController;

    @Mock
    private UsersService usersService;
    private Users users=new Users();
    private UsersDTO usersDTO=new UsersDTO();
    private UsersBuilder usersBuilder=new UsersBuilder();
    private UsersDTOBuilder usersDTOBuilder=new UsersDTOBuilder();

    @Before
    public void setUp() throws Exception {
        users=usersBuilder.username("eren").password("123").enabled(true).build();
        usersDTO=usersDTOBuilder.username("erenDTO").password("123123").enabled(true).build();
    }

    @Test
    public void shouldListUsers(){
        List<UsersDTO> list = usersController.listUsers();
        assertNotNull(list);
    }
    @Test
    public void shouldAddNewUsers(){
        Mockito.when(usersService.addUsers(usersDTO)).thenReturn("Users Added");

        String res = usersController.addUsers(usersDTO);

        assertNotNull(res);
        assertEquals(res,"Users Added");
    }
    @Test
    public void shouldListUsersByUserName(){
        String username ="erenDTO";
        Optional<Users> list=Optional.of(users);
        Mockito.when(usersService.listUsersByUserName(username)).thenReturn(usersDTO);
        UsersDTO result=usersController.listUsersByUserName(username);
        assertEquals(result.getUsername(),username);
        assertNotNull(result);
    }
    @Test
    public void shouldUpdateUsers(){
        List<UsersDTO> list = usersController.updateUsers(usersDTO);
        assertNotNull(list);
    }
    @Test
    public void shouldDeleteUsers(){
        String username="user1";

        String res = usersController.deleteUsers(username);

        assertEquals(res,"Users Deleted");
        verify(usersService,times(1)).deleteUsers(username);
    }


}