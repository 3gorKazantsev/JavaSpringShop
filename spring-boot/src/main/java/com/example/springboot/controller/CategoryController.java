package com.example.springboot.controller;

import com.example.springboot.model.hibernate.CategoryH;
import com.example.springboot.model.jdbc.Category;
import com.example.springboot.service.hibernate.CategoryServiceH;
import com.example.springboot.service.jdbc.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryServiceH categoryServiceH;

    @GetMapping()
    public ResponseEntity<List<CategoryH>> getAllCategory() {
        return categoryServiceH.getAllCategory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryH> getCategoryById(@PathVariable int id) {
        return categoryServiceH.getCategoryById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<CategoryH> createCategory(@RequestBody CategoryH category) {
        return categoryServiceH.createCategory(category);
    }

    @PostMapping("/upd")
    public ResponseEntity<CategoryH> updateCategory(@RequestBody CategoryH category) {
        return categoryServiceH.updateCategory(category);
    }

    @PostMapping("/del/{id}")
    public ResponseEntity<CategoryH> deleteCategoryById(@PathVariable int id) {
        return categoryServiceH.deleteCategoryById(id);
    }
}
