package com.example.springboot.service.jdbc;

import com.example.springboot.dao.CategoryDao;
import com.example.springboot.model.jdbc.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryDao categoryDao;

    public List<Category> getAllCategory() {
        return categoryDao.getAll();
    }

    public Category getCategoryById(int id) {
        return categoryDao.getById(id);
    }

    public Category createCategory(Category category) {
        return categoryDao.create(category);
    }

    public Category updateCategory(Category category) {
        return categoryDao.update(category);
    }

    public Category deleteCategoryById(int id) {
        return categoryDao.deleteById(id);
    }
}
