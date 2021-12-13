package com.example.springboot.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
public class Footwear extends ProductBase {

    private int size;

    public Footwear(UUID id, String name, Category category, int size) {
        super(id, name, category);
        this.size = size;
    }
}
