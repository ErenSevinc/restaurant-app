package com.converter;

import com.DTO.AuthoritiesDTO;
import com.DTO.MediaDTO;
import com.entity.Authorities;
import com.entity.Media;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class MediaConverter {
    private static final String JPG_EXTENSION=".jpg";
    private static final String PNG_EXTENSION=".png";
    private static final String BMP_EXTENSION=".bmp";

    private static final String BMP_CONTENT="image/bmp";
    private static final String PNG_CONTENT="image/png";

    @Value("C:/Users/ErenSevinc/Desktop/NoteIt/rest-api/target/media/")
    private String uploadDir;

    public static List<MediaDTO> mediaList(List<Media> list) {
        List<MediaDTO> mediaDTOList = new ArrayList<>();

        for (Media media : list) {

            MediaDTO mediaDTO = new MediaDTO();
            mediaDTO.setId(media.getId());
            mediaDTO.setName(media.getName());
            mediaDTO.setFileContent(media.getFileContent());
            mediaDTOList.add(mediaDTO);
        }
        return mediaDTOList;
    }

    public  Media addFile(MultipartFile file,String imageName) throws IOException {
        Files.createDirectories(Paths.get("C:/Users/ErenSevinc/Desktop/NoteIt/rest-api/target/media/)"));
        String filePath = generateFullFilePath(file);
        Path targetLocation = FileSystems.getDefault().getPath(filePath);
        Files.copy(file.getInputStream(),targetLocation, StandardCopyOption.REPLACE_EXISTING);

        byte[] bytes = file.getBytes();
        Media media=new Media();
        media.setFileContent(bytes);
        media.setName(imageName);

        return  media;
    }

    private String generateUUID(){
        return String.valueOf(java.util.UUID.randomUUID());
    }

    private String generateFullFilePath(MultipartFile file){
        String upload="C:/Users/ErenSevinc/Desktop/NoteIt/rest-api/target/media/";
        String extension=JPG_EXTENSION;
        if (BMP_CONTENT.equals(file.getContentType())){
            extension=BMP_EXTENSION;
        }else if(PNG_CONTENT.equals(file.getContentType())){
            extension=PNG_EXTENSION;
        }
        return upload + generateUUID()+extension;
    }



}
