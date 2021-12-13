package com.example.springboot.config.mapper;

import com.example.springboot.model.jdbc.Category;
import com.example.springboot.model.jdbc.Footwear;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class FootwearMapper implements RowMapper<Footwear> {

    @Override
    public Footwear mapRow(ResultSet rs, int rowNum) throws SQLException {

        UUID id = rs.getObject("footwear_id", java.util.UUID.class);
        String name = rs.getString("footwear_name");
        int categoryId = rs.getInt("category_id");
        String categoryName = rs.getString("category_name");
        int size = rs.getInt("footwear_size");

        return new Footwear(id, name, new Category(categoryId, categoryName), size);
    }
}
