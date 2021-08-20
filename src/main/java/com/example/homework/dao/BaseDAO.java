package com.example.homework.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDAO<T> {
    List<T> findAll();
    T findById (int id);
    T save (T object);
    void update (T object);
    void deleteById (int id);
    void deleteByObject (T object);
}
