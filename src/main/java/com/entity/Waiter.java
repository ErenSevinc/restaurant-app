package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Waiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phoneNumber;
    private String mail;
    private String address;
    private String urlToImage;
    private double salary;

    @OneToOne(cascade =CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "media_id")
    private Media media;

}
