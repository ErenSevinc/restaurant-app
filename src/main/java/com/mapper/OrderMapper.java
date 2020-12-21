package com.mapper;

import com.DTO.OrderDTO;
import com.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    List<OrderDTO> toDTO(List<Order> orderList);
    List<Order> toEntity(List<OrderDTO> orderDTOList);

}
