package com.builder;

import com.entity.Order;

import java.sql.Timestamp;
import java.util.Date;

public class OrderBuilder extends Builder {
    private int id;
    private double totalPrice;
    private int piece;
    private String paymentType;
    private int productId;
    private String tableName;
    private String waiterName;
    private Date date;

    public OrderBuilder id(int id){
        this.id=id;
        return this;
    }
    public OrderBuilder totalPrice(double totalPrice){
        this.totalPrice=totalPrice;
        return this;
    }
    public OrderBuilder piece(int piece){
        this.piece=piece;
        return this;
    }
    public OrderBuilder paymentType(String paymentType){
        this.paymentType=paymentType;
        return this;
    }
    public OrderBuilder productId(int productId){
        this.productId=productId;
        return this;
    }
    public OrderBuilder tableName(String tableName){
        this.tableName=tableName;
        return this;
    }
    public OrderBuilder waiterName(String waiterName){
        this.waiterName=waiterName;
        return this;
    }
    public OrderBuilder date(Date date){
        this.date=date;
        return this;
    }

    @Override
    public Order build() {
        Order order =new Order();
        order.setId(this.id);
        order.setProductId(this.productId);
        order.setTotalPrice(this.totalPrice);
        order.setPiece(this.piece);
        order.setTableName(this.tableName);
        order.setPaymentType(this.paymentType);
        order.setWaiterName(this.waiterName);
        order.setDate(this.date);

        return order;
    }
}
