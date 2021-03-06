//package com.controller;
//
//import com.entity.RestaurantTable;
//import com.service.RestaurantTableService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/restaurantTable")
//public class RestaurantTableController {
//    @Autowired
//    RestaurantTableService repository;
//
//
//    @PostMapping("/add/{id}")
//    public void addProduct(@RequestBody RestaurantTable table, @PathVariable int id) {
//        repository.addRestaurantId(table, id);
//    }
//    @GetMapping("/list")
//    public List<RestaurantTable> getAllTable() {
//        return repository.getAllRestaurantTable();
//    }
//    @DeleteMapping("/delete/{id}")
//    public List<RestaurantTable> deleteTable(@PathVariable int id) {
//        return repository.deleteRestaurantTable(id);
//    }
//    @PutMapping("/update/{id}")
//    public List<RestaurantTable> updateTable(@PathVariable int id, @RequestBody RestaurantTable table) {
//        return repository.updateRestaurantTable(id, table);
//    }
//    @GetMapping("/list/{id}")
//    public Optional<RestaurantTable> getTableById(@PathVariable int id){
//        return repository.getTableById(id);    }
//
//}
