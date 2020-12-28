package com.service;

import com.DTO.CategoryTableDTO;
import com.converter.CategoryTableConverter;
import com.entity.CategoryTable;
import com.exception.SystemException;
import com.helper.EntityHelper;
import com.mapper.CategoriesMapper;
import com.mapper.CategoryTableMapper;
import com.mapper.WaiterMapper;
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
//        List<CategoryTable> categoryTable = repository.findAll();
//        return CategoryTableConverter.getAllCategory(categoryTable);
        return CategoryTableMapper.INSTANCE.toDTOList(repository.findAll());
    }

    public List<CategoryTableDTO> deleteCategory(int id) {
        CategoryTable table=repository.findById(id).orElseThrow(()->new SystemException("Table not found"));
        repository.delete(table);
        return getAllCategory();
    }

    public String addCategory(CategoryTableDTO categoryDTO) {
        repository.save(CategoryTableMapper.INSTANCE.toEntity(categoryDTO));
        return "Added";
    }
    public CategoryTableDTO updateCategory (CategoryTableDTO categoryTableDTO, int id){
        CategoryTable categoryTable=repository.findById(id).orElseThrow(()->new SystemException("Table not found"));

        EntityHelper.updateCategoryTableHelper(categoryTable,categoryTableDTO);

        repository.saveAndFlush(categoryTable);

        return CategoryTableMapper.INSTANCE.toDTO(categoryTable);
    }
    public CategoryTableDTO getCategoryById(int id) {
//        CategoryTable catTbl = repository.findAll().stream().filter(t -> t.getId() == id).findFirst().get();
//        return CategoryTableConverter.getCategoryById(catTbl);
        return CategoryTableMapper.INSTANCE.toDTO(repository.findById(id)
                .orElseThrow(()->new SystemException("Table not found")));
    }

}
