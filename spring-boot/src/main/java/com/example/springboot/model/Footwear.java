package com.example.springboot.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString(callSuper = true)
public class Footwear extends Product {

    private int size;

    @Builder
    public Footwear(UUID id, String name, Type type, int size) {
        super(id, name, type);
        this.size = size;
    }
}
