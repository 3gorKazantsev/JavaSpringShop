package com.example.springboot.service.hibernate;

import com.example.springboot.model.hibernate.ClothingH;
import com.example.springboot.repository.ClothingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClothingServiceH {

    private final ClothingRepository repository;

    // get all
    public ResponseEntity<List<ClothingH>> getAllClothing() {
        List<ClothingH> clothing = repository.findAll();

        if (clothing.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(clothing, HttpStatus.OK);
    }

    // get by id
    public ResponseEntity<ClothingH> getClothingById(UUID id) {
        Optional<ClothingH> clothing = repository.findById(id);

        if (clothing.isPresent())
            return new ResponseEntity<>(clothing.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // create
    public ResponseEntity<ClothingH> createClothing(ClothingH clothing) {
        return new ResponseEntity<>(repository.save(clothing), HttpStatus.OK);
    }

    // update
    public ResponseEntity<ClothingH> updateClothing(ClothingH clothing) {
        if (repository.findById(clothing.getId()).isPresent())
            return new ResponseEntity<>(repository.save(clothing), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // delete
    public ResponseEntity<ClothingH> deleteClothingById(UUID id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
