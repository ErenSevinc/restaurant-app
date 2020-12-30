package com.controller;

import static org.junit.Assert.*;
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
public class HelloControllerTest {
    @InjectMocks
    private HelloController helloController;

    @Test
    public void shouldSayHello(){
        String res=helloController.sayHelloUser();

        assertEquals(res,"hi User");
    }
    @Test
    public void shouldSayHelloAdmin(){
        String res=helloController.sayHelloAdmin();

        assertEquals(res,"hi Admin");
    }


}