package com.andersen.javatrainee.service;

import com.andersen.javatrainee.model.Dictionary;
import com.andersen.javatrainee.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    private Repository<Dictionary> repository;

    @Autowired
    public DictionaryServiceImpl(Repository<Dictionary> repository) {
        this.repository = repository;
    }

    @Override
    public Dictionary save(Dictionary user) {
        return repository.save(user);
    }

    @Override
    public Dictionary get(int id) {
        return repository.get(id);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public List<Dictionary> getAll() {
        return repository.getAll();
    }
}
