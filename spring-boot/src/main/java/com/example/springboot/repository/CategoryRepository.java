package com.example.springboot.repository;

import com.example.springboot.model.hibernate.CategoryH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryH, Integer> {

    @Query("SELECT COUNT(c) FROM CategoryH c WHERE c.name='HI'")
    int getCategoryCountWithNameHi();

    List<CategoryH> findByNameEquals(String name);
}
