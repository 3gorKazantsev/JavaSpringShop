package com.example.springboot.model.hibernate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Immutable
@Subselect("""
    SELECT id, name, category_id, size FROM clothing
    UNION 
    SELECT id, name, category_id, size::varchar FROM footwear
""")
@Table(name = "product")
public class ProductH extends ProductBaseH {

    @Column(name = "size")
    private String size;
}
