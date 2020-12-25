package com.repository;

import com.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products,Integer> {

//    @Query("SELECT p from Products p Where p.categories.size = 1 and p.deleted=false")
//    List<Products> findAllProd();
    @Override
    Page<Products> findAll(Pageable pageable);

    Slice<Products> findProductsByCategoriesId(int id,Pageable pageable);

}
