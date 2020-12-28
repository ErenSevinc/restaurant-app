package com.service;

import static org.junit.jupiter.api.Assertions.*;

import com.DTO.WaiterDTO;
import com.builder.DTOBuilder.WaiterDTOBuilder;
import com.builder.WaiterBuilder;
import com.converter.WaiterConverter;
import com.entity.Waiter;
import com.mapper.WaiterMapper;
import com.repository.WaiterRepository;
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
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class WaiterServiceTest {
    @InjectMocks
    private WaiterService waiterService;

    @Mock
    private WaiterRepository waiterRepository;
    private Waiter waiter = new Waiter();
    private WaiterDTO waiterDTO = new WaiterDTO();

    private WaiterBuilder waiterBuilder=new WaiterBuilder();
    private WaiterDTOBuilder waiterDTOBuilder=new WaiterDTOBuilder();

    private List<Waiter> waiterList = new ArrayList<>();
    private List<WaiterDTO> waiterDTOList =new ArrayList<>();

    @Before
    public void setUp(){
//        waiter.setId(1);
//        waiter.setName("eren");
//        waiter.setPhoneNumber("51111111");
//        waiter.setMail("asd@asd.com");
//        waiter.setAddress("ev");
//        waiter.setUrlToImage("");
//        waiter.setSalary(2500);
//        waiterList.add(waiter);
//
        waiter=waiterBuilder.id(1).name("eren").phoneNumber("51111111").mail("asd@asd.com").address("ev").urlToImage("").salary(2500).build();
        waiterList.add(waiterBuilder.build());

//        waiterDTO.setId(1);
//        waiterDTO.setName("erenDTO");
//        waiterDTO.setPhoneNumber("51111111");
//        waiterDTO.setMail("asd@asd.com");
//        waiterDTO.setAddress("ev");
//        waiterDTO.setUrlToImage("");
//        waiterDTO.setSalary(2500);
        waiterDTO=waiterDTOBuilder.id(1).name("erenDTO").phoneNumber("51111111").mail("asd@asd.com").address("ev").urlToImage("").salary(2500).build();
        waiterDTOList.add(waiterDTOBuilder.build());
    }

    @Test
    public void shouldAllWaiter(){
        Mockito.when(waiterRepository.findAll()).thenReturn(waiterList);
        List<WaiterDTO> dtoList= WaiterMapper.INSTANCE.toDTOList(waiterList); //WaiterConverter.getAllWaiter(waiterList);
        List<WaiterDTO> res =waiterService.getAllWaiter();
        assertEquals(res.get(0).getId(),dtoList.get(0).getId());

//        List<Waiter> list =waiterRepository.findAll();
//        assertNotNull(list);
    }

    @Test
    public void shouldGetWaiterById(){
        int id=1;

//        Mockito.when(WaiterMapper.INSTANCE.toDTO(waiterRepository.findById(id).get())).thenReturn(waiterDTO);
//        WaiterDTO res = waiterService.getWaiterById(id);
//        WaiterDTO dto = WaiterMapper.INSTANCE.toDTO(waiter);//WaiterConverter.getWaiterById(waiter);
//
//        assertEquals(res.getId(),dto.getId());
        Mockito.when(waiterRepository.findAll().stream().filter(t -> t.getId() == id).findFirst()).thenReturn(Optional.of(WaiterMapper.INSTANCE.toEntity(waiterDTO)));
        WaiterDTO res= waiterService.getWaiterById(id);
        assertNotNull(res);
        assertEquals(res.getId(),waiterDTO.getId());
    }


    @Test
    public void shouldAddWaiter(){
        Mockito.when(waiterRepository.save(any())).thenReturn(waiter);

        String res= waiterService.addWaiter(waiterDTO);

        assertNotNull(res);
        assertEquals(res,"Waiter Added");
    }

    @Test
    public void shouldUpdateWaiter(){
        Mockito.when(waiterRepository.saveAndFlush(any())).thenReturn(waiter);

        WaiterDTO res =waiterService.updateWaiter(waiterDTO);

        assertEquals(res.getId(),waiterDTO.getId());
    }

    @Test
    public void shouldDeleteWaiter(){
        int id=1;

        List<WaiterDTO> res =waiterService.deleteWaiter(id);

        verify(waiterRepository,times(1)).deleteById(id);
    }


}