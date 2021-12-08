package com.example.springboot.mappers;

import com.example.springboot.model.Type;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeMapper implements RowMapper<Type> {
    @Override
    public Type mapRow(ResultSet rs, int rowNum) throws SQLException {

        int id = rs.getInt("id");
        String name = rs.getString("name");

        return new Type(id, name);
    }
}
