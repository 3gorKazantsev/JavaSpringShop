package com.example.springboot.dao;

import com.example.springboot.mappers.TypeMapper;
import com.example.springboot.model.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TypeDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Type> getAllTypes() {
        String query = "SELECT * FROM type";
        return jdbcTemplate.query(query, new TypeMapper());
    }

    public Type findTypeById(int id) {
        String query = "SELECT * FROM type WHERE id=?";
        return jdbcTemplate.queryForObject(query, new TypeMapper(), id);
    }
}