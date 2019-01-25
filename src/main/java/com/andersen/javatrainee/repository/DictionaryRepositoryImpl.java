package com.andersen.javatrainee.repository;

import com.andersen.javatrainee.model.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Repository

public class DictionaryRepositoryImpl implements DictionaryRepository {

    private DataJpaDictionaryRepository dataJpaDictionaryRepository;

    @Autowired
    public DictionaryRepositoryImpl(DataJpaDictionaryRepository dataJpaDictionaryRepository) {
        this.dataJpaDictionaryRepository = dataJpaDictionaryRepository;
    }

    @Override
    public Dictionary save(Dictionary dictionary) {
        return dataJpaDictionaryRepository.save(dictionary);
    }

    @Override
    public Dictionary get(int id) {
        return dataJpaDictionaryRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        dataJpaDictionaryRepository.deleteById(id);
    }

    @Override
    public List<Dictionary> getAll() {
        return dataJpaDictionaryRepository.findAll();
    }
}