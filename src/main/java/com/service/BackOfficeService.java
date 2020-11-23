package com.service;

import com.entity.Product;
import com.repository.OrderRepository;
import com.repository.ProductRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import com.entity.Order;

@Service
public class BackOfficeService {
    private List<Product> productList=new ArrayList<>();

    @Autowired
    ProductRepository repository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

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
        productList.get().setUrlToImage(product.getUrlToImage());

        return repository.save(productList.get());
    }

    public List<Product> deleteProduct(int id){
        repository.deleteById(id);
        return repository.findAll();
    }

    public List<String> getProductCategory(){
        return repository.findAllCategory();
    }

    public List<Product> getProductByCategory(String category){
        return repository.getCategoryProduct(category);
    }

    public void addSales(List<Order> list){
        orderRepository.saveAll(list);
    }

    public List<Order> listSales(){
        return orderRepository.findAll();
    }


}
