package com.example.springboot.model.jdbc;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
public class Clothing extends ProductBase {

    private String size;

    public Clothing(UUID id, String name, Category category, String size) {
        super(id, name, category);
        this.size = size;
    }
}
