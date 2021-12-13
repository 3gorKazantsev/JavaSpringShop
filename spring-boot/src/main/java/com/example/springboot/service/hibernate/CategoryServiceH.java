package com.example.springboot.service.hibernate;

import com.example.springboot.model.hibernate.CategoryH;
import com.example.springboot.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceH {

    private final CategoryRepository categoryRepository;

    public List<CategoryH> getAllCategory() {
        return categoryRepository.findAll();
    }

    public CategoryH getCategoryById(Integer id) {
        return categoryRepository.getById(id);
    }
}
