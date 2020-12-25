package com.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@SQLDelete(sql = "UPDATE waiter "+"SET deleted = true "+"WHERE id = ?")
@Where(clause = "deleted = false")
public class Waiter extends BaseEntity {

    private String name;
    private String phoneNumber;
    private String mail;
    private String address;
    private String urlToImage;
    private double salary;

    @OneToOne(cascade =CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "media_id")
    private Media media;

}
