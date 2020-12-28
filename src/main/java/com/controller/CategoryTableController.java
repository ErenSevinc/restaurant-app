package com.controller;

import com.DTO.CategoryTableDTO;
import com.entity.CategoryTable;
import com.service.CategoryTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categoryTable")
public class CategoryTableController {
    @Autowired
    CategoryTableService repository;
    @PostMapping("/add")
    public void addCategory(@RequestBody CategoryTableDTO categoryDTO) {
          repository.addCategory(categoryDTO);
    }
    @GetMapping("/list")
    public List<CategoryTableDTO> getAllCategory() {
        return repository.getAllCategory();
    }
    @DeleteMapping("/delete/{id}")
    public List<CategoryTableDTO> deleteCategory(@PathVariable int id) {
        return repository.deleteCategory(id);
    }
    @GetMapping("/list/{id}")
    public CategoryTableDTO getCategoryById(@PathVariable int id){
        return repository.getCategoryById(id);
    }
    @PutMapping("/update/{id}")
    public CategoryTableDTO updateCategory(@RequestBody CategoryTableDTO categoryTableDTO, @PathVariable int id){
        return repository.updateCategory(categoryTableDTO,id);
    }
//    @GetMapping("/table/id/{id}")
//    public Set<RestaurantTable> getProductByCategort(@PathVariable int id){
//        return repository.getProductCategory(id);
//    }


}
