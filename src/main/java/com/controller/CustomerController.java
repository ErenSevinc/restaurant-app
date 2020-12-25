package com.controller;

import com.DTO.CustomerDTO;
import com.DTO.CustomerWrapperList;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.addCustomer(customerDTO);
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO,@PathVariable int id){
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
