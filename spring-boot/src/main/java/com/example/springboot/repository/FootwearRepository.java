package com.example.springboot.repository;

import com.example.springboot.model.hibernate.FootwearH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FootwearRepository extends JpaRepository<FootwearH, UUID> {
}
