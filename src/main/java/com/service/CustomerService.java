package com.service;

import com.DTO.CustomerDTO;
import com.DTO.CustomerWrapperList;
import com.entity.Customer;
import com.entity.Media;
import com.exception.BusinessRuleException;
import com.exception.CustomerExceptionHandler;
import com.exception.SystemException;
import com.helper.EntityHelper;
import com.mapper.CustomerMapper;
import com.mapper.MediaMapper;
import com.repository.CustomerRepository;
import com.repository.MediaRepository;
import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MediaRepository mediaRepository;
    @Autowired
    private CustomerMapper customerMapper;

    public CustomerDTO getSelectedCustomer(int id){
        Customer customer= customerRepository.findAll().stream().filter(cstmr ->cstmr.getId() == id).findFirst().
                orElseThrow(()-> new SystemException("ID bulunamadı"));

        return customerMapper.toDTO(customer);
    }
    public CustomerDTO addCustomer(CustomerDTO customerDTO){
//        if(customerDTO==null){
//            throw new BusinessRuleException("Customer objesi bulunamadı");
//        }
//
//        return customerMapper.toDTO(customerRepository.save(customerMapper.toEntity(customerDTO)));
        try {
            if (customerDTO.getMediaDTO()==null){
                Media media= mediaRepository.findById(3).get();
                customerDTO.setMediaDTO(MediaMapper.INSTANCE.toDTO(media));
            }
            return customerMapper.toDTO(customerRepository.save(customerMapper.toEntity(customerDTO)));
        }
        catch (SystemException e){
            throw new SystemException("Customer eklenemedi");
        }
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO,int id){
        Customer customer= customerRepository.findAll().stream().filter(cstmr ->cstmr.getId() == id).findFirst()
                .orElseThrow(()->new SystemException("Customer not found"));

        EntityHelper.updateCustomerHelper(customer,customerDTO);

        customerRepository.saveAndFlush(customer);

        return customerMapper.toDTO(customer);
    }

    public String deleteCustomer(int id){

        Customer customer= customerRepository.findAll().stream().filter(cstmr ->cstmr.getId() == id).findFirst()
                .orElseThrow(()->new SystemException("Customer not found"));

        customerRepository.deleteById(customer.getId());

        return "ID: "+id+" has deleted";
    }

    public CustomerWrapperList getCustomersMore(Pageable pageable){
        Page<Customer> customerPage = customerRepository.findAll(pageable);
        if(customerPage.equals(null)){
            throw new SystemException("pageable is null");
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
