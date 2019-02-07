package com.andersen.javatrainee.repository.dtype;

import com.andersen.javatrainee.model.DictionaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class DTypeRepositoryImpl implements DTypeRepository {

    private DictionaryTypeRepository repository;

    @Autowired
    public DTypeRepositoryImpl(DictionaryTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Integer incrementAndGetCount(String dictType) {
        Objects.requireNonNull(dictType);
        DictionaryType type = repository.findByName(dictType.toLowerCase());
        Integer counter = type.getCounter();
        type.setCounter(++counter);
        repository.save(type);
        return counter;
    }

}