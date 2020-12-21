package com.DTO;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;

@Data
@ToString
public class OrderDTO {
    private int id;
    private double totalPrice;
    private int piece;
    private String paymentType;
    private int productId;
    private String tableName;
    private String waiterName;
    private Date date= new Timestamp(System.currentTimeMillis());

}
