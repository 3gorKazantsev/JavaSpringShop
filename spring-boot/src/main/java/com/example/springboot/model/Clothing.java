package com.example.springboot.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Clothing extends Product {

    private String size;

    @Builder
    public Clothing(UUID id, String name, Type type, String size) {
        super(id, name, type);
        this.size = size;
    }
}
