package com.example.springboot.controllers;

import com.example.springboot.model.Product;
import com.example.springboot.model.Type;
import com.example.springboot.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService = new ProductService();

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
    public List<Product> getProductsByType(@PathVariable Long typeId) {
        return productService.getProductsByType(typeId);
    }

    @GetMapping("/types")
    public List<Type> types() {
        return productService.getAllTypes();
    }

    @GetMapping("/types/{id}")
    public Type getType(@PathVariable String id) {
        return productService.findTypeById(id);
    }
}
