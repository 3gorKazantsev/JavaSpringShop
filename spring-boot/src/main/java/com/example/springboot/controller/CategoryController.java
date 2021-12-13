package com.example.springboot.controller;

import com.example.springboot.model.hibernate.CategoryH;
import com.example.springboot.model.jdbc.Category;
import com.example.springboot.service.hibernate.CategoryServiceH;
import com.example.springboot.service.jdbc.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryServiceH categoryServiceH;

    @GetMapping()
    public List<CategoryH> getAllCategory() {
        return categoryServiceH.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryH getCategoryById(@PathVariable int id) {
        return categoryServiceH.getCategoryById(id);
    }

    @PostMapping("/new")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PostMapping("/upd")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @PostMapping("/del/{id}")
    public Category deleteCategoryById(@PathVariable int id) {
        return categoryService.deleteCategoryById(id);
    }
}
