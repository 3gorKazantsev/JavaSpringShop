package com.example.springboot.services;

import com.example.springboot.data.Data;
import com.example.springboot.model.Footwear;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FootwearService {

    public Footwear add(Footwear footwear) {
        Data.products.add(footwear);
        return footwear;
    }

    public Footwear delete(Footwear footwear) {
        Data.products.remove(footwear);
        return footwear;
    }

    public Footwear edit(Footwear footwear) {
        // сравнение по ID
        UUID id = footwear.getId();
        for (int i = 0; i < Data.products.size(); i++) {
            if (id.equals(Data.products.get(i).getId())) {
                Data.products.remove(i);
                Data.products.add(i, footwear);
                break;
            }
        }

        return footwear;
    }
}
