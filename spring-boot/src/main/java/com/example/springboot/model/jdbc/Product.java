package com.example.springboot.model.jdbc;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Product extends ProductBase{

    private String size;

    public Product(UUID id, String name, Category category, String size) {
        super(id, name, category);
        this.size = size;
    }
}
