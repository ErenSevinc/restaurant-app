package com.builder;

import com.entity.Customer;
import com.entity.Media;

public class CustomerBuilder extends Builder {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private Media media;

    public CustomerBuilder id(int id){
        this.id=id;
        return this;
    }
    public CustomerBuilder firstName(String firstName){
        this.firstName=firstName;
        return this;
    }
    public CustomerBuilder lastName(String lastName){
        this.lastName=lastName;
        return this;
    }
    public CustomerBuilder phoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
        return this;
    }
    public CustomerBuilder address(String address){
        this.address=address;
        return this;
    }
    public CustomerBuilder media(Media media){
        this.media=media;
        return this;
    }

    @Override
    public Customer build() {
        Customer customer=new Customer();
        customer.setId(this.id);
        customer.setFirstName(this.firstName);
        customer.setLastName(this.lastName);
        customer.setPhoneNumber(this.phoneNumber);
        customer.setAddress(this.address);
        customer.setMedia(this.media);

        return customer;
    }
}
