package com.controller;

import com.DTO.OrderDTO;
import com.unused.ProductDTO;
import com.unused.Product;
import com.service.BackOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class RestaurantController {

    @Autowired
    private BackOfficeService service;

    //basket complete
    @PostMapping("/basket")
    public String addSales(@RequestBody List<OrderDTO> list){
        service.addSales(list);
        return "Siparişiniz Alınmıştır";
    }

    @GetMapping("/basket/list")
    public List<OrderDTO> listSales(){
        return service.listSales();
    }

}
