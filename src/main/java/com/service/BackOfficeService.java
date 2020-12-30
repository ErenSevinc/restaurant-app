package com.service;

import com.DTO.OrderDTO;
import com.mapper.OrderMapper;
import com.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BackOfficeService {
    @Autowired
    OrderRepository orderRepository;

    @Transactional
    public String addSales(List<OrderDTO> orderDTO){
        orderRepository.saveAll(OrderMapper.INSTANCE.toEntity(orderDTO));
        return "Siparişiniz Alınmıştır";
    }

    public List<OrderDTO> listSales(){
    return OrderMapper.INSTANCE.toDTO(orderRepository.findAll());
    }


}
