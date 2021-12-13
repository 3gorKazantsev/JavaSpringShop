package com.example.springboot.controller;

import com.example.springboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public Map<UUID, List<Object>> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Map<UUID, List<Object>> getProductById(@PathVariable UUID id) {
        return productService.getProductById(id);
    }
}
