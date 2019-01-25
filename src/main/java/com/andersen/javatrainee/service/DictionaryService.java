package com.andersen.javatrainee.service;

import com.andersen.javatrainee.model.Dictionary;

import java.util.List;

public interface DictionaryService {

    Dictionary save(Dictionary dictionary);

    Dictionary get(int id);

    void delete(int id);

    List<Dictionary> getAll();

}