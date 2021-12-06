package com.example.springboot.controllers;

import com.example.springboot.model.Footwear;
import com.example.springboot.services.FootwearService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/footwear")
public class FootwearController {

    private final FootwearService footwearService = new FootwearService();

    @PostMapping("/new")
    public Footwear addFootwear(@RequestBody Footwear footwear) {
        return footwearService.addFootwear(footwear);
    }

    @PostMapping("/del")
    public Footwear delFootwear(@RequestBody Footwear footwear) {
        return footwearService.delFootwear(footwear);
    }
}
