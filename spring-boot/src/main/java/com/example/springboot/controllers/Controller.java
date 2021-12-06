package com.example.springboot.controllers;

import com.example.springboot.model.Clothing;
import com.example.springboot.model.Product;
import com.example.springboot.model.Type;
import com.example.springboot.services.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private final Service service = new Service();

    @GetMapping("/")
    public String start() {
        return "";
    }

    @GetMapping("/products")
    public List<Product> products() {
        return service.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable String id) {
        return service.findProductById(id);
    }

    @GetMapping("/products/type/{typeId}")
    public List<Product> getProductsByType(@PathVariable Long typeId) {
        return service.getProductsByType(typeId);
    }

    @GetMapping("/types")
    public List<Type> types() {
        return service.getAllTypes();
    }

    @GetMapping("/types/{id}")
    public Type getType(@PathVariable String id) {
        return service.findTypeById(id);
    }

    @PostMapping("/products/new/{isFootwear}")
    public Product addProduct(@PathVariable boolean isFootwear) {
        return service.addClothing(isFootwear);
    }
}
