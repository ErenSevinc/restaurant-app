package com.unused;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/listAll")
    public List<CategoryDTO> getCategory() {
        return categoryService.getCategory();
    }

    @GetMapping("/listAll/{id}")
    public CategoryDTO getSelectedCategory(@PathVariable int id) {
        return categoryService.getSelectedCategory(id);
    }

    @PostMapping("/addCategory")
    public void addCategory(@RequestBody CategoryDTO categoryDTO) {
         categoryService.addCategory(categoryDTO);
    }

    @PutMapping("/updateCategory/{id}")
    public CategoryDTO updateCategory(@RequestBody CategoryDTO category, @PathVariable int id) {
        return categoryService.updateCategory(category, id);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public List<CategoryDTO> deleteCategory(@PathVariable int id) {
        return categoryService.deleteCategory(id);
    }

    //product -backoffice

    @PostMapping("/addProductByCategory/{id}")
    public void addProductByCategory(@RequestBody ProductDTO productDTO) {
        categoryService.addProductByCategory(productDTO);
    }

    //product -client

    @GetMapping("/listProductByCategory/{id}")
    public List<ProductDTO> getProductByCategory(@PathVariable int id) {
        return categoryService.getProductByCategory(id);
   }

}


