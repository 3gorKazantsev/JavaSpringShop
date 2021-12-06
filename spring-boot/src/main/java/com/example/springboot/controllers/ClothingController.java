package com.example.springboot.controllers;

import com.example.springboot.model.Clothing;
import com.example.springboot.services.ClothingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clothing")
public class ClothingController {

    private final ClothingService clothingService = new ClothingService();

    @PostMapping("/new")
    public Clothing addClothing(@RequestBody Clothing clothing) {
        return clothingService.addClothing(clothing);
    }

    @PostMapping("/del")
    public Clothing delClothing(@RequestBody Clothing clothing) {
        return clothingService.delClothing(clothing);
    }
}
