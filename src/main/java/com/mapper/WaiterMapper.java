package com.mapper;

import com.DTO.WaiterDTO;
import com.entity.Waiter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface WaiterMapper {

    WaiterMapper INSTANCE= Mappers.getMapper(WaiterMapper.class);

    List<WaiterDTO> toDTOList(List<Waiter> waiterList);

    @Mapping(source = "media",target = "mediaDTO")
    WaiterDTO toDTO(Waiter waiter);

    @Mapping(source = "mediaDTO",target = "media")
    Waiter toEntity(WaiterDTO waiterDTO);


}
