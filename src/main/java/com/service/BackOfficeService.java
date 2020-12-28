package com.service;

import com.DTO.OrderDTO;
import com.mapper.OrderMapper;
import com.unused.ProductDTO;
import com.converter.OrderConverter;
import com.unused.ProducrtConverter;
import com.unused.Product;
import com.unused.CategoryRepository;
import com.repository.OrderRepository;
import com.unused.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.entity.Order;

@Service
public class BackOfficeService {
    private List<Product> productList=new ArrayList<>();

    @Autowired
    ProductRepository repository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public String addSales(List<OrderDTO> orderDTO){


        orderRepository.saveAll(OrderMapper.INSTANCE.toEntity(orderDTO));
        return "Siparişiniz Alınmıştır";
    }

    public List<OrderDTO> listSales(){
    return OrderMapper.INSTANCE.toDTO(orderRepository.findAll());
    }


}
