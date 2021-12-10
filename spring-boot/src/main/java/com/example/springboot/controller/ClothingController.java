package com.example.springboot.controller;

import com.example.springboot.model.Clothing;
import com.example.springboot.service.ClothingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Clothing getClothingById(@PathVariable int id) {
        return clothingService.getClothingById(id);
    }

    @PostMapping("/new")
    public Clothing createClothing(@RequestBody Clothing clothing) {
        return clothingService.createClothing(clothing);
    }

    @PostMapping("/update")
    public Clothing updateClothing(@RequestBody Clothing clothing) {
        return clothingService.updateCategory(clothing);
    }

    @PostMapping("/del/{id}")
    public Clothing deleteClothingById(@PathVariable int id) {
        return clothingService.deleteClothingById(id);
    }
}
