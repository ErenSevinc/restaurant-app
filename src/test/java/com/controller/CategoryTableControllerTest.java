package com.controller;

import com.DTO.CategoryTableDTO;
import com.builder.CategoryTableBuilder;
import com.builder.DTOBuilder.CategoryTableDTOBuilder;
import com.entity.CategoryTable;
import com.service.CategoryTableService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CategoryTableControllerTest {
    @InjectMocks
    private CategoryTableController categoryTableController;

    @Mock
    private CategoryTableService categoryTableService;

    private CategoryTable categoryTable=new CategoryTable();
    private CategoryTableDTO categoryTableDTO=new CategoryTableDTO();

    private List<CategoryTable> categoryTableList=new ArrayList<>();
    private List<CategoryTableDTO> categoryTableDTOList=new ArrayList<>();

    private CategoryTableBuilder categoryTableBuilder=new CategoryTableBuilder();
    private CategoryTableDTOBuilder categoryTableDTOBuilder=new CategoryTableDTOBuilder();

    @Before
    public void setUp() throws Exception{
        categoryTable=categoryTableBuilder.id(1).name("salon").amount(10).build();
        categoryTableList.add(categoryTable);

        categoryTableDTO=categoryTableDTOBuilder.id(1).name("salonDTO").amount(10).build();
        categoryTableDTOList.add(categoryTableDTO);
    }

    @Test
    public void shouldGetAllTables(){
        List<CategoryTableDTO> list=categoryTableController.getAllCategory();
        assertNotNull(list);
    }

    @Test
    public void shouldGetSelectedTable(){
        int id=1;
        Mockito.when(categoryTableService.getCategoryById(id)).thenReturn(categoryTableDTO);

        CategoryTableDTO res=categoryTableController.getCategoryById(id);

        assertNotNull(res);
        assertEquals(id,categoryTableDTO.getId());
    }

    @Test
    public void shouldAddTable(){
        Mockito.when(categoryTableService.addCategory(categoryTableDTO)).thenReturn("Table Added");

        String res=categoryTableController.addCategory(categoryTableDTO);

        assertNotNull(res);
        assertEquals(res,"Table Added");
    }

    @Test
    public void shouldUpdateTable(){
        int id=1;
        Mockito.when(categoryTableService.updateCategory(categoryTableDTO,id)).thenReturn(categoryTableDTO);

        CategoryTableDTO res=categoryTableController.updateCategory(categoryTableDTO,id);

        assertNotNull(res);
        assertEquals(res,categoryTableDTO);
    }

    @Test
    public void shouldDeleteTable(){
        int id=1;

        List<CategoryTableDTO> res=categoryTableController.deleteCategory(id);

        assertNotNull(res);
    }
}