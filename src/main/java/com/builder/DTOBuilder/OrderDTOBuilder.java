package com.builder.DTOBuilder;

import com.DTO.OrderDTO;
import com.builder.Builder;

import java.util.Date;

public class OrderDTOBuilder extends Builder {
    private int id;
    private double totalPrice;
    private int piece;
    private String paymentType;
    private int productId;
    private String tableName;
    private String waiterName;
    private Date date;

    public OrderDTOBuilder id(int id){
        this.id=id;
        return this;
    }
    public OrderDTOBuilder totalPrice(double totalPrice){
        this.totalPrice=totalPrice;
        return this;
    }
    public OrderDTOBuilder piece(int piece){
        this.piece=piece;
        return this;
    }
    public OrderDTOBuilder paymentType(String paymentType){
        this.paymentType=paymentType;
        return this;
    }
    public OrderDTOBuilder productId(int productId){
        this.productId=productId;
        return this;
    }
    public OrderDTOBuilder tableName(String tableName){
        this.tableName=tableName;
        return this;
    }
    public OrderDTOBuilder waiterName(String waiterName){
        this.waiterName=waiterName;
        return this;
    }
    public OrderDTOBuilder date(Date date){
        this.date=date;
        return this;
    }

    @Override
    public OrderDTO build() {
        OrderDTO orderDTO =new OrderDTO();
        orderDTO.setId(this.id);
        orderDTO.setProductId(this.productId);
        orderDTO.setTotalPrice(this.totalPrice);
        orderDTO.setPiece(this.piece);
        orderDTO.setTableName(this.tableName);
        orderDTO.setPaymentType(this.paymentType);
        orderDTO.setWaiterName(this.waiterName);
        orderDTO.setDate(this.date);

        return orderDTO;
    }
}
