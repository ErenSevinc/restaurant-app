package com.builder.DTOBuilder;

import com.DTO.MediaDTO;
import com.DTO.CategoriesDTO;
import com.DTO.ProductsDTO;
import com.builder.Builder;

import java.util.List;

public class ProductsDTOBuilder extends Builder {
    private int id;
    private String name;
    private String brand;
    private double price;
    private List<CategoriesDTO> categoriesDTOList;
    private MediaDTO mediaDTO;

    public  ProductsDTOBuilder id(int id){
        this.id=id;
        return this;
    }
    public ProductsDTOBuilder name(String name){
        this.name=name;
        return this;
    }
    public ProductsDTOBuilder brand(String brand){
        this.brand=brand;
        return this;
    }
    public ProductsDTOBuilder price(double price){
        this.price=price;
        return this;
    }
    public ProductsDTOBuilder categoriesDTOList(List<CategoriesDTO> categoriesDTOList){
        this.categoriesDTOList=categoriesDTOList;
        return this;
    }
    public ProductsDTOBuilder mediaDTO(MediaDTO mediaDTO){
        this.mediaDTO=mediaDTO;
        return this;
    }

    @Override
    public Object build() {
        ProductsDTO productsDTO=new ProductsDTO();

        productsDTO.setId(this.id);
        productsDTO.setName(this.name);
        productsDTO.setBrand(this.brand);
        productsDTO.setPrice(this.price);
        productsDTO.setCategoriesDTOList(this.categoriesDTOList);
        productsDTO.setMediaDTO(this.mediaDTO);

        return productsDTO;
    }
}
