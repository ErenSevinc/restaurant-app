package com.service;

//import com.builder.DTOBuilder.CategoryDTOBuilder;
//import com.builder.DTOBuilder.OrderDTOBuilder;
//import com.builder.DTOBuilder.ProductDTOBuilder;
//import com.builder.OrderBuilder;
//import com.builder.ProductBuilder;
import com.DTO.OrderDTO;
import com.builder.DTOBuilder.OrderDTOBuilder;
import com.builder.OrderBuilder;
import com.mapper.OrderMapper;
import com.repository.OrderRepository;
import com.entity.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BackOfficeServiceTest {
    @InjectMocks
    private BackOfficeService service;

    @Mock
    private OrderRepository orderRepository;
    private Order order=new Order();
    private OrderDTO orderDTO=new OrderDTO();
    private List<Order> orderList=new ArrayList<>();
    private List<OrderDTO> orderDTOList=new ArrayList<>();
    private OrderBuilder orderBuilder = new OrderBuilder();
    private OrderDTOBuilder orderDTOBuilder = new OrderDTOBuilder();
//    @Mock
//    private ProductRepository productRepository;
//    private Set<ProductDTO> productDTOSet=new HashSet<>();
//    private  List<Product> listProduct=new ArrayList<>();
//    private Product product=new Product();
//    private ProductDTO productDTO = new ProductDTO();
//
//    private ProductBuilder productBuilder=new ProductBuilder();
//    private ProductDTOBuilder productDTOBuilder=new ProductDTOBuilder();
//
//    private Category category=new Category();
//    private CategoryDTO categoryDTO=new CategoryDTO();
//
//    private CategoryDTOBuilder categoryDTOBuilder=new CategoryDTOBuilder();


    @Before
    public void setUp() throws Exception{
        Date date = new Date();
        order=orderBuilder.id(1).totalPrice(10).piece(1).paymentType("cash").productId(1).tableName("SALON 1").date(date).build();
        orderDTO=orderDTOBuilder.id(1).totalPrice(10).piece(1).paymentType("cash").productId(1).tableName("SALON 1").date(date).build();

        orderList.add(order);
        orderDTOList.add(orderDTO);

//        categoryDTO=categoryDTOBuilder.id(1).name("kategori").description("kategori açıklama").urlToImage("").build();
//
//        product=productBuilder.id(1).name("ürün").brand("ürün güzel").price(10).productCategory("category name").urlToImage("").build();
//
//        productDTO=productDTOBuilder.id(1).name("ürün").brand("ürün güzel").price(10).productCategory("category name").urlToImage("").build();

    }

    @Test
    public void shouldAddOrder(){

        Mockito.when(orderRepository.saveAll(OrderMapper.INSTANCE.toEntity(any()))).thenReturn(orderList);

        String res = service.addSales(orderDTOList);

        assertNotNull(res);
        assertEquals(res,"Siparişiniz Alınmıştır");
    }
    @Test
    public void shouldListOrder(){

        List<OrderDTO> ordListDTO = service.listSales();
        assertNotNull(ordListDTO);
    }
//
//    @Test
//    public void shouldGetAllProduct(){
//        List<Product> productList =productRepository.findAll();
//        assertNotNull(productList);
//    }
//
////    @Test
////    public void shouldDeleteProduct(){
////        int id=1;
////
////        List<ProductDTO> res = service.deleteProduct(1);
////
////        verify(productRepository,times(1)).deleteById(id);
////    }
//    @Test
//    public void shouldGetSelectedProduct(){
//        int id=1;
//
//        listProduct.add(product);
//        Mockito.when(productRepository.findAll()).thenReturn(listProduct);
//
//        ProductDTO res =service.getSelectedProduct(id);
//        ProductDTO dto = ProducrtConverter.getSelectedProduct(product);
//
//        assertEquals(res.getId(),dto.getId());
//
//    }
//
////    @Test
////    public void shouldUpdateProduct(){
////
////    }
//
//
//

}