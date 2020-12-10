package com.service;

import com.DTO.CategoryTableDTO;
import com.converter.CategoryTableConverter;
import com.entity.CategoryTable;
import com.repository.CategoryTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryTableService {
    @Autowired
    CategoryTableRepository repository;

    public List<CategoryTableDTO> getAllCategory() {
        List<CategoryTable> categoryTable = repository.findAll();
        return CategoryTableConverter.getAllCategory(categoryTable);
    }

    public List<CategoryTableDTO> deleteCategory(int id) {
        repository.deleteById(id);
        return getAllCategory();
    }

    public String addCategory(CategoryTableDTO categoryDTO) {
        repository.save(CategoryTableConverter.addCategory(categoryDTO));
        return "Added";
    }
    public List<CategoryTableDTO> updateCategory (CategoryTableDTO categoryTableDTO,int id){
        Optional<CategoryTable> cat=repository.findById(id);
        repository.saveAndFlush(CategoryTableConverter.updateCategory(cat,categoryTableDTO));
        return getAllCategory();
    }
    public CategoryTableDTO getCategoryById(int id) {

        CategoryTable catTbl = repository.findAll().stream().filter(t -> t.getId() == id).findFirst().get();
        return CategoryTableConverter.getCategoryById(catTbl);
    }

}
