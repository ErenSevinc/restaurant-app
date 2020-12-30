package com.service;

import static org.junit.jupiter.api.Assertions.*;

import com.DTO.MediaDTO;
import com.DTO.WaiterDTO;
import com.builder.DTOBuilder.MediaDTOBuilder;
import com.builder.DTOBuilder.WaiterDTOBuilder;
import com.builder.MediaBuilder;
import com.builder.WaiterBuilder;
import com.converter.WaiterConverter;
import com.entity.Media;
import com.entity.Waiter;
import com.exception.BusinessRuleException;
import com.mapper.WaiterMapper;
import com.repository.WaiterRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;

import java.nio.charset.StandardCharsets;
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

    private Media media=new Media();
    private MediaDTO mediaDTO=new MediaDTO();

    private MediaBuilder mediaBuilder=new MediaBuilder();
    private MediaDTOBuilder mediaDTOBuilder=new MediaDTOBuilder();
    byte [] b ={ (byte)0xe0, 0x4f, (byte)0xd0,
            0x20, (byte)0xea, 0x3a, 0x69, 0x10, (byte)0xa2, (byte)0xd8, 0x08, 0x00, 0x2b,
            0x30, 0x30, (byte)0x9d };

    private List<Media> list =new ArrayList<>();
    byte[] json = "{\"name\":\"yeeeah\"}".getBytes(StandardCharsets.UTF_8);
    MockMultipartFile file = new MockMultipartFile
            ("json", "json", "application/json", json);

    @Before
    public void setUp(){
        media=mediaBuilder.id(1).name("resim").fileContext(b).build();
        mediaDTO=mediaDTOBuilder.id(1).name("resim").fileContent(b).build();
        waiter=waiterBuilder.id(1).name("eren").phoneNumber("51111111").mail("asd@asd.com").address("ev").urlToImage("").salary(2500).media(media).build();
        waiterList.add(waiterBuilder.build());

        waiterDTO=waiterDTOBuilder.id(1).name("erenDTO").phoneNumber("51111111").mail("asd@asd.com").address("ev").urlToImage("").salary(2500).media(mediaDTO).build();
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

        Mockito.when(waiterRepository.findById(id)).thenReturn(Optional.of(WaiterMapper.INSTANCE.toEntity(waiterDTO)));
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
        Mockito.when(waiterRepository.findById(waiterDTO.getId())).thenReturn(Optional.of(WaiterMapper.INSTANCE.toEntity(waiterDTO)));

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