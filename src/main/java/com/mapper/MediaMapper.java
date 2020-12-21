package com.mapper;

import com.DTO.MediaDTO;
import com.entity.Media;
import liquibase.pro.packaged.L;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MediaMapper {

    MediaMapper INSTANCE= Mappers.getMapper(MediaMapper.class);
    List<MediaDTO> toDTOList(List<Media> mediaList);

    MediaDTO toDTO(Media media);

    Media toEntity(MediaDTO mediaDTO);


}
