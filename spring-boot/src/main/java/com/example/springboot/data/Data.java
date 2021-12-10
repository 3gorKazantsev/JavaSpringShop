package com.example.springboot.data;

import com.example.springboot.model.Clothing;
import com.example.springboot.model.Footwear;
import com.example.springboot.model.Product;
import com.example.springboot.model.Category;

import java.util.ArrayList;
import java.util.UUID;

public class Data {

    public static ArrayList<Category> categories = new ArrayList<>() {
        {
            add(new Category(0, "Футболка"));
            add(new Category(1, "Рубашка"));
            add(new Category(2, "Брюки"));
            add(new Category(3, "Джинсы"));
            add(new Category(4, "Кроссовки"));
            add(new Category(5, "Ботинки"));
            add(new Category(6, "Туфли"));
        }
    };

    public static ArrayList<Product> products = new ArrayList<>() {
        {
            add(new Clothing(UUID.randomUUID(), "Рубашка Levis", categories.get(1), "M"));
            add(new Clothing(UUID.randomUUID(), "Брюки Zara", categories.get(2), "M"));
            add(new Footwear(UUID.randomUUID(), "Nike Cortez", categories.get(4), 42));
            add(new Footwear(UUID.randomUUID(), "Dr. Martens 1490", categories.get(5), 43));
            add(new Footwear(UUID.randomUUID(), "Reebok Classic", categories.get(4), 45));
        }
    };
}