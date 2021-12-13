package com.example.springboot.dao;

import com.example.springboot.config.mapper.FootwearMapper;
import com.example.springboot.model.jdbc.Footwear;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class FootwearDao {

    private final JdbcTemplate jdbcTemplate;
    private final FootwearMapper footwearMapper;

    public List<Footwear> getAll() {
        String query = """
                SELECT "Footwear".id   AS footwear_id,
                       "Footwear".name AS footwear_name,
                       "Category".id   AS category_id,
                       "Category".name AS category_name,
                       "Footwear".size AS footwear_size
                FROM "Footwear"
                         LEFT JOIN "Category"
                                   ON "Footwear".category_id = "Category".id""";
        return jdbcTemplate.query(query, footwearMapper);
    }

    public Footwear getById(UUID id) {
        String query = """
                SELECT "Footwear".id   AS footwear_id,
                       "Footwear".name AS footwear_name,
                       "Category".id   AS category_id,
                       "Category".name AS category_name,
                       "Footwear".size AS footwear_size
                FROM "Footwear"
                         LEFT JOIN "Category"
                                   ON "Footwear".category_id = "Category".id
                WHERE "Footwear".id = ?""";
        return jdbcTemplate.queryForObject(query, footwearMapper, id);
    }

    public Footwear create(Footwear footwear) {
        String query = "INSERT INTO \"Footwear\" (name, category_id, size) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, footwear.getName(), footwear.getCategory().getId(), footwear.getSize());
        return footwear;
    }

    public Footwear update(Footwear footwear) {
        String query = "UPDATE \"Footwear\" SET name=?, category_id=?, size=? WHERE id=?";
        jdbcTemplate.update(query, footwear.getName(), footwear.getCategory().getId(), footwear.getSize(), footwear.getId());
        return footwear;
    }

    public Footwear delete(UUID id) {
        Footwear deletedFootwear = this.getById(id);
        String query = "DELETE FROM \"Footwear\" WHERE id=?";
        jdbcTemplate.update(query, id);
        return deletedFootwear;
    }
}

