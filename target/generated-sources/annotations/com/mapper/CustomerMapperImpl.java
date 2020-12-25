package com.mapper;

import com.DTO.CustomerDTO;
import com.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-25T02:02:33+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public List<CustomerDTO> toDTOList(List<Customer> customerList) {
        if ( customerList == null ) {
            return null;
        }

        List<CustomerDTO> list = new ArrayList<CustomerDTO>( customerList.size() );
        for ( Customer customer : customerList ) {
            list.add( toDTO( customer ) );
        }

        return list;
    }

    @Override
    public List<Customer> toEntityList(List<CustomerDTO> customerDTOList) {
        if ( customerDTOList == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( customerDTOList.size() );
        for ( CustomerDTO customerDTO : customerDTOList ) {
            list.add( toEntity( customerDTO ) );
        }

        return list;
    }

    @Override
    public CustomerDTO toDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( customer.getId() );
        customerDTO.setFirstName( customer.getFirstName() );
        customerDTO.setLastName( customer.getLastName() );
        customerDTO.setPhoneNumber( customer.getPhoneNumber() );
        customerDTO.setAddress( customer.getAddress() );

        return customerDTO;
    }

    @Override
    public Customer toEntity(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDTO.getId() );
        customer.setFirstName( customerDTO.getFirstName() );
        customer.setLastName( customerDTO.getLastName() );
        customer.setPhoneNumber( customerDTO.getPhoneNumber() );
        customer.setAddress( customerDTO.getAddress() );

        return customer;
    }
}
