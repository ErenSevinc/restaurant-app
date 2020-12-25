package com.service;

import com.DTO.CustomerDTO;
import com.DTO.CustomerWrapperList;
import com.entity.Customer;
import com.mapper.CustomerMapper;
import com.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    public CustomerDTO getSelectedCustomer(int id){
        Customer customer= customerRepository.findAll().stream().filter(cstmr ->cstmr.getId() == id).findFirst().get();
        if (customer == null){
            return null;
        }

        return customerMapper.toDTO(customer);
    }
    public CustomerDTO addCustomer(CustomerDTO customerDTO){
        if(customerDTO.equals(null)){
            return null;
        }

        return customerMapper.toDTO(customerRepository.save(customerMapper.toEntity(customerDTO)));
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO,int id){
        Customer customer= customerRepository.findAll().stream().filter(cstmr ->cstmr.getId() == id).findFirst().get();
        if(customer.equals(null)){
            return null;
        }

        //helper a al
        if (!customerDTO.getFirstName().equals(customer.getFirstName())){
            customer.setFirstName(customerDTO.getFirstName());
        }
        if(!customerDTO.getLastName().equals(customer.getLastName())){
            customer.setLastName(customerDTO.getLastName());
        }
        if (!customerDTO.getPhoneNumber().equals(customer.getPhoneNumber())){
            customer.setPhoneNumber(customerDTO.getPhoneNumber());
        }
        if (!customerDTO.getAddress().equals(customer.getAddress())){
            customer.setAddress(customerDTO.getAddress());
        }

        customerRepository.saveAndFlush(customer);

        return customerMapper.toDTO(customer);
    }

    public String deleteCustomer(int id){
        Customer customer= customerRepository.findAll().stream().filter(cstmr ->cstmr.getId() == id).findFirst().get();
        if(customer.equals(null)){
            return null;
        }

        customerRepository.deleteById(id);

        return "Customer Deleted";
    }

    public CustomerWrapperList getCustomersMore(Pageable pageable){
        Page<Customer> customerPage = customerRepository.findAll(pageable);
        if(customerPage.equals(null)){
            return null;
        }

        List<Customer> customerList = customerPage.getContent();
        List<CustomerDTO> customerDTOList = customerMapper.toDTOList(customerList);

        CustomerWrapperList customerWrapperList=new CustomerWrapperList();
        customerWrapperList.setCustomerDTOList(customerDTOList);
        customerWrapperList.setTotalElements((int) customerPage.getTotalElements());
        customerWrapperList.setSize(customerPage.getSize());

        return customerWrapperList;

    }


}
