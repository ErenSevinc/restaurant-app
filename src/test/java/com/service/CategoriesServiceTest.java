package com.service;

import com.DTO.CategoriesDTO;
import com.DTO.MediaDTO;
import com.DTO.ProductsDTO;
import com.builder.CategoriesBuilder;
import com.builder.DTOBuilder.CategoriesDTOBuilder;
import com.builder.DTOBuilder.MediaDTOBuilder;
import com.builder.MediaBuilder;
import com.converter.CategoriesDTOConverter;
import com.entity.Categories;
import com.entity.Media;
import com.entity.Products;
import com.mapper.CategoriesMapper;
import com.repository.CategoriesRepository;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CategoriesServiceTest {

    @InjectMocks
    private CategoriesService categoriesService;

    @Mock
    private CategoriesMapper categoriesMapper;
    @Mock
    private ProductsService productsRepository;
    private Products products = new Products();
    private ProductsDTO productsDTO = new ProductsDTO();

    @Mock
    private CategoriesRepository categoriesRepository;
    private MediaRepository mediaRepository;

    private Categories categories = new Categories();
    private CategoriesDTO categoriesDTO = new CategoriesDTO();

    private CategoriesBuilder categoriesBuilder = new CategoriesBuilder();
    private CategoriesDTOBuilder categoriesDTOBuilder = new CategoriesDTOBuilder();

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
    }
    @Test
    public void shouldGetCategories(){

        Mockito.when(categoriesRepository.findAll()).thenReturn(categoriesList);

        List<CategoriesDTO> dtoList=categoriesMapper.toDTOList(categoriesList);
        List<CategoriesDTO> res=categoriesService.listCategories();

        assertNotNull(res);
        assertEquals(res,dtoList);
    }

    @Test
    public void shouldGetSelectedCategories(){
        int id=1;
        Mockito.when(categoriesRepository.findById(any())).thenReturn(Optional.of(CategoriesDTOConverter.categoriesDTOConvertToCategories(categoriesDTO)));

        CategoriesDTO res=categoriesService.listCategoriesById(id);


        assertEquals(res.getId(),categoriesDTO.getId());
    }

    @Test
    public void shouldAddCategories(){
        Mockito.when(categoriesRepository.save(any())).thenReturn(CategoriesDTOConverter.categoriesDTOConvertToCategories(categoriesDTO));

        CategoriesDTO res= categoriesService.addCategories(categoriesDTO);

        assertEquals(res.getId(),categoriesDTO.getId());

    }
    @Test
    public void shouldDeleteCategories(){
        int id=1;
        Mockito.when(categoriesRepository.findById(any())).thenReturn(Optional.of(CategoriesDTOConverter.categoriesDTOConvertToCategories(categoriesDTO)));

        String res=categoriesService.deleteCategories(id);

        assertEquals(res,"Categories Deleted");

    }

    @Test
    public void shouldUpdateCategories(){
        Mockito.when(categoriesRepository.findById(any())).thenReturn(Optional.of(CategoriesDTOConverter.categoriesDTOConvertToCategories(categoriesDTO)));
        Mockito.when(categoriesRepository.saveAndFlush(any())).thenReturn(CategoriesDTOConverter.categoriesDTOConvertToCategories(categoriesDTO));

        CategoriesDTO res=categoriesService.updateCategories(categoriesDTO);

        assertEquals(res.getId(),categoriesDTO.getId());
    }
}