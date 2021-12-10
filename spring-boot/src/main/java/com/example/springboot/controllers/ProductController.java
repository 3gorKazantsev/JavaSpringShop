package com.example.springboot.controllers;

import com.example.springboot.model.Product;
import com.example.springboot.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public String start() {
        return "";
    }

    @GetMapping("/products")
    public List<Product> products() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable String id) {
        return productService.findProductById(id);
    }

    @GetMapping("/products/type/{typeId}")
    public List<Product> getProductsByType(@PathVariable int typeId) {
        return productService.getProductsByType(typeId);
    }
}
