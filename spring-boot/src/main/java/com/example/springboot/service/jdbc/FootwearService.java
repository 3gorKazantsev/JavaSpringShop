package com.example.springboot.service.jdbc;

import com.example.springboot.dao.FootwearDao;
import com.example.springboot.model.jdbc.Footwear;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FootwearService {

    private final FootwearDao footwearDao;

    public List<Footwear> getAllClothing() {
        return footwearDao.getAll();
    }

    public Footwear getFootwearById(UUID id) {
        return footwearDao.getById(id);
    }

    public Footwear createClothing(Footwear footwear) {
        return footwearDao.create(footwear);
    }

    public Footwear updateFootwear(Footwear footwear) {
        return footwearDao.update(footwear);
    }

    public Footwear deleteFootwearById(UUID id) {
        return footwearDao.delete(id);
    }
}
