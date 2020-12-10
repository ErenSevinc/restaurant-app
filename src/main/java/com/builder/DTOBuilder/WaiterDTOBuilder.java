package com.builder.DTOBuilder;

import com.DTO.WaiterDTO;
import com.builder.Builder;

public class WaiterDTOBuilder extends Builder {
    private int id;
    private String name;
    private String phoneNumber;
    private String mail;
    private String address;
    private String urlToImage;
    private double salary;

    public WaiterDTOBuilder id(int id){
        this.id=id;
        return this;
    }
    public WaiterDTOBuilder name(String name){
        this.name=name;
        return this;
    }
    public WaiterDTOBuilder phoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
        return this;
    }
   public WaiterDTOBuilder mail(String mail){
        this.mail=mail;
        return this;
   }
    public WaiterDTOBuilder address(String address){
        this.address=address;
        return this;
    }
    public WaiterDTOBuilder urlToImage(String urlToImage){
        this.urlToImage=urlToImage;
        return this;
    }
    public WaiterDTOBuilder salary(double salary){
        this.salary=salary;
        return this;
    }

    @Override
    public WaiterDTO build() {
        WaiterDTO waiterDTO=new WaiterDTO();
        waiterDTO.setId(this.id);
        waiterDTO.setName(this.name);
        waiterDTO.setPhoneNumber(this.phoneNumber);
        waiterDTO.setMail(this.mail);
        waiterDTO.setAddress(this.address);
        waiterDTO.setUrlToImage(this.urlToImage);
        waiterDTO.setSalary(this.salary);
        return waiterDTO;
    }
}

