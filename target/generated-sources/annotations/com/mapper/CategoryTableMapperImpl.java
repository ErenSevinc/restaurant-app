package com.mapper;

import com.DTO.CategoryTableDTO;
import com.DTO.MediaDTO;
import com.entity.CategoryTable;
import com.entity.Media;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-30T14:49:53+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class CategoryTableMapperImpl implements CategoryTableMapper {

    @Override
    public List<CategoryTableDTO> toDTOList(List<CategoryTable> categoryTableList) {
        if ( categoryTableList == null ) {
            return null;
        }

        List<CategoryTableDTO> list = new ArrayList<CategoryTableDTO>( categoryTableList.size() );
        for ( CategoryTable categoryTable : categoryTableList ) {
            list.add( toDTO( categoryTable ) );
        }

        return list;
    }

    @Override
    public CategoryTableDTO toDTO(CategoryTable categoryTable) {
        if ( categoryTable == null ) {
            return null;
        }

        CategoryTableDTO categoryTableDTO = new CategoryTableDTO();

        categoryTableDTO.setMediaDTO( mediaToMediaDTO( categoryTable.getMedia() ) );
        categoryTableDTO.setId( categoryTable.getId() );
        categoryTableDTO.setName( categoryTable.getName() );
        categoryTableDTO.setAmount( categoryTable.getAmount() );

        return categoryTableDTO;
    }

    @Override
    public CategoryTable toEntity(CategoryTableDTO categoryTableDTO) {
        if ( categoryTableDTO == null ) {
            return null;
        }

        CategoryTable categoryTable = new CategoryTable();

        categoryTable.setMedia( mediaDTOToMedia( categoryTableDTO.getMediaDTO() ) );
        categoryTable.setId( categoryTableDTO.getId() );
        categoryTable.setName( categoryTableDTO.getName() );
        categoryTable.setAmount( categoryTableDTO.getAmount() );

        return categoryTable;
    }

    protected MediaDTO mediaToMediaDTO(Media media) {
        if ( media == null ) {
            return null;
        }

        MediaDTO mediaDTO = new MediaDTO();

        mediaDTO.setId( media.getId() );
        mediaDTO.setName( media.getName() );
        byte[] fileContent = media.getFileContent();
        if ( fileContent != null ) {
            mediaDTO.setFileContent( Arrays.copyOf( fileContent, fileContent.length ) );
        }

        return mediaDTO;
    }

    protected Media mediaDTOToMedia(MediaDTO mediaDTO) {
        if ( mediaDTO == null ) {
            return null;
        }

        Media media = new Media();

        media.setId( mediaDTO.getId() );
        media.setName( mediaDTO.getName() );
        byte[] fileContent = mediaDTO.getFileContent();
        if ( fileContent != null ) {
            media.setFileContent( Arrays.copyOf( fileContent, fileContent.length ) );
        }

        return media;
    }
}
