package com.andersen.javatrainee.repository;

import com.andersen.javatrainee.model.Dictionary;

import java.util.List;

public interface DictionaryRepository {

    Dictionary save(Dictionary dictionary);

    Dictionary get(int id);

    void delete(int id);

    List<Dictionary> getAll();

}