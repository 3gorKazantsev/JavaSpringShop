package com.example.springboot.services;

import com.example.springboot.Data.Data;
import com.example.springboot.model.Clothing;

import java.util.UUID;

public class ClothingService {

    public Clothing add(Clothing clothing) {
        Data.products.add(clothing);
        return clothing;
    }

    public Clothing delete(Clothing clothing) {
        Data.products.remove(clothing);
        return clothing;
    }

    public Clothing edit(Clothing clothing) {
        // сравнение по ID
        UUID id = clothing.getId();
        for (int i = 0; i < Data.products.size(); i++) {
            if (id.equals(Data.products.get(i).getId())) {
                Data.products.remove(i);
                Data.products.add(i, clothing);
                break;
            }
        }

        return clothing;
    }
}