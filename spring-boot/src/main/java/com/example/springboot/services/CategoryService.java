package com.example.springboot.services;

import com.example.springboot.dao.CategoryDao;
import com.example.springboot.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryDao categoryDao;

    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    public Category getById(int id) {
        return categoryDao.getById(id);
    }

    public Category create(Category category) {
        return categoryDao.create(category);
    }

    public Category update(Category category) {
        return categoryDao.update(category);
    }

    public Category delete(int id) {
        return categoryDao.delete(id);
    }
}
