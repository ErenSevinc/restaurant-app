package com.controller;

import com.DTO.AuthoritiesDTO;
import com.builder.AuthoritiesBuilder;
import com.builder.DTOBuilder.AuthoritiesDTOBuilder;
import com.entity.Authorities;
import com.service.AuthoritiesService;
import liquibase.pro.packaged.A;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class AuthoritiesControllerTest {

    @InjectMocks
    private AuthoritiesController authoritiesController;
    @Mock
    private AuthoritiesService authoritiesService;
    private Authorities auth = new Authorities();
    private AuthoritiesDTO authDTO = new AuthoritiesDTO();
    private List<AuthoritiesDTO> list =new ArrayList<>();

    private AuthoritiesBuilder authoritiesBuilder=new AuthoritiesBuilder();
    private AuthoritiesDTOBuilder authoritiesDTOBuilder=new AuthoritiesDTOBuilder();

    @Before
    public void setUp() throws Exception {
        auth=authoritiesBuilder.authority("ROLE_USER").username("user1").build();

        authDTO=authoritiesDTOBuilder.authority("ROLE_USER").username("user1dto").build();
        list.add(authDTO);
    }

    @Test
    public void shouldAuthoritiesList() {
        List<AuthoritiesDTO> list =authoritiesController.authoritiesList();
        assertNotNull(list);
    }

    @Test
    public void shouldAddAuth(){
        Mockito.when(authoritiesService.addAuth(authDTO)).thenReturn("Auth Added");

        String res = authoritiesController.addAuth(authDTO);

        assertNotNull(res);
        assertEquals(res,"Auth Added");
    }

    @Test
    public void shouldUpdateAuth(){
        Mockito.when(authoritiesService.updateAuth(authDTO)).thenReturn(list);

        String res = authoritiesController.updateAuth(authDTO);

        assertNotNull(res);
        assertEquals(res,"Auth Updated");
    }
    @Test
    public void shouldDeleteAuth(){
        String username ="user1";

        Mockito.when(authoritiesService.deleteAuth(username)).thenReturn("Auth Deleted");

        String res= authoritiesController.deleteAuth(username);

        assertNotNull(res);
        assertEquals(res,"Auth Deleted");
    }




}