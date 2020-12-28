package com.unused;

//import com.DTO.CategoriesDTO;
//import com.DTO.ProductsDTO;
//import com.builder.CategoriesBuilder;
//import com.builder.DTOBuilder.CategoriesDTOBuilder;
//import com.entity.Categories;
//import com.entity.Products;
//import com.repository.CategoriesRepository;
//import com.repository.ProductsRepository;
//import com.service.CategoriesService;
//import com.unused.Category;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Matchers.any;
//import static org.mockito.Mockito.verify;
//
//@RunWith(MockitoJUnitRunner.class)
//public class CategoriesServiceTest {
//
//    @InjectMocks
//    private CategoriesService categoryService;
//
//    @Mock
//    private ProductsRepository productRepository;
//    private Products products=new Products();
//    private ProductsDTO productsDTO=new ProductsDTO();
//
//    @Mock
//    private CategoriesRepository categoriesRepository;
//
//    private Categories categories=new Categories();
//    private CategoriesDTO categoriesDTO=new CategoriesDTO();
//
//    private CategoriesBuilder categoriesBuilder=new CategoriesBuilder();
//    private CategoriesDTOBuilder categoriesDTOBuilder=new CategoriesDTOBuilder();
//
//    private List<Categories> categoriesList =new ArrayList<>();
//    private List<CategoriesDTO> categoriesDTOList =new ArrayList<>();
//
//    private List<Products> productsList=new ArrayList<>();
//    private List<ProductsDTO> productsDTOList =new ArrayList<>();
//
//    @Before
//    public void setUp(){
//        categories=categoriesBuilder.id(1).name("Başlangıç").description("iç ısıtıcı").products(productsList).build();
//        categoriesDTO=categoriesDTOBuilder.id(1).name("Başlangıç").description("iç ısıtıcı").productsDTOList(productsDTOList).build();
//    }
//
//    @Test
//    public void shouldGetCategory(){
//        List<Categories> list=categoriesRepository.findAll();
//        assertNotNull(list);
//    }
//    @Test
//    public void shouldGetSelectedCategory(){
//        int id=1;
//        categoryList.add(category);
//        Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
//        CategoryDTO res = categoryService.getSelectedCategory(id);
//        CategoryDTO dto = CategoryConverter.getSelectedCategory(category);
//
//        assertEquals(res.getId(),dto.getId());
//    }
//    @Test
//    public void shouldDeleteCategory(){
//        int id=1;
//
//        List<CategoryDTO> res= categoryService.deleteCategory(id);
//
//        verify(categoryRepository,times(1)).deleteById(id);
//    }
//    @Test
//    public void shouldAddCategory(){
//        Mockito.when(categoryRepository.save(any())).thenReturn(category);
//
//        String res = categoryService.addCategory(categoryDTO);
//
//        assertNotNull(res);
//        assertEquals(res,"Category Added");
//    }
//    @Test
//    public void shouldUpdateCategory(){
//        int id=1;
//
//        Mockito.when(categoryRepository.saveAndFlush(category)).thenReturn(category);
//        CategoryDTO res=categoryService.updateCategory(categoryDTO,id);
//
//        assertEquals(res,categoryDTO);
//
//    }
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
//    @Test
//    public void shouldGetProductByCategory(){
//        int id=1;
//        productSet.add(product);
//        category.setProducts(productSet);
//        productDTOSet.add(productDTO);
//
//        Optional<Category> cat=Optional.of(category);
//        Mockito.when(categoryRepository.findById(id)).thenReturn(cat);
//        Set<ProductDTO> res = CategoryConverter.getProductByCategory(cat);
//
//        Set<ProductDTO> dtoSet=categoryService.getProductByCategory(id);
//        assertEquals(res.iterator().next().getId(),dtoSet.iterator().next().getId());
//
//
//    }


//
//}