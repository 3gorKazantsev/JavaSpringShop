package com.example.springboot.data;

import com.example.springboot.model.Clothing;
import com.example.springboot.model.Footwear;
import com.example.springboot.model.Product;
import com.example.springboot.model.Type;

import java.util.ArrayList;
import java.util.UUID;

public class Data {

    public static ArrayList<Type> types = new ArrayList<>() {
        {
            add(new Type(0, "Футболка"));
            add(new Type(1, "Рубашка"));
            add(new Type(2, "Брюки"));
            add(new Type(3, "Джинсы"));
            add(new Type(4, "Кроссовки"));
            add(new Type(5, "Ботинки"));
            add(new Type(6, "Туфли"));
        }
    };

    public static ArrayList<Product> products = new ArrayList<>() {
        {
            add(Clothing.builder()
                    .id(UUID.randomUUID())
                    .name("Рубашка Levis")
                    .type(types.get(1))
                    .size("M")
                    .build());
            add(Clothing.builder()
                    .id(UUID.randomUUID())
                    .name("Брюки Zara")
                    .type(types.get(2))
                    .size("M")
                    .build());
            add(Footwear.builder()
                    .id(UUID.randomUUID())
                    .name("Nike Cortez")
                    .type(types.get(4))
                    .size(42)
                    .build());
            add(Footwear.builder()
                    .id(UUID.randomUUID())
                    .name("Dr. Martens 1490")
                    .type(types.get(5))
                    .size(43)
                    .build());
            add(Footwear.builder()
                    .id(UUID.randomUUID())
                    .name("Reebok Classic")
                    .type(types.get(4))
                    .size(45)
                    .build());
        }
    };
}