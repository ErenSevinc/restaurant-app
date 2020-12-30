package com.mapper;

import com.DTO.MediaDTO;
import com.DTO.WaiterDTO;
import com.entity.Media;
import com.entity.Waiter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-30T01:18:11+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class WaiterMapperImpl implements WaiterMapper {

    @Override
    public List<WaiterDTO> toDTOList(List<Waiter> waiterList) {
        if ( waiterList == null ) {
            return null;
        }

        List<WaiterDTO> list = new ArrayList<WaiterDTO>( waiterList.size() );
        for ( Waiter waiter : waiterList ) {
            list.add( toDTO( waiter ) );
        }

        return list;
    }

    @Override
    public WaiterDTO toDTO(Waiter waiter) {
        if ( waiter == null ) {
            return null;
        }

        WaiterDTO waiterDTO = new WaiterDTO();

        waiterDTO.setMediaDTO( mediaToMediaDTO( waiter.getMedia() ) );
        waiterDTO.setId( waiter.getId() );
        waiterDTO.setName( waiter.getName() );
        waiterDTO.setPhoneNumber( waiter.getPhoneNumber() );
        waiterDTO.setMail( waiter.getMail() );
        waiterDTO.setAddress( waiter.getAddress() );
        waiterDTO.setUrlToImage( waiter.getUrlToImage() );
        waiterDTO.setSalary( waiter.getSalary() );

        return waiterDTO;
    }

    @Override
    public Waiter toEntity(WaiterDTO waiterDTO) {
        if ( waiterDTO == null ) {
            return null;
        }

        Waiter waiter = new Waiter();

        waiter.setMedia( mediaDTOToMedia( waiterDTO.getMediaDTO() ) );
        waiter.setId( waiterDTO.getId() );
        waiter.setName( waiterDTO.getName() );
        waiter.setPhoneNumber( waiterDTO.getPhoneNumber() );
        waiter.setMail( waiterDTO.getMail() );
        waiter.setAddress( waiterDTO.getAddress() );
        waiter.setUrlToImage( waiterDTO.getUrlToImage() );
        waiter.setSalary( waiterDTO.getSalary() );

        return waiter;
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
