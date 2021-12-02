package com.example.springboot.controllers;

import com.example.springboot.Data.Data;
import com.example.springboot.model.Product;
import com.example.springboot.model.Type;
import com.example.springboot.services.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @GetMapping("/")
    public String start() {
        return "";
    }

    @GetMapping("/products")
    public List<Product> products() {
        return Service.getAllProducts();
    }

    @GetMapping("/product")
    public Product getProduct(
            @RequestParam(value = "id") String id
    ) {
        return Service.findProductById(id);
    }

    @GetMapping("/types")
    public List<Type> types() {
        return Service.getAllTypes();
    }

    @GetMapping("/type")
    public Type type(
            @RequestParam(value = "id") String id
    ) {
        return Service.findTypeById(id);
    }
}
