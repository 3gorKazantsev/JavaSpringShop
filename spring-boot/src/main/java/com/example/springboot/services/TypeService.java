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

    public List<Type> getAllTypes() {
        return typeDao.getAllTypes();
    }

    public Type findTypeById(int id) {
        return typeDao.findTypeById(id);
    }
}
