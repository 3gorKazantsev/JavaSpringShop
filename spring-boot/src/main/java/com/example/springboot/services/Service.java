package com.example.springboot.services;

import com.example.springboot.Data.Data;
import com.example.springboot.model.Product;
import com.example.springboot.model.Type;

import java.util.List;
import java.util.UUID;

public class Service {

    public static List<Product> getAllProducts() {
        return Data.products;
    }

    public static Product findProductById(String id) {
        Product product = null;

        // поиск товара с указанным ID в списке товаров
        for (Product p : Data.products) {
            if (p.getId().equals(UUID.fromString(id)))
                product = p;
        }

        return product;
    }

    public static List<Type> getAllTypes() {
        return Data.types;
    }

    public static Type findTypeById(String id) {
        Type type = null;

        // поиск типа с указанным ID в списке типов
        for (Type t : Data.types) {
            if (t.getId().toString().equals(id))
                type = t;
        }

        return type;
    }
}
