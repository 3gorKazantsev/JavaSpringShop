package com.example.springboot.model.hibernate;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "category")
public class CategoryH {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public CategoryH(String name) {
        this.name = name;
    }
}
