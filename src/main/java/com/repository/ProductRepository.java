package com.repository;

import com.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

//    @Query("Select DISTINCT categories from Product")
//    List<String> findAllCategory();
//
//    @Query("SELECT p from Product p Where p.categories=:categories")
//    List<Product> getCategoryProduct(String category);
//


}
