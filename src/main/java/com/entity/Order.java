package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="tbl_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double totalPrice;
    private int piece;
    private String paymentType;
    private int productId;
    private String tableName;
    private String waiterName;
    @Column
    private Date date= new Timestamp(System.currentTimeMillis());

}
