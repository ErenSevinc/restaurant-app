package com.mapper;

import com.DTO.ProductsDTO;
import com.entity.Products;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductsMapper {
    ProductsMapper INSTANCE= Mappers.getMapper(ProductsMapper.class);

    @Mappings({
            @Mapping(source = "categories",target = "categoriesDTOList"),
            @Mapping(source = "media",target = "mediaDTO")
    })
    ProductsDTO toDTO(Products products);

    @Mappings({
            @Mapping(source = "categoriesDTOList",target = "categories"),
            @Mapping(source = "mediaDTO",target = "media")
    })
    Products toEntity(ProductsDTO productsDTO);

}
