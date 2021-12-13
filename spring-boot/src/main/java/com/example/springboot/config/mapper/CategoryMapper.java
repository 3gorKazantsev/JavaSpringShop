package com.example.springboot.config.mapper;

import com.example.springboot.model.jdbc.Category;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CategoryMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {

        int id = rs.getInt("id");
        String name = rs.getString("name");

        return new Category(id, name);
    }
}
