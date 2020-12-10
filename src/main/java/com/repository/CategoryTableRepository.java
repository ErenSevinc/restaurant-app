package com.repository;

import com.entity.CategoryTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryTableRepository extends JpaRepository<CategoryTable,Integer> {
}
