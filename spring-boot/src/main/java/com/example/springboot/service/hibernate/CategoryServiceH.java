package com.example.springboot.service.hibernate;

import com.example.springboot.model.hibernate.CategoryH;
import com.example.springboot.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceH {

    private final CategoryRepository categoryRepository;

    // get all
    public ResponseEntity<List<CategoryH>> getAllCategory() {
        List<CategoryH> categories = categoryRepository.findAll();

        if (categories.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // get by id
    public ResponseEntity<CategoryH> getCategoryById(Integer id) {
        Optional<CategoryH> category = categoryRepository.findById(id);

        if (category.isPresent())
            return new ResponseEntity<>(category.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // create
    public ResponseEntity<CategoryH> createCategory(CategoryH category) {
        return new ResponseEntity<>(categoryRepository.save(category), HttpStatus.CREATED);
    }

    // update
    public ResponseEntity<CategoryH> updateCategory(CategoryH category) {
        if (categoryRepository.findById(category.getId()).isPresent())
            return new ResponseEntity<>(categoryRepository.save(category), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // delete
    public ResponseEntity<CategoryH> deleteCategoryById(int id) {
        try {
            categoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
