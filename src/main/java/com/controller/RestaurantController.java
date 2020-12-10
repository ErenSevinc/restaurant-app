package com.controller;

import com.DTO.OrderDTO;
import com.DTO.ProductDTO;
import com.entity.Order;
import com.entity.Product;
import com.service.BackOfficeService;
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
    @GetMapping("/list")
    public List<ProductDTO> getProduct(){
        return service.getAllProduct();
    }

    //product list id
    @GetMapping("/list/{id}")
    public ProductDTO getSelectedProduct(@PathVariable int id){
        return service.getSelectedProduct(id);
    }

    //product add
    @PostMapping("/add")
    private Product addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

    //product update
    @PutMapping("/update/{id}")
    public List<ProductDTO> updateProduct(@PathVariable int id,@RequestBody ProductDTO product){
        return service.updateProduct(id, product);
    }

    //product delete
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
    }

    //product category name
//    @GetMapping("/category")
//    private List<String> getCategory(){
//        return service.getProductCategory();
//    }
//
//    //product list by category-string
//    @GetMapping("/list/category")
//    private List<Product> getProductByCategory(@RequestParam String category){
//        return service.getProductByCategory(category);
//    }

    //basket complete
    @PostMapping("/basket")
    public String addSales(@RequestBody List<OrderDTO> list){
        service.addSales(list);
        return "Siparişiniz Alınmıştır";
    }

    @GetMapping("/basket/list")
    public List<OrderDTO> listSales(){
        return service.listSales();
    }

}
