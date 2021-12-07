package com.example.springboot.controllers;

import com.example.springboot.model.Footwear;
import com.example.springboot.services.FootwearService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/footwear")
@RequiredArgsConstructor
public class FootwearController {

    private final FootwearService footwearService;

    @PostMapping("/new")
    public Footwear addFootwear(@RequestBody Footwear footwear) {
        return footwearService.add(footwear);
    }

    @PostMapping("/del")
    public Footwear delFootwear(@RequestBody Footwear footwear) {
        return footwearService.delete(footwear);
    }

    @PostMapping("/edit")
    public Footwear editFootwear(@RequestBody Footwear footwear) {
        return footwearService.edit(footwear);
    }
}
