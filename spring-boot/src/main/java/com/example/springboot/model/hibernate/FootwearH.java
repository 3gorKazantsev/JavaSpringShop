package com.example.springboot.model.hibernate;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "footwear")
public class FootwearH extends ProductBaseH {

    @Column(name = "size")
    private int size;
}
