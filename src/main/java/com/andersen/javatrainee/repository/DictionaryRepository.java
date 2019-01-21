package com.andersen.javatrainee.repository;

import com.andersen.javatrainee.model.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Repository

public class DictionaryRepository extends AbstractRepository<Dictionary> {

    @Autowired
    public DictionaryRepository(DataJpaDictionaryRepository dataJpaDictionaryRepository) {
        this.jpaRepository = dataJpaDictionaryRepository;
    }
}