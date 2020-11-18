package com.service;

import com.entity.Product;
import com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BackOfficeService {
    private List<Product> productList=new ArrayList<>(Arrays.asList(
            new Product("Biftek","Şengül Kasap",80.50,"Et"),
            new Product("Tavuk Kanat","Şengül Kasap",25.50,"Tavuk"),
            new Product("Hamsi Tava","Bordo Mavi Balıkçılık",45.50,"Balık")
    ));

    @Autowired
    ProductRepository repository;

    public List<Product> getAllProduct(){
       return repository.findAll();
    }

    public Product getSelectedProduct(int id){
        return repository.findAll().stream().filter(t -> t.getId() == id).findFirst().get();
    }

    public Product addProduct(Product product){

        return repository.save(product);
    }
    public Product updateProduct(int id, Product product){
        Optional<Product> productList = repository.findAll().stream().filter(p->p.getId() ==id).findAny();
        if (!productList.isPresent()){
            System.out.println("Sonuç bulunamadı");
            return null;
        }
        productList.get().setName(product.getName());
        productList.get().setBrand(product.getBrand());
        productList.get().setPrice(product.getPrice());
        productList.get().setCategory(product.getCategory());

        return repository.save(productList.get());
    }
    public List<Product> deleteProduct(int id){
        repository.deleteById(id);
        return repository.findAll();
    }


}
