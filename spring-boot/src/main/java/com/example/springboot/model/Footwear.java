package com.example.springboot.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
public class Footwear extends Product {

    private int size;

    public Footwear(UUID id, String name, Type type, int size) {
        super(id, name, type);
        this.size = size;
    }
}
