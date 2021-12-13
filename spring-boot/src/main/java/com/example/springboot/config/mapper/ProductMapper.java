package com.example.springboot.config.mapper;

import com.example.springboot.model.jdbc.Category;
import com.example.springboot.model.jdbc.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

        UUID id = rs.getObject("p_id", UUID.class);
        String name = rs.getString("p_name");
        int cId = rs.getInt("c_id");
        String cName = rs.getString("c_name");
        String size = rs.getString("p_size");

        return new Product(id, name, new Category(cId, cName), size);
    }
}
