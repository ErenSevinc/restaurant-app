package com.controller;

import com.DTO.WaiterDTO;
import com.builder.DTOBuilder.WaiterDTOBuilder;
import com.builder.WaiterBuilder;
import com.entity.Waiter;
import com.service.WaiterService;
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
public class WaiterControllerTest {
    @InjectMocks
    private WaiterController waiterController;

    @Mock
    private WaiterService waiterService;

    private Waiter waiter = new Waiter();
    private WaiterDTO waiterDTO = new WaiterDTO();
    private List<WaiterDTO> waiterDTOList = new ArrayList();
    private List<Waiter> waiterList = new ArrayList();

    private WaiterBuilder waiterBuilder=new WaiterBuilder();
    private WaiterDTOBuilder waiterDTOBuilder= new WaiterDTOBuilder();

    @Before
    public void setUp() throws Exception{
        waiter=waiterBuilder.id(1).name("garson1").phoneNumber("+90 5111111111").mail("asdasd@asd.com")
                .address("ev").urlToImage("").salary(2500).build();
        waiterList.add(waiter);

        waiterDTO=waiterDTOBuilder.id(1).name("garson1DTO").phoneNumber("+90 5111111111").mail("asdasd@asd.com")
                .address("ev").urlToImage("").salary(2500).build();
        waiterDTOList.add(waiterDTO);
    }
    @Test
    public void shouldGetAllWaiter(){
        List<WaiterDTO> list = waiterController.getAllWaiter();
        assertNotNull(list);
    }
    @Test
    public void shouldGetWaiterById(){
        int id =1;
        Optional<Waiter> list=Optional.of(waiter);
        Mockito.when(waiterService.getWaiterById(id)).thenReturn(waiterDTO);
        WaiterDTO result = waiterController.getWaiterById(id);
        assertEquals(result.getId(),id);
        assertNotNull(result);
    }
    @Test
    public void shouldAddWaiter(){
        Mockito.when(waiterService.addWaiter(waiterDTO)).thenReturn("Waiter Added");

        String res = waiterController.addWaiter(waiterDTO);

        assertNotNull(res);
        assertEquals(res,"Waiter Added");
    }
    @Test
    public void shouldUpdateWaiter(){
       Mockito.when(waiterService.updateWaiter(waiterDTO)).thenReturn(waiterDTO);
       WaiterDTO res =waiterController.updateWaiter(waiterDTO);

       assertNotNull(res);
       assertEquals(res,waiterDTO);
    }
    @Test
    public void shouldDeleteWaiter(){
        int id=1;

        List<WaiterDTO> res =waiterController.deleteWaiter(id);

        assertNotNull(res);

    }
}