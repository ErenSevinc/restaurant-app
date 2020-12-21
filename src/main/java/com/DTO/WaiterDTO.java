package com.DTO;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WaiterDTO {
    private int id;
    private String name;
    private String phoneNumber;
    private String mail;
    private String address;
    private String urlToImage;
    private double salary;
    private MediaDTO mediaDTO;

}
