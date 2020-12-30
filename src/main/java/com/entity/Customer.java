package com.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "tb_customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE customer "+"SET deleted = true "+"WHERE id = ?")
@Where(clause = "deleted = false")
public class Customer extends BaseEntity {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "media_id")
    private Media media;


}
