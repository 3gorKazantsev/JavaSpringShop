package com.example.springboot.config.extractor;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component
public class ProductExtractor implements ResultSetExtractor<Map<UUID, List<Object>>> {

    @Override
    public Map<UUID, List<Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<UUID, List<Object>> result = new HashMap<>();

        while(rs.next()) {
            UUID id = rs.getObject("id", UUID.class);
            result.putIfAbsent(id, new LinkedList<>());
            result.get(id).add(rs.getString("name"));
            result.get(id).add(rs.getInt("category_id"));
            result.get(id).add(rs.getString("category_name"));
            result.get(id).add(rs.getString("size"));
        }

        return result;
    }
}
