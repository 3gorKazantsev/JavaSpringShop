package com.example.springboot.controllers;

import com.example.springboot.model.Clothing;
import com.example.springboot.services.ClothingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clothing")
@RequiredArgsConstructor
public class ClothingController {

    private final ClothingService clothingService;

    @PostMapping("/new")
    public Clothing addClothing(@RequestBody Clothing clothing) {
        return clothingService.add(clothing);
    }

    @PostMapping("/del")
    public Clothing delClothing(@RequestBody Clothing clothing) {
        return clothingService.delete(clothing);
    }

    @PostMapping("/edit")
    public Clothing editClothing(@RequestBody Clothing clothing) {
        return clothingService.edit(clothing);
    }
}
