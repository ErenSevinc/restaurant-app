package com.DTO;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class WaiterDTO {
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String phoneNumber;
    @NotNull
    @Email
    private String mail;
    @NotNull
    private String address;
    private String urlToImage;
    @NotNull
    private double salary;
    @NotNull
    private MediaDTO mediaDTO;

}
