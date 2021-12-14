package com.example.springboot.controller;

import com.example.springboot.model.hibernate.FootwearH;
import com.example.springboot.service.hibernate.FootwearServiceH;
import com.example.springboot.service.jdbc.FootwearService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/footwear")
@RequiredArgsConstructor
public class FootwearController {

    private final FootwearService footwearService;
    private final FootwearServiceH footwearServiceH;

    @GetMapping()
    public ResponseEntity<List<FootwearH>> getAllFootwear() {
        return footwearServiceH.getAllFootwear();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FootwearH> getFootwearById(@PathVariable UUID id) {
        return footwearServiceH.getFootwearById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<FootwearH> addFootwear(@RequestBody FootwearH footwear) {
        return footwearServiceH.createFootwear(footwear);
    }

    @PostMapping("/upd")
    public ResponseEntity<FootwearH> updateFootwear(@RequestBody FootwearH footwear) {
        return footwearServiceH.updateFootwear(footwear);
    }

    @PostMapping("/del/{id}")
    public ResponseEntity<FootwearH> deleteFootwearById(@PathVariable UUID id) {
        return footwearServiceH.deleteFootwearById(id);
    }
}
