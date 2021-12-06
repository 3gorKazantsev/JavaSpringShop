package com.example.springboot.services;

import com.example.springboot.Data.Data;
import com.example.springboot.model.Clothing;

public class ClothingService {

    public Clothing addClothing(Clothing clothing) {
        Data.products.add(clothing);
        return clothing;
    }

    public Clothing delClothing(Clothing clothing) {
        Data.products.remove(clothing);
        return clothing;
    }
}
