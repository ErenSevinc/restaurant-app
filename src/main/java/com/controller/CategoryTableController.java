package com.controller;

import com.DTO.CategoryTableDTO;
import com.entity.CategoryTable;
import com.service.CategoryTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categoryTable")
public class CategoryTableController {
    @Autowired
    CategoryTableService repository;

    @PostMapping("/add")
    public String addCategory(@Valid @RequestBody CategoryTableDTO categoryDTO) {
          repository.addCategory(categoryDTO);
          return "Table Added";
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
    public CategoryTableDTO updateCategory(@Valid @RequestBody CategoryTableDTO categoryTableDTO, @PathVariable int id){
        return repository.updateCategory(categoryTableDTO,id);
    }


}
