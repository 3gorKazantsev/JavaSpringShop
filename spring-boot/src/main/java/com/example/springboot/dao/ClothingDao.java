package com.example.springboot.dao;

import com.example.springboot.config.mapper.ClothingMapper;
import com.example.springboot.model.Clothing;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ClothingDao {

    private final JdbcTemplate jdbcTemplate;
    private final ClothingMapper clothingMapper;

    public List<Clothing> getAll() {
        String query = """
                SELECT "Clothing".id   AS clothing_id,
                       "Clothing".name AS clothing_name,
                       "Category".id   AS category_id,
                       "Category".name AS category_name,
                       "Clothing".size AS clothing_size
                FROM "Clothing"
                         LEFT JOIN "Category"
                                   ON "Clothing".category_id = "Category".id""";
        return jdbcTemplate.query(query, clothingMapper);
    }

    public Clothing getById(UUID id) {
        String query = """
                SELECT "Clothing".id   AS clothing_id,
                       "Clothing".name AS clothing_name,
                       "Category".id   AS category_id,
                       "Category".name AS category_name,
                       "Clothing".size AS clothing_size
                FROM "Clothing"
                         LEFT JOIN "Category"
                                   ON "Clothing".category_id = "Category".id
                WHERE "Clothing".id = ?""";
        return jdbcTemplate.queryForObject(query, clothingMapper, id);
    }

    public Clothing create(Clothing clothing) {
        String query = "INSERT INTO \"Clothing\" (name, category_id, size) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, clothing.getName(), clothing.getCategory().getId(), clothing.getSize());
        return clothing;
    }

    public Clothing update(Clothing clothing) {
        String query = "UPDATE \"Clothing\" SET name=?, category_id=?, size=? WHERE id=?";
        jdbcTemplate.update(query, clothing.getName(), clothing.getCategory().getId(), clothing.getSize(), clothing.getId());
        return clothing;
    }

    public Clothing deleteById(UUID id) {
        Clothing deletedClothing = this.getById(id);
        String query = "DELETE FROM \"Clothing\" WHERE id=?";
        jdbcTemplate.update(query, id);
        return deletedClothing;
    }
}
