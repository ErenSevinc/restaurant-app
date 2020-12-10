package com.builder.DTOBuilder;

import com.DTO.CategoryTableDTO;
import com.builder.Builder;

public class CategoryTableDTOBuilder extends Builder {
    private int id;
    private String name;
    private int amount;

    public CategoryTableDTOBuilder id(int id){
        this.id=id;
        return this;
    }
    public CategoryTableDTOBuilder name(String name){
        this.name=name;
        return this;
    }
    public CategoryTableDTOBuilder amount(int amount){
        this.amount=amount;
        return this;
    }

    @Override
    public CategoryTableDTO build() {
        CategoryTableDTO categoryTableDTO=new CategoryTableDTO();
        categoryTableDTO.setId(this.id);
        categoryTableDTO.setName(this.name);
        categoryTableDTO.setAmount(this.amount);
        return categoryTableDTO;
    }
}
