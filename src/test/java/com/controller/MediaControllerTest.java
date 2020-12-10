package com.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.DTO.MediaDTO;
import com.builder.DTOBuilder.MediaDTOBuilder;
import com.builder.MediaBuilder;
import com.entity.Media;
import com.service.MediaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class MediaControllerTest {
    @InjectMocks
    private MediaController mediaController;

    @Mock
    private MediaService mediaService;

    private Media media=new Media();
    private MediaDTO mediaDTO=new MediaDTO();

    private List<MediaDTO> mediaDTOList=new ArrayList<>();

    private MediaBuilder mediaBuilder=new MediaBuilder();
    private MediaDTOBuilder mediaDTOBuilder=new MediaDTOBuilder();
    byte [] b ={ (byte)0xe0, 0x4f, (byte)0xd0,
            0x20, (byte)0xea, 0x3a, 0x69, 0x10, (byte)0xa2, (byte)0xd8, 0x08, 0x00, 0x2b,
            0x30, 0x30, (byte)0x9d };

    @Before
    public void setUp(){
        media=mediaBuilder.id(1).name("resim").fileContext(b).build();
        mediaDTO=mediaDTOBuilder.id(1).name("resim").fileContent(b).build();
    }

    @Test
    public void shouldGetFilesControllerTest(){
        mediaDTOList.add(mediaDTO);

        Mockito.when(mediaService.getFiles()).thenReturn(mediaDTOList);
        List<MediaDTO> res= mediaController.getFiles();
        assertEquals(res,mediaDTOList);
    }
    @Test
    public void shouldAddFileControllerTest() throws IOException {
        MultipartFile file=new MultipartFile() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getOriginalFilename() {
                return null;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public long getSize() {
                return 0;
            }

            @Override
            public byte[] getBytes() throws IOException {
                return new byte[0];
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return null;
            }

            @Override
            public void transferTo(File dest) throws IOException, IllegalStateException {

            }
        };
        Mockito.when(mediaService.addFile(file,"resim")).thenReturn("File Added");
        String res =mediaController.addFile(file,"resim");

        assertNotNull(res);
        assertEquals(res,"File Added");
    }
}