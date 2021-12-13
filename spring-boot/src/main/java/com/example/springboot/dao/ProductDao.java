package com.example.springboot.dao;

import com.example.springboot.config.extractor.ProductExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ProductDao {

    private final JdbcTemplate jdbcTemplate;
    private final ProductExtractor productExtractor;

    public Map<UUID, List<Object>> getAll() {
        String query = """
                SELECT  "Clothing".id   AS id,
                        "Clothing".name AS name,
                        "Category".id   AS category_id,
                        "Category".name AS category_name,
                        "Clothing".size AS size
                               FROM "Clothing"
                                        LEFT JOIN "Category"
                                                  ON "Clothing".category_id = "Category".id
                UNION
                SELECT  "Footwear".id   AS id,
                        "Footwear".name AS name,
                        "Category".id   AS category_id,
                        "Category".name AS category_name,
                        "Footwear".size::varchar AS size
                               FROM "Footwear"
                                        LEFT JOIN "Category"
                                                  ON "Footwear".category_id = "Category".id
                """;
        return jdbcTemplate.query(query, productExtractor);
    }

    public Map<UUID, List<Object>> getById(UUID id) {
        String query = """
                SELECT "Clothing".id   AS id,
                       "Clothing".name AS name,
                       "Category".id   AS category_id,
                       "Category".name AS category_name,
                       "Clothing".size AS size
                FROM "Clothing"
                         LEFT JOIN "Category"
                                   ON "Clothing".category_id = "Category".id
                WHERE "Clothing".id = ?
                UNION
                SELECT "Footwear".id            AS id,
                       "Footwear".name          AS name,
                       "Category".id            AS category_id,
                       "Category".name          AS category_name,
                       "Footwear".size::varchar AS size
                FROM "Footwear"
                         LEFT JOIN "Category"
                                   ON "Footwear".category_id = "Category".id
                WHERE "Footwear".id = ?;
                """;
        return jdbcTemplate.query(query, productExtractor, id, id);
    }
}
