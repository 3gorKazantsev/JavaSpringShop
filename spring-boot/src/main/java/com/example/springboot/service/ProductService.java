package com.example.springboot.service;

import com.example.springboot.dao.ProductDao;
import com.example.springboot.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;

    public List<Product> getAllProduct() {
        return productDao.getAll();
    }

    public List<Product> getProductById(UUID id) {
        return productDao.getById(id);
    }
}
