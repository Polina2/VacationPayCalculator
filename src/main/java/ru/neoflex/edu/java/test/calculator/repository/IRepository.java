package ru.neoflex.edu.java.test.calculator.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    void add(T object);
    void remove(T object);
}
