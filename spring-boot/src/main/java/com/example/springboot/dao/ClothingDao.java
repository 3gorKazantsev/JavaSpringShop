package com.example.springboot.dao;

import com.example.springboot.config.mapper.ClothingMapper;
import com.example.springboot.model.Clothing;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ClothingDao {

    private final JdbcTemplate jdbcTemplate;
    private final ClothingMapper clothingMapper;

    public List<Clothing> getAll() {
        String query =
                "SELECT \"Clothing\".id   AS clothing_id,\n" +
                        "       \"Clothing\".name AS clothing_name,\n" +
                        "       \"Clothing\".size AS clothing_size,\n" +
                        "       \"Category\".id   AS category_id,\n" +
                        "       \"Category\".name AS category_name\n" +
                        "FROM \"Clothing\"\n" +
                        "         LEFT JOIN \"Category\"\n" +
                        "                   ON \"Clothing\".category_id = \"Category\".id";
        return jdbcTemplate.query(query, clothingMapper);
    }

    public Clothing getById(int id) {
        return null;
    }

    public Clothing create(Clothing clothing) {
        return null;
    }

    public Clothing update(Clothing clothing) {
        return null;
    }

    public Clothing delete(int id) {
        return null;
    }
}
