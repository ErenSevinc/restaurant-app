package com.service;

import com.entity.Product;
import com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService {
    @Autowired
    ProductRepository repository;

    public List<Product> getAllProduct(){
        return repository.findAll();
    }

    public Product getSelectedProduct(int id){
        return repository.findAll().stream().filter(t -> t.getId() == id).findFirst().get();
    }
}
