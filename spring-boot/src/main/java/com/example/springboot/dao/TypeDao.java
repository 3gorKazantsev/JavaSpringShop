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

    public List<Type> getAll() {
        String query = "SELECT * FROM type";
        return jdbcTemplate.query(query, new TypeMapper());
    }

    public Type getById(int id) {
        String query = "SELECT * FROM type WHERE id=?";
        return jdbcTemplate.queryForObject(query, new TypeMapper(), id);
    }

    public Type create(Type type) {
        String query = "INSERT INTO type(name) VALUES(?) ";
        jdbcTemplate.update(query, type.getName());
        return type;
    }

    public Type update(Type type) {
        String query = "UPDATE type SET name=? WHERE id=?";
        jdbcTemplate.update(query, type.getName(), type.getId());
        return type;
    }

    public Type delete(int id) {
        Type deletedType = this.getById(id);
        String query = "DELETE FROM type WHERE id=?";
        jdbcTemplate.update(query, id);
        return deletedType;
    }
}