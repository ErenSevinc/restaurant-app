package com.service;

import com.DTO.CategoryDTO;
import com.DTO.ProductDTO;
import com.builder.CategoryBuilder;
import com.builder.DTOBuilder.CategoryDTOBuilder;
import com.converter.CategoryConverter;
import com.entity.Category;
import com.entity.Product;
import com.repository.CategoryRepository;
import com.repository.ProductRepository;
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
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private ProductRepository productRepository;
    private Product product=new Product();
    private ProductDTO productDTO=new ProductDTO();

    @Mock
    private CategoryRepository categoryRepository;

    private Category category=new Category();
    private CategoryDTO categoryDTO=new CategoryDTO();

    private CategoryBuilder categoryBuilder=new CategoryBuilder();
    private CategoryDTOBuilder categoryDTOBuilder=new CategoryDTOBuilder();

    private List<Category> categoryList =new ArrayList<>();
    private List<CategoryDTO> categoryDTOList =new ArrayList<>();

    private Set<Product> productSet=new HashSet<>();
    private Set<ProductDTO> productDTOSet =new HashSet<>();

    @Before
    public void setUp(){

        category=categoryBuilder.id(1).name("Başlangıç").description("iç ısıtıcı").urlToImage("").product(productSet).build();

//        categoryDTO.setId(1);
//        categoryDTO.setName("Başlangıç");
//        categoryDTO.setDescription("iç ısıtıcı");
//        categoryDTO.setUrlToImage("");
//        categoryDTO.setProducts(productSet);
        categoryDTO=categoryDTOBuilder.id(1).name("Başlangıç").description("iç ısıtıcı").urlToImage("").product(productSet).build();

    }

    @Test
    public void shouldGetCategory(){
        List<Category> list=categoryRepository.findAll();
        assertNotNull(list);
    }
    @Test
    public void shouldGetSelectedCategory(){
        int id=1;
        categoryList.add(category);
        Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
        CategoryDTO res = categoryService.getSelectedCategory(id);
        CategoryDTO dto = CategoryConverter.getSelectedCategory(category);

        assertEquals(res.getId(),dto.getId());
    }
    @Test
    public void shouldDeleteCategory(){
        int id=1;

        List<CategoryDTO> res= categoryService.deleteCategory(id);

        verify(categoryRepository,times(1)).deleteById(id);
    }
    @Test
    public void shouldAddCategory(){
        Mockito.when(categoryRepository.save(any())).thenReturn(category);

        String res = categoryService.addCategory(categoryDTO);

        assertNotNull(res);
        assertEquals(res,"Category Added");
    }
    @Test
    public void shouldUpdateCategory(){
        int id=1;

        Mockito.when(categoryRepository.saveAndFlush(category)).thenReturn(category);
        CategoryDTO res=categoryService.updateCategory(categoryDTO,id);

        assertEquals(res,categoryDTO);

    }
//    @Test
//    public void shouldAddProductByCategory(){
//        int id=1;
//        productSet.add(product);
//        category.setProducts(productSet);
//
//        Optional<Category> cat=Optional.of(category);
//
//        Mockito.when(categoryRepository.findById(id)).thenReturn(cat);
//        Mockito.when(categoryRepository.save(any())).thenReturn(category);
//        Category cat1= CategoryConverter.addProductByCategory(productDTO,cat);
//
//        String res=categoryService.addProductByCategory(productDTO,id);
//
//        assertEquals(res,"Product Added");
//    }
    @Test
    public void shouldGetProductByCategory(){
        int id=1;
        productSet.add(product);
        category.setProducts(productSet);
        productDTOSet.add(productDTO);

        Optional<Category> cat=Optional.of(category);
        Mockito.when(categoryRepository.findById(id)).thenReturn(cat);
        Set<ProductDTO> res = CategoryConverter.getProductByCategory(cat);

        Set<ProductDTO> dtoSet=categoryService.getProductByCategory(id);
        assertEquals(res.iterator().next().getId(),dtoSet.iterator().next().getId());


    }



}