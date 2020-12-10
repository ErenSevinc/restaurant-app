package com.service;

import com.DTO.UsersDTO;
import com.builder.DTOBuilder.UsersDTOBuilder;
import com.builder.UsersBuilder;
import com.entity.Users;
import com.repository.UsersRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class UsersServiceTest {
    @InjectMocks
    private UsersService usersService;

    @Mock
    private UsersRepository usersRepository;

    private Users users=new Users();
    private UsersDTO usersDTO=new UsersDTO();

    private UsersBuilder usersBuilder=new UsersBuilder();
    private UsersDTOBuilder usersDTOBuilder=new UsersDTOBuilder();

    @Before
    public void setUp() throws Exception {
//        users.setUsername("eren");
//        users.setPassword("123");
//        users.setEnabled(true);

        users=usersBuilder.username("admin").password("{noop}pass3").enabled(true).build();
        usersDTO=usersDTOBuilder.username("adminDTO").password("pass3").enabled(true).build();

//        usersDTO.setUsername("erenDTO");
//        usersDTO.setPassword("123123");
//        usersDTO.setEnabled(true);
    }

    @Test
    public void shouldAddNewUsers(){
        Mockito.when(usersRepository.save(any())).thenReturn(users);

        String res = usersService.addUsers(usersDTO);

        assertNotNull(res);
        assertEquals(res,"Users Added");

    }
    @Test
    public void shouldDeleteUsers(){
        String username=users.getUsername();

        String res = usersService.deleteUsers(username);

        assertEquals(res,"Users Deleted");
        verify(usersRepository,times(1)).deleteById(username);
    }

    @Test
    public void shouldListUsers(){
        List<UsersDTO> list =usersService.listUsers();
        assertNotNull(list);
    }

    @Test
    public void shouldListUsersByUserName(){
        String username ="admin";
        Optional<Users> list=Optional.of(users);
        Mockito.when(usersRepository.findById(username)).thenReturn(list);
        UsersDTO result=usersService.listUsersByUserName(username);
        assertEquals(result.getUsername(),username);
        assertNotNull(result);
    }

    @Test
    public void shouldUpdateUsers(){
        List<UsersDTO> list = usersService.updateUsers(usersDTO);
        assertNotNull(list);
    }

}