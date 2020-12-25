package com.converter;

import com.DTO.CategoryTableDTO;
import com.entity.CategoryTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryTableConverter {
    public static List<CategoryTableDTO> getAllCategory(List<CategoryTable> categoryTable) {

        List<CategoryTableDTO> categoryTableDTOList =new ArrayList<>();

        for (CategoryTable ct:categoryTable){
            CategoryTableDTO ctDTO=new CategoryTableDTO();
            ctDTO.setId(ct.getId());
            ctDTO.setName(ct.getName());
            ctDTO.setAmount(ct.getAmount());
            categoryTableDTOList.add(ctDTO);
        }
        return categoryTableDTOList;
    }
    public static CategoryTable addCategory(CategoryTableDTO categoryDTO) {

        CategoryTable categoryTable=new CategoryTable();
        categoryTable.setName(categoryDTO.getName());
        categoryTable.setAmount(categoryDTO.getAmount());

        return categoryTable;
    }
    public static CategoryTable updateCategory (CategoryTable cat,CategoryTableDTO categoryTableDTO){

        cat.setName(categoryTableDTO.getName());
        cat.setAmount(categoryTableDTO.getAmount());

        return cat;
    }
    public static CategoryTableDTO getCategoryById(CategoryTable catTbl) {

        CategoryTableDTO categoryTableDTO=new CategoryTableDTO();
        categoryTableDTO.setId(catTbl.getId());
        categoryTableDTO.setName(catTbl.getName());
        categoryTableDTO.setAmount(catTbl.getAmount());

        return categoryTableDTO ;
    }
}
