package com.unused;

import com.unused.CategoryDTO;
import com.unused.ProductDTO;
import com.unused.CategoryConverter;
import com.unused.Category;
import com.unused.CategoryRepository;
import com.unused.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public String addProductByCategory(ProductDTO productDTO){
        int id=1;   //parametre
        Category category=categoryRepository.findById(id).get();
        productRepository.save(CategoryConverter.addProductByCategory(productDTO,category));

        return "Product Added";
    }


    public List<ProductDTO> getProductByCategory(int id){
        Optional<Category> category=categoryRepository.findById(id);
        return CategoryConverter.getProductByCategory(category);

    }


}







