package com.andersen.javatrainee.service;

import com.andersen.javatrainee.model.Dictionary;
import com.andersen.javatrainee.model.Role;
import com.andersen.javatrainee.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    private DictionaryRepository repository;

    @Autowired
    public DictionaryServiceImpl(DictionaryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Dictionary save(Dictionary dictionary) {
        return repository.save(dictionary);
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

    @Override
    public Role getRoleByName(String name) {
        return repository.getRoleByName(name);
    }

    @Override
    public List<Role> getAllRoles() {
        return repository.getAllRoles();
    }
}