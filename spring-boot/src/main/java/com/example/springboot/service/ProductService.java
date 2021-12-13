package com.example.springboot.service;

import com.example.springboot.dao.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;

    public Map<UUID, List<Object>> getAllProduct() {
        return productDao.getAll();
    }

    public Map<UUID, List<Object>> getProductById(UUID id) {
        return productDao.getById(id);
    }
}
