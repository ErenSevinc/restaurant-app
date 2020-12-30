package com.controller;

import com.DTO.WaiterDTO;
import com.service.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/waiter")
public class WaiterController {

    @Autowired
    private WaiterService waiterService;

    @GetMapping("/list")
    public List<WaiterDTO> getAllWaiter(){
        return waiterService.getAllWaiter();
    }
    @GetMapping("/list/{id}")
    public WaiterDTO getWaiterById(@PathVariable int id){
        return waiterService.getWaiterById(id);
    }
    @PostMapping("/add")
    public String addWaiter(@Valid @RequestBody WaiterDTO waiterDTO){
        waiterService.addWaiter(waiterDTO);
        return "Waiter Added";
    }

    @PutMapping("/update")
    public WaiterDTO updateWaiter(@Valid @RequestBody WaiterDTO waiterDTO){
        return waiterService.updateWaiter(waiterDTO);
    }

    @DeleteMapping("/delete/{id}")
    public List<WaiterDTO> deleteWaiter(@PathVariable int id){
        return waiterService.deleteWaiter(id);
    }
}
