package com.example.springboot.services;

import com.example.springboot.data.Data;
import com.example.springboot.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    public List<Product> getAllProducts() {
        return Data.products;
    }

    public Product findProductById(String id) {
        Product product = null;

        // поиск товара с указанным ID в списке товаров
        for (Product p : Data.products) {
            if (p.getId().equals(UUID.fromString(id)))
                product = p;
        }

        return product;
    }

    public List<Product> getProductsByType(int typeId) {
        ArrayList<Product> products = new ArrayList<>();

        for (Product p : Data.products) {
            if (p.getCategory().getId() == typeId)
                products.add(p);
        }

        return products;
    }
}
