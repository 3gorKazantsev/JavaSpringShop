package com.example.springboot.controllers;

import com.example.springboot.model.Type;
import com.example.springboot.services.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/type")
public class TypeController {

    private final TypeService typeService;

    @GetMapping()
    public List<Type> getAll() {
        return typeService.getAll();
    }

    @GetMapping("/{id}")
    public Type getById(@PathVariable int id) {
        return typeService.getById(id);
    }

    @PostMapping("/new")
    public Type createType(@RequestBody Type type) {
        return typeService.create(type);
    }

    @PostMapping("/update")
    public Type updateType(@RequestBody Type type) {
        return typeService.update(type);
    }

    @PostMapping("/del/{id}")
    public Type deleteType(@PathVariable int id) {
        return typeService.delete(id);
    }
}
