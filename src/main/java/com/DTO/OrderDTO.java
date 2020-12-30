package com.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@ToString
public class OrderDTO {
    private int id;
    @NotNull
    private double totalPrice;
    @NotNull
    private int piece;
    @NotNull
    private String paymentType;
    @NotNull
    private int productId;
    private String tableName;
    private String waiterName;
    private Date date= new Timestamp(System.currentTimeMillis());

}
