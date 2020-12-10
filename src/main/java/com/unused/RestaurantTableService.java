//package com.service;
//
//import com.entity.CategoryTable;
//import com.entity.RestaurantTable;
//import com.repository.CategoryTableRepository;
//import com.repository.RestaurantTableRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class RestaurantTableService {
//    @Autowired
//    RestaurantTableRepository repository;
//
//    @Autowired
//    CategoryTableRepository categoryTablerepository;
//
//
//    public List<RestaurantTable> getAllRestaurantTable() {
//        repository.findAll();
//        return repository.findAll();
//    }
//    public List<RestaurantTable> deleteRestaurantTable(int id) {
//        repository.deleteById(id);
//        return repository.findAll();
//    }
//
//    public List<RestaurantTable> updateRestaurantTable(int id, RestaurantTable table) {
//        Optional<RestaurantTable> optional = repository.findAll().stream().filter(news1 -> news1.getId() == id).findAny();
//        if (optional == null) {
//            System.out.println("girilen ID  bulunamadı!");
//            return null;
//        }
//        optional.get().setNumber(table.getNumber());
//        optional.get().setCategory(table.getCategory());
//        repository.save(optional.get());
//        return repository.findAll();
//    }
//    public void addRestaurantId(RestaurantTable table,int id){
//        Optional<CategoryTable> category =categoryTablerepository.findById(id);
//        category.get().getTables().add(table);
//        categoryTablerepository.save(category.get());
//    }
//    public Optional<RestaurantTable> getTableById(int id) {
//
//        return repository.findById(id);
//    }
//}
