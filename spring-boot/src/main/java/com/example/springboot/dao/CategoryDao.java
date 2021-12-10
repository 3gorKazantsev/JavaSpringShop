package com.example.springboot.dao;

import com.example.springboot.mappers.CategoryMapper;
import com.example.springboot.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Category> getAll() {
        String query = "SELECT * FROM \"Category\" ORDER BY id";
        return jdbcTemplate.query(query, new CategoryMapper());
    }

    public Category getById(int id) {
        String query = "SELECT * FROM \"Category\" WHERE id=?";
        return jdbcTemplate.queryForObject(query, new CategoryMapper(), id);
    }

    public Category create(Category category) {
        String query = "INSERT INTO \"Category\"(name) VALUES(?) ";
        jdbcTemplate.update(query, category.getName());
        return category;
    }

    public Category update(Category category) {
        String query = "UPDATE \"Category\" SET name=? WHERE id=?";
        jdbcTemplate.update(query, category.getName(), category.getId());
        return category;
    }

    public Category delete(int id) {
        Category deletedCategory = this.getById(id);
        String query = "DELETE FROM \"Category\" WHERE id=?";
        jdbcTemplate.update(query, id);
        return deletedCategory;
    }
}