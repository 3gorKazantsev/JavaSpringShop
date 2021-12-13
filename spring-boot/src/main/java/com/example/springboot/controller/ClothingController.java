package com.example.springboot.controller;

import com.example.springboot.model.jdbc.Clothing;
import com.example.springboot.service.jdbc.ClothingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clothing")
@RequiredArgsConstructor
public class ClothingController {

    private final ClothingService clothingService;

    @GetMapping()
    public List<Clothing> getAllClothing() {
        return clothingService.getAllClothing();
    }

    @GetMapping("/{id}")
    public Clothing getClothingById(@PathVariable UUID id) {
        return clothingService.getClothingById(id);
    }

    @PostMapping("/new")
    public Clothing createClothing(@RequestBody Clothing clothing) {
        return clothingService.createClothing(clothing);
    }

    @PostMapping("/upd")
    public Clothing updateClothing(@RequestBody Clothing clothing) {
        return clothingService.updateCategory(clothing);
    }

    @PostMapping("/del/{id}")
    public Clothing deleteClothingById(@PathVariable UUID id) {
        return clothingService.deleteClothingById(id);
    }
}
