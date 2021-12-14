package com.example.springboot.service.hibernate;

import com.example.springboot.model.hibernate.FootwearH;
import com.example.springboot.repository.FootwearRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FootwearServiceH {

    private final FootwearRepository repository;

    // get all
    public ResponseEntity<List<FootwearH>> getAllFootwear() {
        List<FootwearH> footwear = repository.findAll();

        if (footwear.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(footwear, HttpStatus.OK);
    }

    //get by id
    public ResponseEntity<FootwearH> getFootwearById(UUID id) {
        Optional<FootwearH> footwear = repository.findById(id);

        if (footwear.isPresent())
            return new ResponseEntity<>(footwear.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // create
    public ResponseEntity<FootwearH> createFootwear(FootwearH footwear) {
        return new ResponseEntity<>(repository.save(footwear), HttpStatus.OK);
    }

    // update
    public ResponseEntity<FootwearH> updateFootwear(FootwearH footwear) {
        if (repository.findById(footwear.getId()).isPresent())
            return new ResponseEntity<>(repository.save(footwear), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // delete
    public ResponseEntity<FootwearH> deleteFootwearById(UUID id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
