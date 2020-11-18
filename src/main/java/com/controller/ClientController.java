package com.controller;

import com.entity.Product;
import com.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    public List<Product> getProductClient(){
        return clientService.getAllProduct();
    }
    @GetMapping("/list/{id}")
    public Product getSelectedProductClient(@PathVariable int id){
        return clientService.getSelectedProduct(id);
    }
}
