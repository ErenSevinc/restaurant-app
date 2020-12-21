package com.controller;

import com.DTO.CategoriesDTO;
import com.DTO.ProductsDTO;
import com.service.start.CategoriesService;
import com.service.start.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/base")
public class CategoryProductController {

    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private ProductsService productsService;


    @GetMapping("/list-categories")
    public List<CategoriesDTO> listCategories(){
        return categoriesService.listCategories();
    }

    @GetMapping("/list-categories/{id}")
    public CategoriesDTO listCategoriesById(@PathVariable int id){
        return categoriesService.listCategoriesById(id);
    }

    @PostMapping("/add-categories")
    public String addCategories(@RequestBody CategoriesDTO categoriesDTO){
        categoriesService.addCategories(categoriesDTO);
        return "Categories Added";
    }

    @PutMapping("/update-categories")
    public String updateCategories(@RequestBody CategoriesDTO categoriesDTO){
        categoriesService.updateCategories(categoriesDTO);
        return "Categories Updated";
    }

    @DeleteMapping("/delete-categories/{id}")
    public String deleteCategories(@PathVariable int id){
        categoriesService.deleteCategories(id);
        return "Categories Deleted";
    }

    @GetMapping("/list-products")
    public List<ProductsDTO> listProducts(){
        return productsService.listProducts();
    }

    @GetMapping("/list-products/{id}")
    public ProductsDTO listProductsById(@PathVariable int id){
        return  productsService.listProductsById(id);
    }

    @GetMapping("/list-by-categories-products/{id}")
    public List<ProductsDTO> getProductsByCategories(@PathVariable int id){
        return productsService.getProductsByCategories(id);
    }

    @PostMapping("/add-products")
    public ProductsDTO addProducts(@RequestBody ProductsDTO productsDTO){
        return productsService.addProducts(productsDTO);
    }

    @PutMapping("/update-products")
    public ProductsDTO updateProducts(@RequestBody ProductsDTO productsDTO){
        return productsService.updateProducts(productsDTO);
    }

    @DeleteMapping("/delete-products/{id}")
    public String deleteProducts(@PathVariable int id){
        productsService.deleteProducts(id);
        return "Products Deleted";
    }




}
