package com.example.springboot.services;

import com.example.springboot.dao.TypeDao;
import com.example.springboot.model.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeService {

    private final TypeDao typeDao;

    public List<Type> getAll() {
        return typeDao.getAll();
    }

    public Type getById(int id) {
        return typeDao.getById(id);
    }

    public Type create(Type type) {
        return typeDao.create(type);
    }

    public Type update(Type type) {
        return typeDao.update(type);
    }

    public Type delete(int id) {
        return typeDao.delete(id);
    }
}
