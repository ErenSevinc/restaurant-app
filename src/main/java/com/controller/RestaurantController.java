package com.controller;

import com.entity.Product;
import com.service.BackOfficeService;
import com.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("")
public class RestaurantController {

    @Autowired
    private BackOfficeService service;

    @GetMapping("/backoffice/list")
    public List<Product> getProduct(){
        return service.getAllProduct();
    }
    @GetMapping("/backoffice/list/{id}")
    public Product getSelectedProduct(@PathVariable int id){
        return service.getSelectedProduct(id);
    }
    @PostMapping("/backoffice/add")
    public Product addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }
    @PutMapping("/backoffice/update/{id}")
    public Product updateProduct(@PathVariable int id,@RequestBody Product product){
        return service.updateProduct(id, product);
    }
    @DeleteMapping("/backoffice/delete/{id}")
    public List<Product> deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }
}
