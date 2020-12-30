package com.builder;

import com.entity.Media;
import com.entity.Waiter;
import liquibase.pro.packaged.W;

public class WaiterBuilder extends Builder {
    private int id;
    private String name;
    private String phoneNumber;
    private String mail;
    private String address;
    private String urlToImage;
    private double salary;
    private Media media;

    public WaiterBuilder id(int id){
        this.id=id;
        return this;
    }
    public WaiterBuilder name(String name){
        this.name=name;
        return this;
    }
    public WaiterBuilder phoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
        return this;
    }
    public WaiterBuilder mail(String mail){
        this.mail=mail;
        return this;
    }
    public WaiterBuilder address(String address){
        this.address=address;
        return this;
    }
    public WaiterBuilder urlToImage(String urlToImage){
        this.urlToImage=urlToImage;
        return this;
    }
    public WaiterBuilder salary(double salary){
        this.salary=salary;
        return this;
    }
    public WaiterBuilder media(Media media){
        this.media=media;
        return this;
    }

    @Override
    public Waiter build() {
        Waiter waiter=new Waiter();
        waiter.setId(this.id);
        waiter.setName(this.name);
        waiter.setPhoneNumber(this.phoneNumber);
        waiter.setMail(this.mail);
        waiter.setAddress(this.address);
        waiter.setUrlToImage(this.urlToImage);
        waiter.setSalary(this.salary);
        waiter.setMedia(this.media);
        return waiter;
    }
}
