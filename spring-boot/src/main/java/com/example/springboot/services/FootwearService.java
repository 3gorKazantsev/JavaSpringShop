package com.example.springboot.services;

import com.example.springboot.Data.Data;
import com.example.springboot.model.Footwear;

public class FootwearService {

    public Footwear addFootwear(Footwear footwear) {
        Data.products.add(footwear);
        return footwear;
    }

    public Footwear delFootwear(Footwear footwear) {
        Data.products.remove(footwear);
        return footwear;
    }
}
