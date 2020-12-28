package com.builder.DTOBuilder;

import com.DTO.CustomerDTO;
import com.DTO.MediaDTO;
import com.builder.Builder;

public class CustomerDTOBuilder extends Builder {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private MediaDTO mediaDTO;

    public CustomerDTOBuilder id(int id){
        this.id=id;
        return this;
    }
    public CustomerDTOBuilder firstName(String firstName){
        this.firstName=firstName;
        return this;
    }
    public CustomerDTOBuilder lastName(String lastName){
        this.lastName=lastName;
        return this;
    }
    public CustomerDTOBuilder phoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
        return this;
    }
    public CustomerDTOBuilder address(String address){
        this.address=address;
        return this;
    }
    public CustomerDTOBuilder media(MediaDTO mediaDTO){
        this.mediaDTO=mediaDTO;
        return this;
    }

    @Override
    public CustomerDTO build() {
        CustomerDTO customerDTO=new CustomerDTO();
        customerDTO.setId(this.id);
        customerDTO.setFirstName(this.firstName);
        customerDTO.setLastName(this.lastName);
        customerDTO.setPhoneNumber(this.phoneNumber);
        customerDTO.setAddress(this.address);
        customerDTO.setMediaDTO(this.mediaDTO);

        return customerDTO;
    }
}
