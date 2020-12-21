package com.mapper;

import com.DTO.CategoryTableDTO;
import com.entity.CategoryTable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryTableMapper {
    CategoryTableMapper INSTANCE = Mappers.getMapper(CategoryTableMapper.class);

    List<CategoryTableDTO> toDTOList (List<CategoryTable> categoryTableList);

    CategoryTableDTO toDTO (CategoryTable categoryTable);

    CategoryTable toEntity(CategoryTableDTO categoryTableDTO);

}
