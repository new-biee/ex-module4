package com.example.ex.service;

import java.util.Optional;

public interface IService<T, L> {
    Iterable<T> findAll();

    Optional<T> findById(L id);

    void save(T model);

    void deleteById(L id);
}
