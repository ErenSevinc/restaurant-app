package com.service;

import static org.junit.jupiter.api.Assertions.*;

import com.DTO.MediaDTO;
import com.DTO.WaiterDTO;
import com.builder.DTOBuilder.MediaDTOBuilder;
import com.builder.MediaBuilder;
import com.converter.MediaConverter;
import com.converter.WaiterConverter;
import com.entity.Media;
import com.mapper.MediaMapper;
import com.repository.MediaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class MediaServiceTest {
    @InjectMocks
    private  MediaService mediaService;

    @Mock
    private MediaRepository mediaRepository;
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

    }

    @Test
    public void shouldListMedia(){
        List<Media> list =new ArrayList<>();
        list.add(media);

        Mockito.when(mediaRepository.findAll()).thenReturn(list);

        List<MediaDTO> dtoList = MediaMapper.INSTANCE.toDTOList(list);
        List<MediaDTO> res= mediaService.getFiles();

        assertEquals(dtoList.get(0).getId(),res.get(0).getId());
        assertNotNull(res);

    }
    @Test
    public void shouldAddMedia() throws IOException {

        Mockito.when(mediaRepository.save(any())).thenReturn(media);
        String res= mediaService.addFile(file,"resim");
        assertEquals(res,"File Added");
    }



}