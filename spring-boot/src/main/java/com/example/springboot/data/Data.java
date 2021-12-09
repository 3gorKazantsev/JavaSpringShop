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
            add(new Clothing(UUID.randomUUID(), "Рубашка Levis", types.get(1), "M"));
            add(new Clothing(UUID.randomUUID(), "Брюки Zara", types.get(2), "M"));
            add(new Footwear(UUID.randomUUID(), "Nike Cortez", types.get(4), 42));
            add(new Footwear(UUID.randomUUID(), "Dr. Martens 1490", types.get(5), 43));
            add(new Footwear(UUID.randomUUID(), "Reebok Classic", types.get(4), 45));
        }
    };
}