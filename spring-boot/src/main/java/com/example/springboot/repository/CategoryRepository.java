package com.example.springboot.repository;

import com.example.springboot.model.hibernate.CategoryH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryH, Integer> {
}
