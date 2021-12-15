package com.example.springboot.service.hibernate;

import com.example.springboot.model.hibernate.ProductH;
import com.example.springboot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceH {

    private final ProductRepository repository;

    // get all
    public ResponseEntity<List<ProductH>> getAllProduct() {
        List<ProductH> products = repository.findAll();

        if (products.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // get by id
    public ResponseEntity<ProductH> getProductById(UUID id) {
        Optional<ProductH> product = repository.findById(id);

        if (product.isPresent())
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
