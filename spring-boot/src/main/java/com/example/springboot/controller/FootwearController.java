package com.example.springboot.controller;

import com.example.springboot.model.Footwear;
import com.example.springboot.service.FootwearService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/footwear")
@RequiredArgsConstructor
public class FootwearController {

    private final FootwearService footwearService;

    @GetMapping()
    public List<Footwear> getAllFootwear() {
        return footwearService.getAllClothing();
    }

    @GetMapping("/{id}")
    public Footwear getFootwearById(@PathVariable UUID id) {
        return footwearService.getFootwearById(id);
    }

    @PostMapping("/new")
    public Footwear addFootwear(@RequestBody Footwear footwear) {
        return footwearService.createClothing(footwear);
    }

    @PostMapping("/upd")
    public Footwear updateFootwear(@RequestBody Footwear footwear) {
        return footwearService.updateFootwear(footwear);
    }

    @PostMapping("/del/{id}")
    public Footwear deleteFootwearById(@PathVariable UUID id) {
        return footwearService.deleteFootwearById(id);
    }
}
