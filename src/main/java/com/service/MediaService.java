package com.service;

import com.DTO.MediaDTO;
import com.converter.MediaConverter;
import com.entity.Media;
import com.mapper.MediaMapper;
import com.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

@Service
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    public List<MediaDTO> getFiles(){
//        List<Media> mediaList =mediaRepository.findAll();
//        return MediaConverter.mediaList(mediaList);
        return MediaMapper.INSTANCE.toDTOList(mediaRepository.findAll());
    }

    public String addFile(MultipartFile file,String imageName) throws IOException {
        MediaConverter mediaConverter=new MediaConverter();
        Media media= mediaConverter.addFile(file,imageName);
        mediaRepository.save(media);

        return "File Added";
    }


}
