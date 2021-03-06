package com.controller;

import com.DTO.CustomerDTO;
import com.DTO.CustomerWrapperList;
import com.exception.BusinessRuleException;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public CustomerDTO getSelectedCustomer(@PathVariable int id){
        return customerService.getSelectedCustomer(id);
    }

    @PostMapping()
    public CustomerDTO addCustomer(@Valid @RequestBody CustomerDTO customerDTO){
//        if (customerDTO.getLastName() == null){
//            throw new BusinessRuleException("Customer soyadı null olamaz veya hatalı geldi...");
//        }
        return customerService.addCustomer(customerDTO);
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@Valid @RequestBody CustomerDTO customerDTO, @PathVariable int id){
        return customerService.updateCustomer(customerDTO,id);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
        return "Customer Deleted";
    }

    @GetMapping("/search")
    public CustomerWrapperList getCustomersMore(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
        Pageable pageable= PageRequest.of(page, size);
        return customerService.getCustomersMore(pageable);
    }

}
