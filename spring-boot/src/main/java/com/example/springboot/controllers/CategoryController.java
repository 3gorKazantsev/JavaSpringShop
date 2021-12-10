package com.example.springboot.controllers;

import com.example.springboot.model.Category;
import com.example.springboot.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/type")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable int id) {
        return categoryService.getById(id);
    }

    @PostMapping("/new")
    public Category createType(@RequestBody Category category) {
        return categoryService.create(category);
    }

    @PostMapping("/update")
    public Category updateType(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @PostMapping("/del/{id}")
    public Category deleteType(@PathVariable int id) {
        return categoryService.delete(id);
    }
}
