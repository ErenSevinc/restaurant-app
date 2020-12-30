package com.controller;

import com.DTO.CustomerDTO;
import com.builder.CustomerBuilder;
import com.builder.DTOBuilder.CustomerDTOBuilder;
import com.entity.Customer;
import com.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    private Customer customer=new Customer();
    private CustomerDTO customerDTO=new CustomerDTO();
    private List<Customer> customerList=new ArrayList<>();
    private List<CustomerDTO> customerDTOList=new ArrayList<>();

    private CustomerBuilder customerBuilder=new CustomerBuilder();
    private CustomerDTOBuilder customerDTOBuilder=new CustomerDTOBuilder();

    @Before
    public void setUp(){
        customer=customerBuilder.id(1).firstName("eren").lastName("sevinç").phoneNumber("05555555").address("ev").build();
        customerList.add(customer);
        customerDTO=customerDTOBuilder.id(1).firstName("erenDTO").lastName("sevinç").phoneNumber("05555555").address("ev").build();
        customerDTOList.add(customerDTO);
    }

    @Test
    public void shouldGetSelectedCustomer(){
        int id=1;
        Mockito.when(customerService.getSelectedCustomer(id)).thenReturn(customerDTO);

        CustomerDTO res=customerController.getSelectedCustomer(id);

        assertNotNull(res);
    }

    @Test
    public void shouldAddCustomer(){
        Mockito.when(customerService.addCustomer(customerDTO)).thenReturn(customerDTO);

        CustomerDTO res=customerController.addCustomer(customerDTO);

        assertEquals(res.getId(),customerDTO.getId());
    }

    @Test
    public void shouldUpdateCustomer(){
        int id=1;
        Mockito.when(customerService.updateCustomer(customerDTO,id)).thenReturn(customerDTO);

        CustomerDTO res=customerController.updateCustomer(customerDTO,id);

        assertEquals(res.getId(),id);
    }

    @Test
    public void shouldDeleteCustomer(){
        int id=1;
        Mockito.when(customerService.deleteCustomer(id)).thenReturn("ID: "+id+" has deleted");

        String res=customerController.deleteCustomer(id);

        assertEquals(res,"Customer Deleted");
    }

}