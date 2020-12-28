package com.unused;

//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Matchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.internal.verification.VerificationModeFactory.times;
//
//@RunWith(MockitoJUnitRunner.class)
//public class CategoryControllerTest {
//    @InjectMocks
//    private CategoryController categoryController;
//
//    @Mock
//    private BackOfficeService service;
//    private Product product=new Product();
//    private ProductDTO productDTO=new ProductDTO();
//
//    @Mock
//    private CategoryService categoryService;
//
//    private Category category=new Category();
//    private CategoryDTO categoryDTO=new CategoryDTO();
//
//    private List<Category> categoryList =new ArrayList<>();
//    private List<CategoryDTO> categoryDTOList =new ArrayList<>();
//
//    private Set<Product> productSet=new HashSet<>();
//    private Set<ProductDTO> productDTOSet =new HashSet<>();
//
//    @Before
//    public void setUp(){
//        category.setId(1);
//        category.setName("Başlangıç");
//        category.setDescription("iç ısıtıcı");
//        category.setUrlToImage("");
//        category.setProducts(productSet);
//
//        categoryDTO.setId(1);
//        categoryDTO.setName("Başlangıç");
//        categoryDTO.setDescription("iç ısıtıcı");
//        categoryDTO.setUrlToImage("");
//        categoryDTO.setProducts(productSet);
//
//    }
//
//}