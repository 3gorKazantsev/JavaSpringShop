package com.example.springboot.controllers;

import com.example.springboot.model.Product;
import com.example.springboot.model.Type;
import com.example.springboot.services.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/product")
    public Product getProduct(
            @RequestParam(value = "id") String id
    ) {
        return service.findProductById(id);
    }

    @GetMapping("/types")
    public List<Type> types() {
        return service.getAllTypes();
    }

    @GetMapping("/type")
    public Type getType(
            @RequestParam(value = "id") String id
    ) {
        return service.findTypeById(id);
    }

    @GetMapping("/by_type")
    public List<Product> getProductsByType(
            @RequestParam(value = "type") Long typeId
    ) {
        return service.getProductsByType(typeId);
    }
}
