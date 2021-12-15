package com.example.springboot.model.hibernate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Immutable
@Table(name = "product")
public class ProductH extends ProductBaseH {

    @Column(name = "size")
    private String size;
}
