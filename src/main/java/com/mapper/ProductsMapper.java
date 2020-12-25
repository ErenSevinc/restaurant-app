package com.mapper;

import com.DTO.ProductsDTO;
import com.entity.Products;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductsMapper {
    ProductsMapper INSTANCE= null;  // Mappers.getMapper(CategoriesMapper.class);

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

    List<ProductsDTO> toDTOList(List<Products> productsList);

    List<Products> toEntityList(List<ProductsDTO> productsDTOList);

}
