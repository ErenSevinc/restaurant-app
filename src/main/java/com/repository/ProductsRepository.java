package com.repository;

import com.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products,Integer> {
}
