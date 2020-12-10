package com.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.DTO.CategoryDTO;
import com.DTO.OrderDTO;
import com.DTO.ProductDTO;
import com.builder.DTOBuilder.CategoryDTOBuilder;
import com.builder.DTOBuilder.OrderDTOBuilder;
import com.builder.DTOBuilder.ProductDTOBuilder;
import com.builder.OrderBuilder;
import com.builder.ProductBuilder;
import com.converter.ProducrtConverter;
import com.entity.Category;
import com.entity.Order;
import com.entity.Product;
import com.repository.OrderRepository;
import com.repository.ProductRepository;
import com.service.BackOfficeService;
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
public class RestaurantControllerTest {
    @InjectMocks
    private RestaurantController restaurantController;
    @Mock
    private BackOfficeService service;
    private Order order=new Order();
    private OrderDTO orderDTO=new OrderDTO();
    private List<Order> orderList=new ArrayList<>();
    private List<OrderDTO> orderDTOList=new ArrayList<>();
    private Set<ProductDTO> productDTOSet=new HashSet<>();
    private  List<Product> listProduct=new ArrayList<>();
    private Product product=new Product();
    private ProductDTO productDTO = new ProductDTO();
    private Category category=new Category();
    private CategoryDTO categoryDTO=new CategoryDTO();
    private OrderBuilder orderBuilder=new OrderBuilder();
    private OrderDTOBuilder orderDTOBuilder=new OrderDTOBuilder();
    private CategoryDTOBuilder categoryDTOBuilder=new CategoryDTOBuilder();
    private ProductBuilder productBuilder=new ProductBuilder();
    private ProductDTOBuilder productDTOBuilder=new ProductDTOBuilder();

    private Set<Category> categorySet=new HashSet<>();

    @Before
    public void setUp() throws Exception{
        Date date = new Date();
        order=orderBuilder.id(1).totalPrice(10).piece(1).paymentType("cash").productId(1).tableName("SALON 1")
                .waiterName("garson1").date(date).build();
        orderDTO=orderDTOBuilder.id(1).totalPrice(10).piece(1).paymentType("cash").productId(1).tableName("SALON 1")
                .waiterName("garson1").date(date).build();
        orderList.add(order);
        orderDTOList.add(orderDTO);

        categoryDTO=categoryDTOBuilder.id(1).name("kategori").description("kategori açıklama").urlToImage("")
                .build();

        product=productBuilder.id(1).name("ürün").brand("ürün güzel").price(10).productCategory("category name").
                urlToImage("").build();

        productDTO=productDTOBuilder.id(1).name("ürün").brand("ürün güzel").price(10).productCategory("category name").
                urlToImage("").build();

    }
    @Test
    public void shouldGetAllProduct(){
        List<ProductDTO> productList =service.getAllProduct();
        assertNotNull(productList);
    }
    @Test
    public void shouldGetSelectedProduct(){
        int id=1;

        Mockito.when(service.getSelectedProduct(id)).thenReturn(productDTO);

        ProductDTO res =restaurantController.getSelectedProduct(id);

        assertNotNull(res);
    }
//    @Test
//    public void shouldDeleteProduct(){
//        int id=1;
//
//        List<ProductDTO> res = service.deleteProduct(1);
//
//        assertNotNull(res);
//    }

    @Test
    public void shouldAddOrder(){

        Mockito.when(service.addSales(any())).thenReturn("Siparişiniz Alınmıştır");

        String res = restaurantController.addSales(orderDTOList);

        assertNotNull(res);
        assertEquals(res,"Siparişiniz Alınmıştır");
    }
    @Test
    public void shouldListOrder(){

        List<OrderDTO> ordListDTO = restaurantController.listSales();
        assertNotNull(ordListDTO);
    }

}