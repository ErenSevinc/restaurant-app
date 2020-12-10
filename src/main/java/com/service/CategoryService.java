package com.service;

import com.DTO.CategoryDTO;
import com.DTO.ProductDTO;
import com.converter.CategoryConverter;
import com.entity.Category;
import com.entity.Product;
import com.repository.CategoryRepository;
import com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.pattern.PathPatternRouteMatcher;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;

    public List<CategoryDTO> getCategory(){
        List<Category> categoryList=categoryRepository.findAll();
        return CategoryConverter.getCategory(categoryList);
    }

    public CategoryDTO getSelectedCategory(int id) {
        Category category= categoryRepository.findAll().stream().filter(t -> t.getId() == id).findFirst().get();
        return CategoryConverter.getSelectedCategory(category);
    }

    public String addCategory(CategoryDTO categoryDTO){
        categoryRepository.save(CategoryConverter.addCategory(categoryDTO));
        return "Category Added";
    }

    public CategoryDTO updateCategory(CategoryDTO categoryDTO,int id){
        categoryRepository.save(CategoryConverter.updateCategory(categoryDTO));
        return categoryDTO;
    }

    public List<CategoryDTO> deleteCategory(int id){
        categoryRepository.deleteById(id);
        return getCategory();
    }
    public String addProductByCategory(ProductDTO productDTO,int id){

        Category category=categoryRepository.findById(id).get();
        productRepository.save(CategoryConverter.addProductByCategory(productDTO,category));

        return "Product Added";
    }


    public Set<ProductDTO> getProductByCategory(int id){
        Optional<Category> category=categoryRepository.findById(id);
        return CategoryConverter.getProductByCategory(category);

    }


}







