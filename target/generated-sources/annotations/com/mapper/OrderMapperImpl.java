package com.mapper;

import com.DTO.OrderDTO;
import com.entity.Order;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-21T15:46:33+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public List<OrderDTO> toDTO(List<Order> orderList) {
        if ( orderList == null ) {
            return null;
        }

        List<OrderDTO> list = new ArrayList<OrderDTO>( orderList.size() );
        for ( Order order : orderList ) {
            list.add( orderToOrderDTO( order ) );
        }

        return list;
    }

    @Override
    public List<Order> toEntity(List<OrderDTO> orderDTOList) {
        if ( orderDTOList == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( orderDTOList.size() );
        for ( OrderDTO orderDTO : orderDTOList ) {
            list.add( orderDTOToOrder( orderDTO ) );
        }

        return list;
    }

    protected OrderDTO orderToOrderDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId( order.getId() );
        orderDTO.setTotalPrice( order.getTotalPrice() );
        orderDTO.setPiece( order.getPiece() );
        orderDTO.setPaymentType( order.getPaymentType() );
        orderDTO.setProductId( order.getProductId() );
        orderDTO.setTableName( order.getTableName() );
        orderDTO.setWaiterName( order.getWaiterName() );
        orderDTO.setDate( order.getDate() );

        return orderDTO;
    }

    protected Order orderDTOToOrder(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderDTO.getId() );
        order.setTotalPrice( orderDTO.getTotalPrice() );
        order.setPiece( orderDTO.getPiece() );
        order.setPaymentType( orderDTO.getPaymentType() );
        order.setProductId( orderDTO.getProductId() );
        order.setTableName( orderDTO.getTableName() );
        order.setWaiterName( orderDTO.getWaiterName() );
        order.setDate( orderDTO.getDate() );

        return order;
    }
}
