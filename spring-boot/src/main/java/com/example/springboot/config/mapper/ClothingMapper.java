package com.example.springboot.config.mapper;

import com.example.springboot.model.Category;
import com.example.springboot.model.Clothing;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class ClothingMapper implements RowMapper<Clothing> {
    @Override
    public Clothing mapRow(ResultSet rs, int rowNum) throws SQLException {

        UUID id = rs.getObject("clothing_id", java.util.UUID.class);
        String name = rs.getString("clothing_name");
        int categoryId = rs.getInt("category_id");
        String categoryName = rs.getString("category_name");
        String size = rs.getString("clothing_size");

        return new Clothing(id, name, new Category(categoryId, categoryName), size);
    }
}
