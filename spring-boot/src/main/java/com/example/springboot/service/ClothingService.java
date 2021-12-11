package com.example.springboot.service;

import com.example.springboot.dao.ClothingDao;
import com.example.springboot.model.Clothing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClothingService {

    private final ClothingDao clothingDao;

    public List<Clothing> getAllClothing() {
        return clothingDao.getAll();
    }

    public Clothing getClothingById(UUID id) {
        return clothingDao.getById(id);
    }

    public Clothing createClothing(Clothing clothing) {
        return clothingDao.create(clothing);
    }

    public Clothing updateCategory(Clothing clothing) {
        return clothingDao.update(clothing);
    }

    public Clothing deleteClothingById(UUID id) {
        return clothingDao.deleteById(id);
    }
}