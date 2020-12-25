package com.mapper;

import com.DTO.CategoriesDTO;
import com.entity.Categories;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriesMapper {
   CategoriesMapper INSTANCE= null;  // Mappers.getMapper(CategoriesMapper.class);
 CategoriesMapper mINSTANCE=Mappers.getMapper(CategoriesMapper.class);
    @Mappings({
            @Mapping(source = "media",target = "mediaDTO"),
            @Mapping(source = "products", target = "productsDTOList")
    })
    CategoriesDTO toDTO(Categories categories);

    @Mappings({
            @Mapping(source = "mediaDTO",target = "media"),
            @Mapping(source = "productsDTOList", target = "products")
    })
    Categories toEntity(CategoriesDTO categoriesDTO);

    List<CategoriesDTO> toDTOList(List<Categories> categoriesList);

    List<Categories> toEntityList(List<CategoriesDTO> categoriesDTOList);

}
