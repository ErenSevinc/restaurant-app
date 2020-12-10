package com.service;

import com.DTO.AuthoritiesDTO;
import com.entity.Authorities;
import com.repository.AuthoritiesRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Matchers.any;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AuthoritiesServiceTest {

    @InjectMocks
    private AuthoritiesService authoritiesService;

    @Mock
    private AuthoritiesRepository authoritiesRepository;

    private Authorities auth = new Authorities();
    private AuthoritiesDTO authDTO = new AuthoritiesDTO();

    @Before
    public void setUp() throws Exception {
        auth.setAuthority("ROLE_USER");
        auth.setUsername("user1");

        authDTO.setUsername("user1dto");
        authDTO.setAuthority("ROLE_USER");
    }

    @Test
    public void shouldAddNewAuth() {

        Mockito.when(authoritiesRepository.save(any())).thenReturn(auth);

        String res = authoritiesService.addAuth(authDTO);

        assertNotNull(res);
        assertEquals(res,"Auth Eklendi");
    }

    @Test
    public void shouldDeleteAuth() {
        String username = "user1";

        String res = authoritiesService.deleteAuth(username);

        assertEquals(res,"Auth Silindi");
        verify(authoritiesRepository,times(1)).deleteById(username);
    }


    @Test(expected = RuntimeException.class)
    public void shouldNotDeleteAuthWhenThrownException() {
        String username = "user1";

        doThrow(new RuntimeException("Cant delete here")).when(authoritiesRepository).deleteById(username);

        String res = authoritiesService.deleteAuth(username);
    }
    @Test
    public void shouldListAuth(){
        List<AuthoritiesDTO> list =authoritiesService.authoritiesList();
        assertNotNull(list);
    }

    @Test
    public void shouldUpdateAuth(){
        List<AuthoritiesDTO> list= authoritiesService.updateAuth(authDTO);
        assertNotNull(list);

    }

}