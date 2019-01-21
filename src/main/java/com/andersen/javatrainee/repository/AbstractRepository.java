package com.andersen.javatrainee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository

public abstract class AbstractRepository<T> implements Repository<T> {

    protected JpaRepository<T, Integer> jpaRepository;

    public T save(T user) {
        return jpaRepository.save(user);
    }

    public T get(int id) {
        return jpaRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        jpaRepository.deleteById(id);
    }

    public List<T> getAll() {
        return jpaRepository.findAll();
    }
}