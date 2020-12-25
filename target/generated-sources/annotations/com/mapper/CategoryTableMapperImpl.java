package com.mapper;

import com.DTO.CategoryTableDTO;
import com.entity.CategoryTable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-25T02:02:34+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class CategoryTableMapperImpl implements CategoryTableMapper {

    @Override
    public List<CategoryTableDTO> toDTOList(List<CategoryTable> categoryTableList) {
        if ( categoryTableList == null ) {
            return null;
        }

        List<CategoryTableDTO> list = new ArrayList<CategoryTableDTO>( categoryTableList.size() );
        for ( CategoryTable categoryTable : categoryTableList ) {
            list.add( toDTO( categoryTable ) );
        }

        return list;
    }

    @Override
    public CategoryTableDTO toDTO(CategoryTable categoryTable) {
        if ( categoryTable == null ) {
            return null;
        }

        CategoryTableDTO categoryTableDTO = new CategoryTableDTO();

        categoryTableDTO.setId( categoryTable.getId() );
        categoryTableDTO.setName( categoryTable.getName() );
        categoryTableDTO.setAmount( categoryTable.getAmount() );

        return categoryTableDTO;
    }

    @Override
    public CategoryTable toEntity(CategoryTableDTO categoryTableDTO) {
        if ( categoryTableDTO == null ) {
            return null;
        }

        CategoryTable categoryTable = new CategoryTable();

        categoryTable.setId( categoryTableDTO.getId() );
        categoryTable.setName( categoryTableDTO.getName() );
        categoryTable.setAmount( categoryTableDTO.getAmount() );

        return categoryTable;
    }
}
