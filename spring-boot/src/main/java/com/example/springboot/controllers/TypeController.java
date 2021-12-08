package com.example.springboot.controllers;

import com.example.springboot.model.Type;
import com.example.springboot.services.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/type")
public class TypeController {

    private final TypeService typeService;

    @GetMapping("/")
    public List<Type> types() {
        return typeService.getAllTypes();
    }

    @GetMapping("/{id}")
    public Type getType(@PathVariable int id) {
        return typeService.findTypeById(id);
    }
}
