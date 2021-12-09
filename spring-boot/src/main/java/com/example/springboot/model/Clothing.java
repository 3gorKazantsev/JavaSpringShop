package com.example.springboot.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
public class Clothing extends Product {

    private String size;

    public Clothing(UUID id, String name, Type type, String size) {
        super(id, name, type);
        this.size = size;
    }
}
