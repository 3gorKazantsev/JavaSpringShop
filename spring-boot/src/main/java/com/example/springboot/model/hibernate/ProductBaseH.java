package com.example.springboot.model.hibernate;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class ProductBaseH {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private CategoryH category;
}
