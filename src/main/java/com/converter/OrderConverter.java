package com.converter;

import com.DTO.OrderDTO;
import com.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderConverter {
    public static List<OrderDTO> listSales(List<Order> orderList){

        List<OrderDTO> orderListDTO = new ArrayList<>();

        for (Order ord:orderList){
            OrderDTO orderDTO = new OrderDTO();

            orderDTO.setId(ord.getId());
            orderDTO.setTotalPrice(ord.getTotalPrice());
            orderDTO.setPiece(ord.getPiece());
            orderDTO.setPaymentType(ord.getPaymentType());
            orderDTO.setProductId(ord.getProductId());
            orderDTO.setDate(ord.getDate());
            orderDTO.setTableName(ord.getTableName());
            orderDTO.setWaiterName(ord.getWaiterName());

            orderListDTO.add(orderDTO);
        }
        return orderListDTO;
    }
    public static List<Order> addSales(List<OrderDTO> orderDTO){

        List<Order> list=new ArrayList<>();

        for(int i=0; i<orderDTO.size(); i++){
            Order order = new Order();

            order.setId(orderDTO.get(i).getId());
            order.setTotalPrice(orderDTO.get(i).getTotalPrice());
            order.setPiece(orderDTO.get(i).getPiece());
            order.setPaymentType(orderDTO.get(i).getPaymentType());
            order.setProductId(orderDTO.get(i).getProductId());
            order.setTableName(orderDTO.get(i).getTableName());
            order.setWaiterName(orderDTO.get(i).getWaiterName());
            order.setDate(orderDTO.get(i).getDate());
            list.add(order);
        }
        return list ;
    }

}
