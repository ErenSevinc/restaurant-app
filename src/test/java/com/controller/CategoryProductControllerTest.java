package com.controller;

import com.DTO.CategoriesDTO;
import com.DTO.MediaDTO;
import com.DTO.ProductsDTO;
import com.builder.CategoriesBuilder;
import com.builder.DTOBuilder.CategoriesDTOBuilder;
import com.builder.DTOBuilder.MediaDTOBuilder;
import com.builder.DTOBuilder.ProductsDTOBuilder;
import com.builder.MediaBuilder;
import com.builder.ProductsBuilder;
import com.entity.Categories;
import com.entity.Media;
import com.entity.Products;
import com.repository.MediaRepository;
import com.service.CategoriesService;
import com.service.ProductsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
@RunWith(MockitoJUnitRunner.class)
public class CategoryProductControllerTest {
    @InjectMocks
    private CategoryProductController categoryProductController;

    @Mock
    private ProductsService productsService;
    private Products products = new Products();
    private ProductsDTO productsDTO = new ProductsDTO();

    @Mock
    private CategoriesService categoriesService;
    private MediaRepository mediaRepository;

    private Categories categories = new Categories();
    private CategoriesDTO categoriesDTO = new CategoriesDTO();

    private CategoriesBuilder categoriesBuilder = new CategoriesBuilder();
    private CategoriesDTOBuilder categoriesDTOBuilder = new CategoriesDTOBuilder();

    private ProductsBuilder productsBuilder=new ProductsBuilder();
    private ProductsDTOBuilder productsDTOBuilder=new ProductsDTOBuilder();

    private List<Categories> categoriesList = new ArrayList<>();
    private List<CategoriesDTO> categoriesDTOList = new ArrayList<>();

    private List<Products> productsList = new ArrayList<>();
    private List<ProductsDTO> productsDTOList = new ArrayList<>();


    private Media media=new Media();
    private MediaDTO mediaDTO=new MediaDTO();

    private MediaBuilder mediaBuilder=new MediaBuilder();
    private MediaDTOBuilder mediaDTOBuilder=new MediaDTOBuilder();
    byte [] b ={ (byte)0xe0, 0x4f, (byte)0xd0,
            0x20, (byte)0xea, 0x3a, 0x69, 0x10, (byte)0xa2, (byte)0xd8, 0x08, 0x00, 0x2b,
            0x30, 0x30, (byte)0x9d };

    private List<Media> list =new ArrayList<>();
    byte[] json = "{\"name\":\"yeeeah\"}".getBytes(StandardCharsets.UTF_8);
    MockMultipartFile file = new MockMultipartFile
            ("json", "json", "application/json", json);


    @Before
    public void setUp() {
        media=mediaBuilder.id(1).name("resim").fileContext(b).build();
        mediaDTO=mediaDTOBuilder.id(1).name("resim").fileContent(b).build();

        categories = categoriesBuilder.id(1).name("Başlangıç").description("iç ısıtıcı").products(productsList).media(media).build();
        categoriesDTO = categoriesDTOBuilder.id(1).name("Başlangıç").description("iç ısıtıcı").productsDTOList(productsDTOList).mediaDTO(mediaDTO).build();
        categoriesDTOList.add(categoriesDTO);

        products = (Products) productsBuilder.id(1).name("corba").brand("sıcak").media(media).categoriesList(categoriesList).build();
        productsDTO = (ProductsDTO) productsDTOBuilder.id(1).name("corba").brand("sıcak").mediaDTO(mediaDTO).categoriesDTOList(categoriesDTOList).build();
    }
    @Test
    public void shouldGetAllCategories(){
        List<CategoriesDTO> categoriesDTOList=categoriesService.listCategories();
        assertNotNull(categoriesDTOList);
    }
    @Test
    public void shouldGSelectedCategories(){
        int id=1;
        Mockito.when(categoriesService.listCategoriesById(id)).thenReturn(categoriesDTO);

        CategoriesDTO res=categoryProductController.listCategoriesById(id);

        assertNotNull(res);
    }
    @Test
    public void shouldAddCategories(){
        Mockito.when(categoriesService.addCategories(any())).thenReturn(categoriesDTO);

        String res= categoryProductController.addCategories(categoriesDTO);

        assertNotNull(res);
        assertEquals(res,"Categories Added");
    }
    @Test
    public void shouldDeleteCategories(){
        int id=1;

        String res=categoryProductController.deleteCategories(id);

        assertEquals(res,"Categories Deleted");
    }
    @Test
    public void shouldUpdateCategories(){
        Mockito.when(categoriesService.updateCategories(categoriesDTO)).thenReturn(categoriesDTO);
        String res=categoryProductController.updateCategories(categoriesDTO);

        assertNotNull(res);
        assertEquals(res,"Categories Updated");
    }
    @Test
    public void shouldListProducts(){
        List<ProductsDTO> productsDTOList=productsService.listProducts();
        assertNotNull(productsDTOList);
    }
    @Test
    public void shouldGetSelectedProducts(){
        int id=1;
        Mockito.when(productsService.listProductsById(id)).thenReturn(productsDTO);

        ProductsDTO res=categoryProductController.listProductsById(id);

        assertNotNull(res);
    }
    @Test
    public void shouldAddProducts(){
        Mockito.when(productsService.addProducts(any())).thenReturn(productsDTO);

        ProductsDTO res= categoryProductController.addProducts(productsDTO);

        assertNotNull(res);
        assertEquals(res,productsDTO);
    }
//    @Test
//    public void shouldUpdateProducts(){
//        Mockito.when(productsService.updateProducts(any())).thenReturn(productsDTO);
//        ProductsDTO res= categoryProductController.updateProducts(productsDTO);
//
//        assertNotNull(res);
//        assertEquals(res,productsDTO);
//    }
    @Test
    public void shouldDeleteProducts(){
        int id=1;

        String res=categoryProductController.deleteProducts(id);

        assertEquals(res,"Products Deleted");
    }
    @Test
    public void shouldListProductsByCategories(){
        int id=1;
        List<ProductsDTO> productsDTOList=productsService.getProductsByCategories(id);
        assertNotNull(productsDTOList);

    }



}