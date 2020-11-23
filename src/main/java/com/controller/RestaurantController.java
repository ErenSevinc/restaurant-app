package com.controller;

import com.entity.Order;
import com.entity.Product;
import com.service.BackOfficeService;
import com.service.ClientService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class RestaurantController {

    @Autowired
    private BackOfficeService service;

    //product list
    @GetMapping("/backoffice/list")
    public List<Product> getProduct(){
        return service.getAllProduct();
    }

    //product list id
    @GetMapping("/backoffice/list/{id}")
    public Product getSelectedProduct(@PathVariable int id){
        return service.getSelectedProduct(id);
    }

    //product add
    @PostMapping("/backoffice/add")
    public Product addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

    //product update
    @PutMapping("/backoffice/update/{id}")
    public Product updateProduct(@PathVariable int id,@RequestBody Product product){
        return service.updateProduct(id, product);
    }

    //product delete
    @DeleteMapping("/backoffice/delete/{id}")
    public List<Product> deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }

    //product category name
    @GetMapping("/backoffice/category")
    public List<String> getCategory(){
        return service.getProductCategory();
    }

    //product list by category
    @GetMapping("/backoffice/list/category")
    public List<Product> getProductByCategory(@RequestParam String category){
        return service.getProductByCategory(category);
    }

    //basket complete
    @PostMapping("/basket")
    public void addSales(@RequestBody List<Order> list){
        service.addSales(list);
    }

    @GetMapping("/basket/list")
    public List<Order> listSales(){
        return service.listSales();
    }

}
