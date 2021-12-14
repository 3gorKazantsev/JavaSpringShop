package com.example.springboot.controller;

import com.example.springboot.model.hibernate.ClothingH;
import com.example.springboot.service.hibernate.ClothingServiceH;
import com.example.springboot.service.jdbc.ClothingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clothing")
@RequiredArgsConstructor
public class ClothingController {

    private final ClothingService clothingService;
    private final ClothingServiceH clothingServiceH;

    @GetMapping()
    public ResponseEntity<List<ClothingH>> getAllClothing() {
        return clothingServiceH.getAllClothing();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClothingH> getClothingById(@PathVariable UUID id) {
        return clothingServiceH.getClothingById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<ClothingH> createClothing(@RequestBody ClothingH clothing) {
        return clothingServiceH.createClothing(clothing);
    }

    @PostMapping("/upd")
    public ResponseEntity<ClothingH> updateClothing(@RequestBody ClothingH clothing) {
        return clothingServiceH.updateClothing(clothing);
    }

    @PostMapping("/del/{id}")
    public ResponseEntity<ClothingH> deleteClothingById(@PathVariable UUID id) {
        return clothingServiceH.deleteClothingById(id);
    }
}
