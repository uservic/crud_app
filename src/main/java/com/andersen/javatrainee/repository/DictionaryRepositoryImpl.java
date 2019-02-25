package com.andersen.javatrainee.repository;

import com.andersen.javatrainee.model.Dictionary;
import com.andersen.javatrainee.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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

    @Override
    public Role getRoleByName(String name) {
        return (Role) dataJpaDictionaryRepository.getRoleByName(name);
    }

    @Override
    public List<Role> getAllRoles() {
        return dataJpaDictionaryRepository.getAllRoles();
    }

}