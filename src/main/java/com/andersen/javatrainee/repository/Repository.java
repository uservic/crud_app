package com.andersen.javatrainee.repository;

import java.util.List;

public interface Repository<T> {

    T save(T user);

    T get(int id);

    void delete(int id);

    List<T> getAll();

}