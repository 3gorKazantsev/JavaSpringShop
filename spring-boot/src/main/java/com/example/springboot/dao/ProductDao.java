package com.example.springboot.dao;

import com.example.springboot.config.mapper.ProductMapper;
import com.example.springboot.model.jdbc.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ProductDao {

    private final JdbcTemplate jdbcTemplate;
    private final ProductMapper productMapper;

    public List<Product> getAll() {
        String query = """
                SELECT  "Clothing".id   AS p_id,
                        "Clothing".name AS p_name,
                        "Category".id   AS c_id,
                        "Category".name AS c_name,
                        "Clothing".size AS p_size
                               FROM "Clothing"
                                        LEFT JOIN "Category"
                                                  ON "Clothing".category_id = "Category".id
                UNION
                SELECT  "Footwear".id   AS p_id,
                        "Footwear".name AS p_name,
                        "Category".id   AS c_id,
                        "Category".name AS c_name,
                        "Footwear".size::varchar AS p_size
                               FROM "Footwear"
                                        LEFT JOIN "Category"
                                                  ON "Footwear".category_id = "Category".id
                """;
        return jdbcTemplate.query(query, productMapper);
    }

    public List<Product> getById(UUID id) {
        String query = """
                SELECT "Clothing".id   AS p_id,
                       "Clothing".name AS p_name,
                       "Category".id   AS c_id,
                       "Category".name AS c_name,
                       "Clothing".size AS p_size
                FROM "Clothing"
                         LEFT JOIN "Category"
                                   ON "Clothing".category_id = "Category".id
                WHERE "Clothing".id = ?
                UNION
                SELECT "Footwear".id            AS p_id,
                       "Footwear".name          AS p_name,
                       "Category".id            AS c_id,
                       "Category".name          AS c_name,
                       "Footwear".size::varchar AS p_size
                FROM "Footwear"
                         LEFT JOIN "Category"
                                   ON "Footwear".category_id = "Category".id
                WHERE "Footwear".id = ?;
                """;
        return jdbcTemplate.query(query,productMapper, id, id);
    }
}
