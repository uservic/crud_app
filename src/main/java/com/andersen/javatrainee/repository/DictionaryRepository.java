package com.andersen.javatrainee.repository;

import com.andersen.javatrainee.model.Dictionary;
import com.andersen.javatrainee.model.Role;

import java.util.List;

public interface DictionaryRepository {

    Dictionary save(Dictionary dictionary);

    Dictionary get(int id);

    void delete(int id);

    List<Dictionary> getAll();

    Role getRoleByName(String name);

    List<Role>getAllRoles();

}