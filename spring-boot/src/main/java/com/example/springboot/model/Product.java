package com.example.springboot.model;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Product {

    private UUID id;
    private String name;
    private Category category;

}
