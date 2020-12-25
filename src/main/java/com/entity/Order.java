package com.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="tbl_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE tbl_order "+"SET deleted = true "+"WHERE id = ?")
@Where(clause = "deleted = false")
public class Order extends BaseEntity {

    private double totalPrice;
    private int piece;
    private String paymentType;
    private int productId;
    private String tableName;
    private String waiterName;
    @Column
    private Date date= new Timestamp(System.currentTimeMillis());


}
