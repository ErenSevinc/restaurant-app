package com.builder.DTOBuilder;

import com.DTO.MediaDTO;
import com.DTO.CategoriesDTO;
import com.DTO.ProductsDTO;
import com.builder.Builder;

import java.util.ArrayList;
import java.util.List;

public class CategoriesDTOBuilder extends Builder {
    private int id;
    private String name;
    private String description;
    private List<ProductsDTO> productsDTOList=new ArrayList<>();
    private MediaDTO mediaDTO;

    public CategoriesDTOBuilder id(int id){
        this.id=id;
        return this;
    }
    public CategoriesDTOBuilder name(String name){
        this.name=name;
        return this;
    }
    public CategoriesDTOBuilder description(String description){
        this.description=description;
        return this;
    }
    public CategoriesDTOBuilder productsDTOList(List<ProductsDTO> productsDTOList){
        this.productsDTOList=productsDTOList;
        return this;
    }
    public CategoriesDTOBuilder mediaDTO(MediaDTO mediaDTO){
        this.mediaDTO=mediaDTO;
        return this;
    }

    @Override
    public CategoriesDTO build() {
        CategoriesDTO categoriesDTO=new CategoriesDTO();

        categoriesDTO.setId(this.id);
        categoriesDTO.setName(this.name);
        categoriesDTO.setDescription(this.description);
        categoriesDTO.setProductsDTOList(this.productsDTOList);
        categoriesDTO.setMediaDTO(this.mediaDTO);

        return categoriesDTO;
    }
}
