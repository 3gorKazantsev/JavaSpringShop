package com.example.springboot.controller;

import com.example.springboot.model.hibernate.ProductH;
import com.example.springboot.model.jdbc.Product;
import com.example.springboot.service.hibernate.ProductServiceH;
import com.example.springboot.service.jdbc.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductServiceH productServiceH;

    @GetMapping()
    public ResponseEntity<List<ProductH>> getAllProduct() {
        return productServiceH.getAllProduct();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductH> getProductById(@PathVariable UUID id) {
        return productServiceH.getProductById(id);
    }
}
