package com.controller;

import com.DTO.OrderDTO;
import com.service.BackOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class RestaurantController {

    @Autowired
    private BackOfficeService service;

    //basket complete
    @PostMapping("/basket")
    public String addSales(@Valid @RequestBody List<OrderDTO> list){
        service.addSales(list);
        return "Siparişiniz Alınmıştır";
    }

    @GetMapping("/basket/list")
    public List<OrderDTO> listSales(){
        return service.listSales();
    }

}
