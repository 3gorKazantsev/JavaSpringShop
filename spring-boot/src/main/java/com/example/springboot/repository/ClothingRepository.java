package com.example.springboot.repository;

import com.example.springboot.model.hibernate.ClothingH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClothingRepository extends JpaRepository<ClothingH, UUID> {
}
