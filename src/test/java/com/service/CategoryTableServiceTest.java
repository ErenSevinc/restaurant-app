package com.service;

import com.DTO.CategoryTableDTO;
import com.builder.CategoryTableBuilder;
import com.builder.DTOBuilder.CategoryTableDTOBuilder;
import com.entity.CategoryTable;
import com.repository.CategoryTableRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class CategoryTableServiceTest {

    @InjectMocks
    private CategoryTableService categoryTableService;

    @Mock
    private CategoryTableRepository categoryTableRepository;

    private CategoryTableBuilder categoryTableBuilder=new CategoryTableBuilder();
    private CategoryTableDTOBuilder categoryTableDTOBuilder=new CategoryTableDTOBuilder();

    private CategoryTableDTO categoryTableDTO=new CategoryTableDTO();
    private CategoryTable categoryTable=new CategoryTable();
    private List<CategoryTableDTO> categoryTableDTOList = new ArrayList<>();
    private List<CategoryTable> categoryTableList = new ArrayList<>();

    @Before
    public void setUp(){
        categoryTable=categoryTableBuilder.id(1).name("SALON").amount(5).build();
        categoryTableDTO=categoryTableDTOBuilder.id(1).name("BALKON").amount(5).build();

        categoryTableDTOList.add(categoryTableDTO);
    }

    @Test
    public void shouldGetAllCategory(){
        List<CategoryTableDTO> catDTOList = categoryTableService.getAllCategory();
        assertNotNull(catDTOList);
    }

    @Test
    public void shouldAddCategory(){
        Mockito.when(categoryTableRepository.save(any())).thenReturn(categoryTable);

        String result= categoryTableService.addCategory(categoryTableDTO);

        assertNotNull(result);
        assertEquals(result,"Added");

    }
    @Test
    public void shouldDeleteCategory(){
        int id=1;
        List<CategoryTableDTO> catDTOList =categoryTableService.deleteCategory(id);
        verify(categoryTableRepository,times(1)).deleteById(id);
    }
//    @Test
//    public void shouldGetCategoryById(){
//        int id=1;
//        Optional<CategoryTable> list= Optional.of(categoryTable);
//
//        Mockito.when(categoryTableRepository.findById(id)).thenReturn(list);
//        CategoryTableDTO result= categoryTableService.getCategoryById(id);
//
//        assertNotNull(result);
//        assertEquals(result.getId(),id);
//
//
//    }
//    @Test
//    public void shouldUpdateCategory(){
//        int id=1;
//        Mockito.when(categoryTableRepository.saveAndFlush(categoryTable)).thenReturn(categoryTable);
//
//
//    CategoryTableDTO categoryTableDTO2 = (CategoryTableDTO) categoryTableService.updateCategory(categoryTableDTO,id);
//
//    assertNotNull(categoryTableDTO2);
//    assertEquals(categoryTableDTO2,categoryTableDTO);
//}
}